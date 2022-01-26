package com.aplicacao.web.controller;

import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/home", "/"})
public class HomeController	{
	
	@GetMapping(path = "/index")
		public	String	index() {
		
			System.out.println("Executando	a	xxxxxx	com	Spring	MVC");
			return "index";
		}
}