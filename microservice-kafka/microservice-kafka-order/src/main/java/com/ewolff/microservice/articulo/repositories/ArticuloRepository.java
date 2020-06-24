package com.ewolff.microservice.articulo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ewolff.microservice.articulo.entities.Articulo;

@RepositoryRestResource(exported = false)
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {

}