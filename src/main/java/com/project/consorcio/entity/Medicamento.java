package com.project.consorcio.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_medicamento")
public class Medicamento {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_med")
	private int codigo;
	@Column(name = "nom_med")
	private String nombre;
	@Column(name = "des_med")
	private String descripcion;
	@Column(name = "sto_med")
	private int stock;
	@Column(name = "pre_med")
	private double precio;
	@Column(name = "fec_fab_med")
	private LocalDate fechaFabricacion;
	
	//relación MUCHOS "Medicamento" a UNO "TipoMedicamento"
	@ManyToOne
	@JoinColumn(name="cod_tipo")
	private TipoMedicamento tipo;//ASOCIACIÓN

	public Medicamento() {
		// TODO Auto-generated constructor stub
	}
	public Medicamento(int codMed) {
		codigo=codMed;
	}
	
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public LocalDate getFechaFabricacion() {
		return fechaFabricacion;
	}

	public void setFechaFabricacion(LocalDate fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}

	public TipoMedicamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMedicamento tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
