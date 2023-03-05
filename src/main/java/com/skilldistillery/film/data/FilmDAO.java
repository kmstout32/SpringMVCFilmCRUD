package com.skilldistillery.film.data;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	public Film findFilmById(int filmId);

	public Actor findActorById(int actorId);

	public List<Actor> findActorsByFilmId(int filmId);

	public List<Film> findFilmByActorId(int filmId);

	public List<Film> findFilmsByKeyword(String word);

	Film createFilm(Film film);

	public boolean updateFilm(Integer id, Film film);

	public boolean deleteFilm(int filmId);


}
