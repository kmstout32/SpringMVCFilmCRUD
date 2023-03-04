package com.skilldistillery.film.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
@Autowired
 private FilmDAO filmDao;

//@RequestMapping(path = {"/","home.do"})
//public String goHome(Model model) throws SQLException {
//	Film TEST =  filmDao.findFilmById(1);
//	model.addAttribute("TESTFILM",TEST);
//	return "home";
//}
@RequestMapping(path = {"filmId.do"})
public String findByFilmID(Model model,Integer id)  {
	Film film =  filmDao.findFilmById(id);
	if(film != null) {
	model.addAttribute(film);
	return "filmID";
	}else {
		return "error";
	}
	
	
}


}
