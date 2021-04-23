package com.gft.book.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookErrorController implements ErrorController  {
	
	@RequestMapping("/error")
	public String handleError() {	
		return "Error";
	}
	
	@Override
	public String getErrorPath() {
		return null;
	}
}
