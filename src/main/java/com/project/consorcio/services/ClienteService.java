package com.project.consorcio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.consorcio.dao.ClienteRepository;
import com.project.consorcio.entity.Cliente;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	
	public List<Cliente> listarClientesPorApellido(String ape){
		return repo.listAllByApellido(ape);
	}
	
	
}
