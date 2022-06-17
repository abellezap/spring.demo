package com.project.consorcio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.consorcio.entity.Boleta;
import com.project.consorcio.entity.MedicamentoHasBoleta;

public interface BoletaRepository extends JpaRepository<Boleta, Integer>{

	@Query("select b from Boleta b where b.numeroBoleta=?1")
	public Boleta buscarBoletaPorNumero(int num);
	
	@Query("select mhb from MedicamentoHasBoleta mhb where mhb.boleta.numeroBoleta=?1")
	public List<MedicamentoHasBoleta> buscarDetalleBoletaPorNumero(int num);
}
