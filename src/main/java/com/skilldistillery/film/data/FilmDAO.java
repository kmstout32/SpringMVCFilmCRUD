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

	public List<Film> searchFilmByKeyWord(String keyword);

	Film createFilm(Film film);

	Film updateFilm(int filmId, Film film);

	boolean deleteFilm(Film film);
}
