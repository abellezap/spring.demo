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
@RequestMapping("/laboratorio")
public class LaboratorioController {
	//cambio 1
	
	
	@RequestMapping("/")
	public String index(Model model) {

		return "laboratorio";
	}
	
		
	
}
