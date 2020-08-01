package com.videojuego.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videojuego.app.interfaceService.IclienteService;
import com.videojuego.app.interfaces.ICliente;
import com.videojuego.app.modelo.Cliente;

@Service
public class ClienteService implements IclienteService{

	@Autowired
	private ICliente data;
	
	@Override
	public List<Cliente> listar() {
		
		return data.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		
		return data.findById(id);
	}

	@Override
	public Cliente save(Cliente cliente) {
		Cliente c = data.save(cliente);
		return c;
	}

	@Override
	public Cliente delete(Long id) {
		Cliente c = data.findById(id);
		if(c != null) {
			data.delete(c);
		}
		return c;
	}

	@Override
	public Cliente buscarClientePorDocumento(Long documento) {
		
		return data.buscarPorDocumento(documento);
	}

}
