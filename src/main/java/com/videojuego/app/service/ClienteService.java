package com.videojuego.app.service;

import java.util.List;
import java.util.Optional;

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
		
		return (List<Cliente>)data.findAll();
	}

	@Override
	public Optional<Cliente> listarId(Long id) {
		
		return data.findById(id);
	}

	@Override
	public int save(Cliente cliente) {
		int resp= 0;
		Cliente c = data.save(cliente);
		if(c != null) {
			resp = 1;
		}
		return resp;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
