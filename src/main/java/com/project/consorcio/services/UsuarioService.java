package com.project.consorcio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.consorcio.dao.UsuarioRepository;
import com.project.consorcio.entity.Enlace;
import com.project.consorcio.entity.Usuario;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repo;
	
	public Usuario iniciaSesion(String login) {
		return repo.iniciarSesion(login);
	}
	public List<Enlace> listaEnlacesDelUsuario(int codRol){
		return repo.traerEnlacesDelUsuario(codRol);
	}
}
