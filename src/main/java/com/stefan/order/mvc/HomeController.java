package com.stefan.order.mvc;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stefan.spitter.SpitterService;

@Controller
public class HomeController {
	public static final int DEFAULT_SPITTLES_PER_PAGE = 25;
	private int spittlesPerPage = DEFAULT_SPITTLES_PER_PAGE;
	
	private  SpitterService spitterService;
	
	@Inject
	public HomeController(SpitterService spitterService){
		this.spitterService = spitterService;
	}
	
	@RequestMapping({"/","/home"})
	public String showHomePage(Map<String, Object> model){
		model.put("spittles", spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE));
		
		return "home";
	}
	
	public void setSpittlesPerPage(int spittlesPerPage){
		this.spittlesPerPage = spittlesPerPage;
	}
	
	public int getSpittlesPerPage(){
		return spittlesPerPage;
	}
	
	public SpitterService getSpitterService(){
		return spitterService;
	}
	
	public void setSpitterService(SpitterService spitterService){
		this.spitterService = spitterService;
	}
}
