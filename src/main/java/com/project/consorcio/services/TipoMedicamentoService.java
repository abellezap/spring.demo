package com.project.consorcio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.consorcio.dao.TipoMedicamentoRepository;
import com.project.consorcio.entity.TipoMedicamento;

@Service
public class TipoMedicamentoService {
	
	@Autowired
	private TipoMedicamentoRepository repo;
	
	
	
	public void guardar(TipoMedicamento bean) {
		repo.save(bean);
	}
	public void eliminar(int cod) {
		repo.deleteById(cod);
	}
	public TipoMedicamento buscar(int cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<TipoMedicamento> listarTodos(){
		return repo.findAll();
	}
	public List<TipoMedicamento> listarTipoMedicamentoPorLaboratorio(int codLab){
		return repo.listByCodigoLaboratorio(codLab);	
	}
	
}




