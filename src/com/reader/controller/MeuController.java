package com.reader.controller;


import org.apache.taglibs.standard.tag.common.core.Util;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import com.reader.modelo.CampoTexto;
import java.io.File;
import java.io.IOException;

import com.reader.modelo.ArquivoXML;
import com.reader.modelo.RetanguloPDF;
import org.apache.pdfbox.text.PDFTextStripperByArea;



@Controller
public class MeuController {


	@RequestMapping("/upload")
	public String retornaInformacao () {

		return "upload";
	}


	@RequestMapping(value= "/uploadFile", method = RequestMethod.POST)
	public ModelAndView adicionaArquivo (CampoTexto campoTexto, @RequestParam("file") MultipartFile file) throws IOException {
		ModelAndView mv = new ModelAndView("/resultado");

		String content = new String(file.getBytes());

		mv.addObject("content", content);
		mv.addObject("texto", campoTexto.getTexto());
		
		return mv;
	}

	@RequestMapping(value = "/showXmlFile", method = RequestMethod.POST)
	public @ResponseBody void downloadA(RetanguloPDF retanguloPDF, HttpServletResponse response, @RequestParam("file") MultipartFile mFile) throws IOException {
		File convFile = new File( mFile.getOriginalFilename());
		mFile.transferTo(convFile);
		System.out.println(mFile.getOriginalFilename());

		ArquivoXML arquivoXML = new ArquivoXML();
		System.out.println(retanguloPDF.getAltura());

		PDFTextStripperByArea pdfTextStripperByArea = retanguloPDF.parse("/home/matheus/Documentos/sample.pdf");
		arquivoXML.criarXML(pdfTextStripperByArea);

		File xmlFile = new File("/home/matheus/Documentos/data.xml");
		FileInputStream inputStream = new FileInputStream(xmlFile);
		byte[] buffer = new byte[8192];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		int bytesRead;
		while ((bytesRead = inputStream.read(buffer)) != -1)
		{
			baos.write(buffer, 0, bytesRead);
		}
		response.setHeader("Content-Disposition","inline; filename=\""+xmlFile.getName()+"\"");
		response.setContentType("text/xml");
		ServletOutputStream outputStream = response.getOutputStream();
		baos.writeTo(outputStream);
		outputStream.flush();

	}
}
