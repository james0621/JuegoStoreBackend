package com.videojuego.app.controlador;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videojuego.app.interfaceService.IclienteService;
import com.videojuego.app.modelo.Cliente;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
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
	
	@GetMapping
	public List<Cliente> listar(){
		return service.listar();
	}
	
	@PostMapping
	public Cliente guardar(@RequestBody Cliente cliente) {
		return service.save(cliente);
	}
	
	@GetMapping(path = {"/{id}"})
	public Cliente buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id);
	}
	
	@PutMapping(path={"/{id}"})
	public Cliente editar(@RequestBody Cliente cliente,@PathVariable Long id) {
		cliente.setId(id);
		return service.save(cliente);
	}
	
	@DeleteMapping(path={"/{id}"})
	public Cliente delete(@PathVariable Long id) {
		return service.delete(id);
	}
	
}
