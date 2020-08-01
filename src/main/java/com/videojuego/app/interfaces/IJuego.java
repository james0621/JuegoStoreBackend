package com.videojuego.app.interfaces;



import java.util.List;

import org.springframework.data.repository.Repository;

import com.videojuego.app.modelo.Juego;

public interface IJuego extends Repository<Juego, Long>{
	
	List<Juego> findAll();
	Juego findById(Long id);
	Juego save(Juego juego);
	Juego delete(Juego juego);
}
