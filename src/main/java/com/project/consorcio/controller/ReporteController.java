package com.project.consorcio.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.consorcio.entity.Boleta;
import com.project.consorcio.entity.Medicamento;
import com.project.consorcio.entity.MedicamentoHasBoleta;
import com.project.consorcio.services.BoletaService;
import com.project.consorcio.services.MedicamentoService;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/reporte")
public class ReporteController {
	
	//cambio 3
	
	@Autowired
	private MedicamentoService medicamentoService;
	@Autowired
	private BoletaService boletaService;
	
	
	@RequestMapping("/medicamentos")
	public void medicamentos(HttpServletResponse response) {
		try {
			//invocar al método listarTodos
			List<Medicamento> lista=medicamentoService.listarTodos();
			//acceder al reporte "reporteMedicamento.jrxml"
			File file=ResourceUtils.getFile("classpath:reporteMedicamento.jrxml");
			//crear objeto de la clase JasperReport y manipular el objeto file
			JasperReport jasper=JasperCompileManager.compileReport(file.getAbsolutePath());
			//origen de datos "manipular lista"
			JRBeanCollectionDataSource origen=new JRBeanCollectionDataSource(lista);
			//crear reporte
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasper,null,origen);
			//salida del reporte en formato PDF
			response.setContentType("application/pdf");
			//
			OutputStream salida=response.getOutputStream();
			//exportar a pdf
			JasperExportManager.exportReportToPdfStream(jasperPrint,salida);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/buscarBoletaPorNumero")
	@ResponseBody
	public Boleta buscarBoletaPorNumero(@RequestParam("numero") int num) {
		return boletaService.findBoletaPorNumero(num);
	}
	@RequestMapping("/buscarDetallePorNumero")
	@ResponseBody
	public List<MedicamentoHasBoleta> buscarDetallePorNumero(@RequestParam("numero") int num) {
		return boletaService.findDetalleBoletaPorNumero(num);
	}
	@RequestMapping("/reporteBoletaPorNumero")
	public void reporteBoletaPorNumero(HttpServletResponse response,@RequestParam("numero") int num) {
		try {
			//invocar al método listarTodos
			List<MedicamentoHasBoleta> lista=boletaService.findDetalleBoletaPorNumero(num);
			//acceder al reporte "reporteMedicamento.jrxml"
			File file=ResourceUtils.getFile("classpath:reporte_boleta_por_numero.jrxml");
			//crear objeto de la clase JasperReport y manipular el objeto file
			JasperReport jasper=JasperCompileManager.compileReport(file.getAbsolutePath());
			//origen de datos "manipular lista"
			JRBeanCollectionDataSource origen=new JRBeanCollectionDataSource(lista);
			//crear reporte
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasper,null,origen);
			//salida del reporte en formato PDF
			response.setContentType("application/pdf");
			//
			OutputStream salida=response.getOutputStream();
			//exportar a pdf
			JasperExportManager.exportReportToPdfStream(jasperPrint,salida);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
