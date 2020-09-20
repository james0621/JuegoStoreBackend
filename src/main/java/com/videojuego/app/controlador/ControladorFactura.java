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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.videojuego.app.interfaceService.IclienteService;
import com.videojuego.app.interfaceService.IfacturaService;
import com.videojuego.app.interfaceService.IjuegoService;
import com.videojuego.app.modelo.Cliente;
import com.videojuego.app.modelo.Factura;
import com.videojuego.app.modelo.Juego;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/factura")
public class ControladorFactura {
	
	@Autowired
	private IfacturaService service;
	
	@Autowired
	private IjuegoService serviceJuego;
	
	@Autowired
	private IclienteService serviceCliente;
	
	@GetMapping
	public List<Factura> listar(){
		return service.listar();
	}
	
	@PostMapping
	public Factura guardar(@RequestBody Factura factura) {
		serviceJuego.actualizarCantidad(factura.getJuego().getId());
		return service.guardar(factura);
	}
	
	@GetMapping(path ={"/id"})
	public Factura buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id);
	}
	
	@PutMapping(path= {"/id"})
	public Factura editar(@RequestBody Factura factura,@PathVariable Long id) {
		factura.setId(id);
		return service.guardar(factura);
	}
	
	@DeleteMapping(path = {"/id"})
	public Factura eliminar(@PathVariable Long id) {
		return service.eliminar(id);
	}
	
	@GetMapping("/buscarJuego")
	public List<Juego> listarPorNombre(@RequestParam(name="termino") String termino){
		return serviceJuego.buscarPorNombre(termino);
	}
	
	@GetMapping("/buscarCliente")
	public Cliente buscarCliente(@RequestParam(name="documento") Long documento){
		return serviceCliente.buscarClientePorDocumento(documento);
	}
}

