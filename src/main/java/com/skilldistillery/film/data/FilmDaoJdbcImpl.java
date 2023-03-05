package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class FilmDaoJdbcImpl implements FilmDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String user = "student";
	private static final String pass = "student";

	public FilmDaoJdbcImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

	public Actor createActor(Actor actor) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "INSERT INTO actor (first_name, last_name) " + " VALUES (?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, actor.getFirstName());
			stmt.setString(2, actor.getLastName());
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newActorId = keys.getInt(1);
					actor.setId(newActorId);
					if (actor.getFilms() != null && actor.getFilms().size() > 0) {
						sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
						stmt = conn.prepareStatement(sql);
						for (Film film : actor.getFilms()) {
							stmt.setInt(1, film.getId());
							stmt.setInt(2, newActorId);
							updateCount = stmt.executeUpdate();
						}
					}
				}
			} else {
				actor = null;
			}
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error inserting actor " + actor);
		}
		return actor;
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;

		List<Actor> actors = new ArrayList<>();
		try {
			Connection conn;
			conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, title, description, release_year,"
					+ "language_id, rental_duration, rental_rate, length, replacement_cost, rating,"
					+ "special_features FROM film WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet filmResult = stmt.executeQuery();

			if (filmResult.next()) {
				film = new Film(); // Create the object
				// Here is our mapping of query columns to our object fields:
				film.setId(filmResult.getInt("id"));
				film.setTitle(filmResult.getString("title"));
				film.setDescription(filmResult.getString("description"));
				film.setReleaseYear(filmResult.getInt("release_year"));
				film.setLanguageId(filmResult.getInt("language_id"));
				film.setRentalDuration(filmResult.getInt("rental_duration"));
				film.setRentalRate(filmResult.getDouble("rental_rate"));
				film.setLength(filmResult.getInt("length"));
				film.setReplacementCost(filmResult.getDouble("replacement_cost"));
				film.setRating(filmResult.getString("rating"));
				film.setSpecialFeature(filmResult.getString("special_features"));
				film.setLanguage(filmResult.getString("language.name"));
				film.setCategory(filmResult.getString("category.name"));
				actors = findActorsByFilmId(film.getId());
				film.setActorList(actors);

			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return film;
	}

	public List<Film> displayFilms() {
		List<Film> films = new ArrayList<>();
		List<Actor> actors = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT first_name ,last_name, actor.id,film_id  FROM actor JOIN film_actor ON actor.id = actor_id "
					+ "+JOIN film ON film_id = film.id;";
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Integer filmId = rs.getInt("id");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				Integer releaseYear = rs.getInt("release_year");
				Integer langId = rs.getInt("language_id");
				Integer rentDur = rs.getInt("rental_duration");
				Double rate = rs.getDouble("rental_rate");
				Integer length = rs.getInt("length");
				Double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String features = rs.getString("special_features");

				Film film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
						features);
				films.add(film);
				actors = findActorsByFilmId(film.getId());
				film.setActorList(actors);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;

		try {
			Connection conn;
			conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet actorResult = stmt.executeQuery();
			if (actorResult.next()) {
				actor = new Actor(); // Create the object
				// Here is our mapping of query columns to our object fields:
				actor.setId(actorResult.getInt("id"));
				actor.setFirstName(actorResult.getString("first_name"));
				actor.setLastName(actorResult.getString("last_name"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmIde) {
		// TODO Auto-generated method stub
		List<Actor> actorList = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT first_name ,last_name, actor.id,film_id  FROM actor  JOIN film_actor ON actor.id = actor_id "
					+ "JOIN film ON film_id = film.id WHERE film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmIde);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");

				Actor actor = new Actor(id, fname, lname);
				actorList.add(actor);
				
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actorList;

	}

	public List<Film> findFilmsByActorId(int actorId) {
		List<Film> films = new ArrayList<>();
		List<Actor> actors = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT first_name ,last_name, actor.id,film_id  FROM actor JOIN film_actor ON actor.id = actor_id "
					+ "+JOIN film ON film_id = film.id WHERE actor.id = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Integer filmId = rs.getInt("id");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				Integer releaseYear = rs.getInt("release_year");
				Integer langId = rs.getInt("language_id");
				Integer rentDur = rs.getInt("rental_duration");
				Double rate = rs.getDouble("rental_rate");
				Integer length = rs.getInt("length");
				Double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String features = rs.getString("special_features");

				Film film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
						features);
				films.add(film);
				actors = findActorsByFilmId(film.getId());
				film.setActorList(actors);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	public List<Film> findFilmsByKeyword(String word) {
		List<Film> films = new ArrayList<>();
		List<Actor> actors = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT film.id,category.name, title ,description ,release_year , language_id , rental_duration, rental_rate,length ,";
			sql += " replacement_cost, rating,special_features, language.name  FROM film JOIN language ON language.id=language_id JOIN film_category ON film.id = film_id JOIN category ON category.id = category_id WHERE film.title LIKE ? OR film.description LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, "%" + word + "%");
			stmt.setString(2, "%" + word + "%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Integer filmId = rs.getInt("film.id");
				String title = rs.getString("title");
				String desc = rs.getString("description");
				Integer releaseYear = rs.getInt("release_year");
				Integer langId = rs.getInt("language_id");
				Integer rentDur = rs.getInt("rental_duration");
				Double rate = rs.getDouble("rental_rate");
				Integer length = rs.getInt("length");
				Double repCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String features = rs.getString("special_features");
				String language = rs.getString("language.name");
				String category = rs.getString("category.name");
				Film film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
						features, language);
				film.setCategory(category);
				films.add(film);
				actors = findActorsByFilmId(film.getId());
				film.setActorList(actors);

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	public boolean saveActor(Actor actor) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "UPDATE actor SET first_name=?, last_name=? " + " WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, actor.getFirstName());
			stmt.setString(2, actor.getLastName());
			stmt.setInt(3, actor.getId());
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				// Replace actor's film list
				sql = "DELETE FROM film_actor WHERE actor_id = ?";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, actor.getId());
				updateCount = stmt.executeUpdate();
				sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
				stmt = conn.prepareStatement(sql);
				for (Film film : actor.getFilms()) {
					stmt.setInt(1, film.getId());
					stmt.setInt(2, actor.getId());
					updateCount = stmt.executeUpdate();
				}
				conn.commit(); // COMMIT TRANSACTION
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} // ROLLBACK TRANSACTION ON ERROR
				catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

	public boolean deleteActor(Actor actor) {
		Connection conn = null;
		try {

			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "DELETE FROM film_actor WHERE actor_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actor.getId());
			int updateCount = stmt.executeUpdate();
			sql = "DELETE FROM actor WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actor.getId());
			updateCount = stmt.executeUpdate();
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

	@Override
	public Film createFilm(Film film) {
		Connection conn = null;
		try {

			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features) \n"
					+ "VALUES (?, ?,?, ?, ?, ?, ?, ?, ?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getSpecialFeature());

			int updateCount = stmt.executeUpdate();
			conn.commit();
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newFilmId = keys.getInt(1);
					film.setId(newFilmId);

				}
			}

		} catch (Exception e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			System.out.println(e);
		}
		return film;

	}

	@Override
	public boolean deleteFilm(int filmId) {
		boolean success = false;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);

			// First, delete any child records from other tables
			String sql = "DELETE FROM film_actor WHERE film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			int rowsDeleted = stmt.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println(rowsDeleted + " film_actor records deleted.");
			}

			// Then delete the film record from the film table
			sql = "DELETE FROM film WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			rowsDeleted = stmt.executeUpdate();
			if (rowsDeleted == 1) {
				System.out.println("Film with ID " + filmId + " deleted successfully.");
				success = true;
			} else {
				System.out.println("No film records deleted.");
			}

			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.err.println("Error trying to rollback");
				}
			}
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public Film updateFilm(int filmId, Film film) {
		// TODO Auto-generated method stub
		return null;
	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver");
			throw new RuntimeException("Unable to load MySQL Driver class");
		}
	}

	@Override
	public List<Film> findFilmByActorId(int filmId) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Film> searchFilmByKeyWord(String keyword) {
//		List<Film> films = new ArrayList<>();
//		List<Actor> actors;
//
//		String sql = "SELECT film.*, lang.name " + "FROM film JOIN language lang " + "ON lang.id = film.language_id "
//				+ "WHERE title LIKE ? OR  description LIKE ?";
//		try {
//			Connection conn;
//			conn = DriverManager.getConnection(URL, user, pass);
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setString(1, "%" + keyword + "%");
//			stmt.setString(2, "%" + keyword + "%");
//			ResultSet rs = stmt.executeQuery();
//
//			while (rs.next()) {
//				String title = rs.getString("title");
//				String desc = rs.getString("description");
//				Integer releaseYear = rs.getInt("release_year");
//				String lang = rs.getString("name");
//				Integer id = rs.getInt("id");
//
//				Film film = new Film(title, desc, releaseYear, lang);
//				film.setId(id);
//				films.add(film);
//			}
//			rs.close();
//			stmt.close();
//			conn.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
//		return films;
//	}

}
