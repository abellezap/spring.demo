package com.project.consorcio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.consorcio.dao.BoletaRepository;
import com.project.consorcio.dao.MedicamentoHasBoletaRepository;
import com.project.consorcio.entity.Boleta;
import com.project.consorcio.entity.MedicamentoHasBoleta;
import com.project.consorcio.entity.MedicamentoHasBoletaPK;

@Service
public class BoletaService {
	@Autowired
	private BoletaRepository repo;
	@Autowired
	private MedicamentoHasBoletaRepository repoDetalle;
	
	@Transactional
	public void grabarBoleta(Boleta boleta) {
		try {
			//grabar boleta "cabecera"
			repo.save(boleta);
			//grabar detalle
			//bucle
			for(MedicamentoHasBoleta mhb:boleta.getListaMedicamentoHasBoleta()) {
				//crear llave
				MedicamentoHasBoletaPK pk=new MedicamentoHasBoletaPK();
				pk.setNumeroBoleta(boleta.getNumeroBoleta());
				pk.setCodigoMedicamento(mhb.getMedicamento().getCodigo());
				mhb.setPk(pk);
				repoDetalle.save(mhb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public Boleta findBoletaPorNumero(int num) {
		return repo.buscarBoletaPorNumero(num);
	}
	public List<MedicamentoHasBoleta> findDetalleBoletaPorNumero(int num){
		return repo.buscarDetalleBoletaPorNumero(num);
	}
	
	
}
