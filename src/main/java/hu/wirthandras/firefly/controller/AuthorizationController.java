package hu.wirthandras.firefly.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hu.wirthandras.firefly.domain.Input;
import hu.wirthandras.firefly.service.IGeneratorService;

@Controller
public class AuthorizationController {

	@Autowired
	private IGeneratorService service;

	@GetMapping("/authorization")
	public String authorization() {
		return "authorization";
	}

	@PostMapping("/set")
	public String set(@ModelAttribute("input") Input input, HttpServletResponse response) throws IOException {
		service.addData(input);
		return "redirect:pdf";
	}

	@GetMapping(value = "/pdf", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public FileSystemResource download(HttpServletResponse response) throws IOException {
		FileSystemResource resource = new FileSystemResource(service.generate());
		response.setHeader("Content-disposition", "attachment; filename=" + resource.getFilename());
		return resource;
	}

}
