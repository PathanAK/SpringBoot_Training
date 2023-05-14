package com.example.SpringmvcDemo.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	
	@RequestMapping("/demo")
	public String greet() {
		return "Hello";
	}
	
	@RequestMapping(value = {"/home","/"})
	public String greet1() {
		return "home";
	}
}
