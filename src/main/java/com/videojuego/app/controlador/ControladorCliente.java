package com.videojuego.app.controlador;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.videojuego.app.interfaceService.IclienteService;
import com.videojuego.app.modelo.Cliente;

@Controller
@RequestMapping("/cliente")
public class ControladorCliente {
	
	@Autowired
	private IclienteService service; 
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "fechaNacimiento",new CustomDateEditor(dateFormat, false));
		
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("cliente",new Cliente());
		return "cliente/nuevo";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid Cliente cliente, Model model) {
		service.save(cliente);
		return "redirect:/cliente/listar";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Cliente> clientes = service.listar();
		model.addAttribute("clientes", clientes);
		return "cliente/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id,Model model) {
		Optional<Cliente> cliente = service.listarId(id);
		model.addAttribute("cliente", cliente.get());
		return "cliente/editar";
	}
	
	@PostMapping("/actualizar")
	public String actualizar(@Valid Cliente cliente, Model model) {
		service.save(cliente);
		return "redirect:/cliente/listar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id,Model model) {
		service.delete(id);;
		return "redirect:/cliente/listar";
	}
	
}
