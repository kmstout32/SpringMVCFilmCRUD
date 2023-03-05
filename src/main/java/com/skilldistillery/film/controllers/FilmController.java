package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
			model.addAttribute("film", film);
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

	@RequestMapping(path = "filmId.do", method = RequestMethod.POST)
	public String createFilm(Model model, Film film) {
		Film createdFilm = filmDao.createFilm(film);
		if (createdFilm != null) {
			model.addAttribute(createdFilm);
			return "filmID";
		} else {
			return "error";
		}

	}

	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.POST)
	public String deleteFilm(Integer id, Model model) {
		boolean filmDeleted = filmDao.deleteFilm(id);
		if (filmDeleted) {
			model.addAttribute("message", "Film with ID " + id + " deleted successfully.");
		} else {
			model.addAttribute("message", "Failed to delete film with ID " + id + ".");
		}
		return "deleteFilm";
	}
	


	

	@RequestMapping(path = "keywordFilm.do", method = RequestMethod.GET)
	public String searchFilmByKeyword(Model model, String keyword) {
		List<Film> films = filmDao.findFilmsByKeyword(keyword);
		if (films != null) {
			model.addAttribute("film", films);
			return "keywordFilms";
		} else {
			return "error";
		}

	}
	@RequestMapping(path = "updateFilm.do", method= RequestMethod.POST)
	public String updateFilm(Model model, Integer id) {
		
		return "updateFilm";
		
	}

}
