package com.project.consorcio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.consorcio.entity.TipoMedicamento;

public interface TipoMedicamentoRepository extends JpaRepository<TipoMedicamento, Integer>{
	//crear un query que liste todos los tipos de medicamentos según el laboratorio seleccionado
	//select *from tb_tipo_medicamento where cod_lab=1
	//sentencias sql de tipo HQL
	@Query("select tm from TipoMedicamento tm where tm.laboratorio.codigo=?1")
	public List<TipoMedicamento> listByCodigoLaboratorio(int codLab);
}
