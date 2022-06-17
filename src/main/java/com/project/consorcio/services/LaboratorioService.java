package com.project.consorcio.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.consorcio.dao.LaboratorioRepository;
import com.project.consorcio.entity.Laboratorio;

@Service
public class LaboratorioService {
	
	@Autowired
	private LaboratorioRepository repo;
	
	
	public List<Laboratorio> listAll(){
		return repo.findAll();
	}
	
}
