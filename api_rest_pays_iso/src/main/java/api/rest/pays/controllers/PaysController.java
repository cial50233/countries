package api.rest.pays.controllers;

//import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import api.rest.pays.dtos.PaysDto;
import api.rest.pays.dtos.PaysViewDto;
import api.rest.pays.services.PaysService;

@RestController
@RequestMapping("/api/countries")
public class PaysController {

	private final PaysService service;

	protected PaysController(PaysService service) {
		this.service = service;
	}

	@GetMapping
	public String getAll() {
		return "azetty";
	}

	@GetMapping("/{alpha2Code}")
	protected PaysViewDto getCountry(@PathVariable("alpha2Code") String alpha2Code) {
		return service.getOneByAlpha2Code(alpha2Code);
	}
/*
	@PostMapping
	protected void create(@Valid @RequestBody PaysDto dto) {
		service.create(dto);
	}
*/
}
