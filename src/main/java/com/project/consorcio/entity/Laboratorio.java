package com.project.consorcio.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_laboratorio")
public class Laboratorio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lab")
	private int codigo;
	@Column(name = "nom_lab")
	private String nombre;
	@Column(name = "dir_lab")
	private String direccion;
	
	
	@OneToMany(mappedBy = "laboratorio")
	@JsonIgnore
	private List<TipoMedicamento> listaTipo;


	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<TipoMedicamento> getListaTipo() {
		return listaTipo;
	}
	public void setListaTipo(List<TipoMedicamento> listaTipo) {
		this.listaTipo = listaTipo;
	}
	
	
	
	
}
