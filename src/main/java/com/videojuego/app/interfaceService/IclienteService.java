package com.videojuego.app.interfaceService;

import java.util.List;
import java.util.Optional;


import com.videojuego.app.modelo.Cliente;


public interface IclienteService {
	
	public List<Cliente> listar();
	public Optional<Cliente>listarId(Long id);
	public int save(Cliente cliente);
	public void delete(Long id);
}
