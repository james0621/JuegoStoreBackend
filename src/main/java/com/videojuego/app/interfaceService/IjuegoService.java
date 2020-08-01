package com.videojuego.app.interfaceService;

import java.util.List;

import com.videojuego.app.modelo.Juego;

public interface IjuegoService {
	
	public List<Juego> listar();
	public Juego JuegoPorId(Long id);
	public Juego save(Juego juego);
	public Juego delete(Long id);
}
