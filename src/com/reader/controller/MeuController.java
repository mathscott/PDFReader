package com.reader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.reader.modelo.CampoTexto;

import java.io.IOException;

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
}
