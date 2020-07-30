package com.videojuego.app.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.videojuego.app.modelo.Juego;

@Controller
@RequestMapping("juego")
public class ControladorVideoJuego {
	
	@GetMapping("/juego/listar")
	public String listar(Model model) {
		List<Juego> juegos = new ArrayList<>();
		model.addAttribute("juegos", juegos);
		return "juego/listar";
	}
	
	@GetMapping("/juego/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("juego",new Juego());
		return "juego/nuevo";
	}
}
