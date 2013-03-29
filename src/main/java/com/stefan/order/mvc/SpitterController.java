package com.stefan.order.mvc;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stefan.spitter.Spitter;
import com.stefan.spitter.SpitterService;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	private final SpitterService spitterService;
	
	@Inject
	public SpitterController(SpitterService spitterService){
		this.spitterService = spitterService;
	}
	
	@RequestMapping(value="/spittles", method=GET)
	public String listSpittlesForSpitter(
			@RequestParam("spitter") String username, Model model){
		Spitter spitter = spitterService.getSpitter(username);
		model.addAttribute(spitter);
		model.addAttribute(spitterService.getSpittlesForSpitter(username));
		return "spittles/list";
	}
}
