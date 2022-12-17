package com.certus.spring.pdf.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.certus.spring.models.Registro;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("Listreg")
public class RegistroPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Registro Registro = (Registro) model.get("Registro");

		// Construir el PDF
		PdfPTable table = new PdfPTable(1);
		table.addCell("Datos del Registro");
		table.addCell("Nombre: " + Registro.getNomape());

		document.add(table);

	}

}
