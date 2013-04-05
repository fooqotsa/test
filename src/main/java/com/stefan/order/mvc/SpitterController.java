package com.stefan.order.mvc;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.stefan.exceptions.ImageUploadException;
import com.stefan.spitter.Spitter;
import com.stefan.spitter.SpitterService;

@Controller
@RequestMapping("/spitters")
public class SpitterController {
	private final SpitterService spitterService;
	
	@Inject
	public SpitterController(SpitterService spitterService){
		this.spitterService = spitterService;
	}
	
	@RequestMapping(method=RequestMethod.GET, params="new")
	public String createSpitterProfile(Model model){
		model.addAttribute(new Spitter());
		return "spitters/edit";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addSpitterFromForm(@Valid Spitter spitter, BindingResult bindingResult,
				@RequestParam(value="image", required=false) MultipartFile image){
		
		if (bindingResult.hasErrors()){
			return "spitters/edit";
		}
		
		spitterService.saveSpitter(spitter);
		
		try{
			if (!image.isEmpty()){
				validateImage(image);
				saveImage(spitter.getId() + ".jpg", image);
			}
		} catch(ImageUploadException e){
			bindingResult.reject(e.getMessage());
			return "spitters/edit";
		}
		
		return "redirect:/spitters/" + spitter.getName();
	}
	
	@RequestMapping(value="/{username}", method=GET)
	public String showSpitterProfile(@PathVariable String username, Model model){
		
		model.addAttribute(spitterService.getSpitter(username));
		return "spitters/view";
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET,
					headers = {"Accept=text/xml, application/json"})
	public @ResponseBody Spitter getSpitter(@PathVariable String username){
		return spitterService.getSpitter(username);
	}	
	
	@RequestMapping(value = "/{username}", method = RequestMethod.PUT,
					headers = "Content-Type=application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateSpitter(@PathVariable String username,
			@RequestBody Spitter spitter){
		spitterService.saveSpitter(spitter);
	}
	
	//Private Methods
	
	private void validateImage(MultipartFile image) {
		if(!image.getContentType().equals("image/jpeg")) {
			throw new ImageUploadException("Only JPG images accepted");
		}
	}
	
	private void saveImage(String filename, MultipartFile image) throws ImageUploadException {
		try {
			String webRootPath = "/WEB-INF";
			File file = new File(webRootPath  + "/resources/" + filename);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch (IOException e) {
				throw new ImageUploadException("Unable to save image", e);
		}
	}	

}
