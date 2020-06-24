package com.ewolff.microservice.articulo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ewolff.microservice.articulo.entities.Articulo;
import com.ewolff.microservice.articulo.repositories.ArticuloRepository;

@Service
public class ArticuloServiceImpl implements ArticuloService {

	@Autowired
	private ArticuloRepository articuloRepository;

	@Autowired
	private KafkaTemplate<String, Articulo> kafkaTemplate;

	@Override
	public Articulo grabarArticulo(Articulo articulo) throws Exception {
		Articulo result = articuloRepository.save(articulo);
		fireOrderCreatedEvent(articulo);
		return result;
	}

	private void fireOrderCreatedEvent(Articulo order) {
		kafkaTemplate.send("articulo", order.getArticuloId() + "created", order);
	}
}