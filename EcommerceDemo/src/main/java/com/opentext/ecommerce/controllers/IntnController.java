package com.opentext.ecommerce.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntnController {

	@Autowired
	private MessageSource messageSource;
	
	 @GetMapping(path="/messagei18n")
		public String messageInternationalized(@RequestHeader(name="Accept-Language",required=false) Locale locale)
		{
			return messageSource.getMessage("greeting", null, locale);
		}
	
}
