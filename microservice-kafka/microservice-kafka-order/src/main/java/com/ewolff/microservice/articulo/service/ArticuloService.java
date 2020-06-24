package com.ewolff.microservice.articulo.service;

import com.ewolff.microservice.articulo.entities.Articulo;

public interface ArticuloService {
	public Articulo grabarArticulo(Articulo articulo) throws Exception;
}