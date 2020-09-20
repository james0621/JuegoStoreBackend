package com.videojuego.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videojuego.app.interfaceService.IjuegoService;
import com.videojuego.app.interfaces.IJuego;
import com.videojuego.app.modelo.Juego;

@Service
public class JuegoService implements IjuegoService{

	@Autowired
	private IJuego data;

	@Override
	public List<Juego> listar() {
		return data.findAll();
	}

	@Override
	public Juego JuegoPorId(Long id) {
		return data.findById(id);
	}

	@Override
	public Juego save(Juego juego) {
		return data.save(juego);
	}

	@Override
	public Juego delete(Long id) {
		Juego j = data.findById(id);
		if(j != null) {
			data.delete(j);
		}
		
		return data.delete(j);
		
	}

	@Override
	public List<Juego> buscarPorNombre(String termino) {
		return data.buscarPorNombre(termino);
	}

	@Override
	@Transactional
	public int actualizarCantidad(Long id) {
		return data.actualizarCantidad(id);
	}
	
	

}
