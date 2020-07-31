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

import com.videojuego.app.interfaceService.IfacturaService;
import com.videojuego.app.modelo.Factura;

@Controller
@RequestMapping("/factura")
public class ControladorFactura {
	
	@Autowired
	private IfacturaService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Factura> facturas = service.listar();
		model.addAttribute("facturas",facturas);
		return "factura/listarFactura";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("factura", new Factura());
		return "factura/nuevaFactura";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid Factura factura, Model model) {
		service.guardar(factura);
		return "redirect:/factura/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Factura> factura = service.buscarPorId(id);
		model.addAttribute("factura", factura);
		return "factura/editar";
	}
	
	@PostMapping("/actualizar")
	public String actualizar(@Valid Factura factura, Model model) {
		service.guardar(factura);
		return "redirect:/factura/listar";
	}
	
}
