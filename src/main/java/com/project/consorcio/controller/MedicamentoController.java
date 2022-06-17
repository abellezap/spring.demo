package com.project.consorcio.controller;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.consorcio.entity.Medicamento;
import com.project.consorcio.entity.TipoMedicamento;
import com.project.consorcio.services.LaboratorioService;
import com.project.consorcio.services.MedicamentoService;
import com.project.consorcio.services.TipoMedicamentoService;

@Controller
@RequestMapping("/medicamento")
public class MedicamentoController {
	//cambio 2
	
	@Autowired
	private MedicamentoService medServicio;
	@Autowired
	private TipoMedicamentoService tipoServicio;
	@Autowired
	private LaboratorioService laboratorioServicio;
	
	@RequestMapping("/")
	public String index(Model model) {
		//crear atributos
		model.addAttribute("medicamentos",medServicio.listarTodos());
		model.addAttribute("laboratorios",laboratorioServicio.listAll());
		return "medicamento";
	}
	
	
	@RequestMapping("/guardar")
	public String guardar(@RequestParam("codigo") int cod, @RequestParam("nombre") String nom,@RequestParam("descripcion") String des,
					    @RequestParam("stock") int stock,@RequestParam("precio") double pre,
					    @RequestParam("fecha") String fecha,@RequestParam("tipo") int tipo,
					    RedirectAttributes redirect) {
		try {
			Medicamento m=new Medicamento();
			m.setNombre(nom);
			m.setDescripcion(des);
			m.setStock(stock);
			m.setPrecio(pre);
			m.setFechaFabricacion(LocalDate.parse(fecha));
			//
			TipoMedicamento tm=new TipoMedicamento();
			tm.setCodigo(tipo);
			m.setTipo(tm);
			//validar cod
			if(cod==0) {
				medServicio.guardar(m);
				redirect.addFlashAttribute("MENSAJE","Medicamento registrado correctamente");
			}
			else {
				m.setCodigo(cod);
				medServicio.guardar(m);
				redirect.addFlashAttribute("MENSAJE","Medicamento actualizado correctamente");
			}
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error al guardar medicamento");
			e.printStackTrace();
		}
		return "redirect:/medicamento/";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Medicamento buscar(@RequestParam("codigo") int cod) {
		return medServicio.buscar(cod);
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo") int cod,RedirectAttributes redirect) {
		try {
			medServicio.eliminar(cod);
			redirect.addFlashAttribute("MENSAJE", "Medicamento eliminado correctamente");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error en la eliminación de medicamento");
			e.printStackTrace();
		}
		return "redirect:/medicamento/";
	}
	
	@RequestMapping("/listarTipos")
	@ResponseBody
	public List<TipoMedicamento> listarTipos(@RequestParam("codigo") int cod) {
		return tipoServicio.listarTipoMedicamentoPorLaboratorio(cod);
	}
	
	
	
}
