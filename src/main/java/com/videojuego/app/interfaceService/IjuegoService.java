package com.videojuego.app.interfaceService;

import java.util.List;
import java.util.Optional;

import com.videojuego.app.modelo.Juego;

public interface IjuegoService {
	
	public List<Juego> listar();
	public Optional<Juego> listarId(Long id);
	public int save(Juego juego);
	public void delete(Long id);
}
