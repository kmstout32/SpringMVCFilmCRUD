package com.skilldistillery.film.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
@Autowired
	private FilmDAO filmDao;

	@RequestMapping(path = { "/", "home.do" })
	public String goHome(Model model) throws SQLException {

		return "home";
	}

	@RequestMapping(path = { "filmId.do" })
	public String findByFilmID(Model model, Integer id) {
		Film film = filmDao.findFilmById(id);
		if (film != null) {
			model.addAttribute(film);
			return "filmID";
		} else {
			return "error";
		}

	}

//	@RequestMapping(path = { "film.do" })
//	public String createFilm(Model model, Film film) {
//		Film filmCreate = new Film (0, "fdsa", "fdsa", 1996, 5, 6, 2.6, 5, 9.9, "G", "Trailers");
//Test Method
//	@RequestMapping(path = { "film.do" })
//	public String createFilm(Model model, Film film) {
//		Film filmCreate = new Film (0, "fdsa", "fdsa", 1996, 5, 6, 2.6, 5, 9.9, "G", "Trailers","h","h");
//		Film filmCreated = filmDao.createFilm(filmCreate);
//		model.addAttribute(filmCreated);
//		return "filmID";
//	}

	
	@RequestMapping(path = "filmId.do", method =RequestMethod.POST)
	public String createFilm(Model model, Film film) {
		Film createdFilm = filmDao.createFilm(film);
		if (film != null) {
			model.addAttribute(createdFilm);
			return "filmID";
		} else {
			return "error";
		}

	}
	
	

}
