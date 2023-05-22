package com.laptrinhweb.controller.client;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhweb.service.IGenreService;

@Controller
public class BaseController {

	@Autowired
	private IGenreService genreService;
	protected ModelAndView mvShare = new ModelAndView();

	// phương thức này khi các controller khác extends thì phương thức này sẽ được
	// chạy đầu tiên
	@PostConstruct
	public ModelAndView init() {

		mvShare.addObject("genres", genreService.getAllGenre());

		return mvShare;
	}
}
