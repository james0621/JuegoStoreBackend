package com.videojuego.app.controlador;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videojuego.app.interfaceService.IjuegoService;
import com.videojuego.app.modelo.Juego;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/juego")
public class ControladorJuego {
	
	@Autowired
	private IjuegoService service;
	
	@GetMapping
	public List<Juego> listar(){
		return service.listar();
	}
	
	@PostMapping
	public Juego guardar(@RequestBody Juego juego){
		return service.save(juego);
	}
	
	@GetMapping(path = {"/{id}"})
	public Juego buscarPorId(@PathVariable Long id) {
		return service.JuegoPorId(id);
	}
	
	@PutMapping(path={"/{id}"})
	public Juego editar(@RequestBody Juego juego,@PathVariable Long id) {
		juego.setId(id);
		return service.save(juego);
	}
	
	@DeleteMapping(path={"/{id}"})
	public Juego delete(@PathVariable Long id) {
		return service.delete(id);
	}
}
