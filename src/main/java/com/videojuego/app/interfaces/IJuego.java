package com.videojuego.app.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.videojuego.app.modelo.Juego;

@Repository
public interface IJuego extends CrudRepository<Juego, Long>{

}
