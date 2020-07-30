package com.videojuego.app.controlador;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.videojuego.app.interfaceService.IclienteService;
import com.videojuego.app.modelo.Cliente;

@Controller
@RequestMapping
public class ControladorCliente {
	
	@Autowired
	private IclienteService service; 
	
	@GetMapping({"/index","/"})
	public String solicitud(Model model) {
		model.addAttribute("cliente",new Cliente());
		return "index";
	}
	
	@PostMapping("/save")
	public String guardar(@Valid Cliente cliente, Model model) {
		service.save(cliente);
		return "redirect:/ver";
	}
	
	@GetMapping("/ver")
	public String ver(Model model) {
		List<Cliente> clientes = service.listar();
		model.addAttribute("clientes", clientes);
		return "ver";
	}
}
