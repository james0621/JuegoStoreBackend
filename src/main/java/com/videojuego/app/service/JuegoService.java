package com.videojuego.app.service;

import java.util.List;
import java.util.Optional;

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
		
		return (List<Juego>)data.findAll();
	}

	@Override
	public Optional<Juego> listarId(Long id) {
		return null;
	}

	@Override
	public int save(Juego juego) {
		int resp = 0;
		Juego j = data.save(juego);
		
		if(j != null){
			resp = 1;
		}
			
		return 0;
	}

	@Override
	public void delete(Long id) {
		data.deleteById(id);
		
	}

}
