package com.videojuego.app.controlador;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.videojuego.app.interfaceService.IjuegoService;
import com.videojuego.app.modelo.Juego;

@Controller
@RequestMapping("/juego")
public class ControladorJuego {
	
	@Autowired
	private IjuegoService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Juego> juegos = service.listar();
		model.addAttribute("juegos", juegos);
		return "juego/listar";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("juego",new Juego());
		return "juego/nuevo";
	}
	
	@PostMapping("/guardar")
	public String guardar (@Valid Juego juego,Model model ) {
		service.save(juego);
		return "redirect:/juego/listar";
	}
	
	@GetMapping("editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Juego> juego = service.listarId(id);
		model.addAttribute("juego",juego.get());
		return "juego/editar";
	}
	
	@PostMapping("/actualizar")
	public String actualizar (@Valid Juego juego,Model model ) {
		service.save(juego);
		return "redirect:/juego/listar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		service.delete(id);
		return "redirect:/juego/listar";
	}
}
