package com.videojuego.app.interfaceService;

import java.util.List;


import com.videojuego.app.modelo.Cliente;


public interface IclienteService {
	
	public List<Cliente> listar();
	public Cliente buscarPorId(Long id);
	public Cliente save(Cliente cliente);
	public Cliente delete(Long id);
	public Cliente buscarClientePorDocumento(Long documento);
}
