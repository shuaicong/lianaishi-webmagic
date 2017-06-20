package com.lianaishi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lianaishi.service.LoveService;


@RestController
public class LoveController {

	@Autowired
	private LoveService loveService;
	
	@RequestMapping("/index")
	public String index()
	{
		return "helloWord";
	}
	
}
