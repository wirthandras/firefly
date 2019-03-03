package hu.wirthandras.firefly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import hu.wirthandras.firefly.service.NodeCreatorService;

@Controller
public class MyController {
	
	@Autowired
	private NodeCreatorService service;
	
	@GetMapping(value="/element/{id}")
	public String showNode(@PathVariable("id") String id, Model model) {
		model.addAttribute("node", service.makeANode(id));
		return "node";
	}
	
	@GetMapping("/")
	public String showIndex(Model model) {
		model.addAttribute("id", service.randomId());
		return "index";
	}
	

}
