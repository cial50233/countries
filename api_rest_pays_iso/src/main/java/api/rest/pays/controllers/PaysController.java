package api.rest.pays.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import api.rest.pays.dtos.PaysViewDto;
import api.rest.pays.services.PaysService;

@RestController
@RequestMapping("/api/countries")
public class PaysController {

	@Autowired
	private final PaysService service;
	
	protected PaysController(PaysService service) {
		this.service = service;
	}

	@GetMapping("/{alpha2Code}")
	public PaysViewDto getOneByAlpha2Code(@PathVariable("alpha2Code") String alpha2Code) {
		PaysViewDto pays = service.getOneByAlpha2Code(alpha2Code); 
		return pays;
	}
	
}
