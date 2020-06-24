package com.ewolff.microservice.articulo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ewolff.microservice.articulo.entities.Articulo;
import com.ewolff.microservice.articulo.service.ArticuloService;

@Controller
public class ArticuloController {

	private final Logger logger = LoggerFactory.getLogger(ArticuloController.class);
	@Autowired
	private ArticuloService articuloService;

	@RequestMapping(value = "/articulo", method = RequestMethod.POST)
	public ModelAndView grabarArticulo(Articulo articulo) {
		try {
			articulo = articuloService.grabarArticulo(articulo);
		} catch (Exception e) {
			logger.error("Could not send articulo", e);
		}
		return new ModelAndView("success");
	}

}