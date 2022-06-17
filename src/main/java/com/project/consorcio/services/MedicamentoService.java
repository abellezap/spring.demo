package com.project.consorcio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.consorcio.dao.MedicamentoRepository;
import com.project.consorcio.entity.Medicamento;

@Service
public class MedicamentoService {
	
	@Autowired
	private MedicamentoRepository repo;
	
	
	public void guardar(Medicamento bean) {
		repo.save(bean);
	}
	public void eliminar(int cod) {
		repo.deleteById(cod);
	}
	public Medicamento buscar(int cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<Medicamento> listarTodos(){
		return repo.findAll();
	}
	
}
