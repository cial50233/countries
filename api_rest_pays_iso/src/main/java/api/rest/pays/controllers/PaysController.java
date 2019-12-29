package api.rest.pays.controllers;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

//import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import api.rest.pays.dtos.PaysDto;
import api.rest.pays.dtos.PaysViewDto;
import api.rest.pays.entitites.Pays;
import api.rest.pays.services.PaysService;

@RestController
@RequestMapping("/api/countries")
public class PaysController {

	@Autowired
	private final PaysService service;
	
	@Autowired
	private RestTemplate restTemplate;

	protected PaysController(PaysService service) {
		this.service = service;
	}

	@GetMapping
	public String getAll() {
		return "azetty";
	}
	
/*	
	@GetMapping("/{alpha2Code}")
	public PaysViewDto getOneByAlpha2Code(@PathVariable("alpha2Code") String alpha2Code) {
		if (!(service.getOneByAlpha2Code(alpha2Code)).equals(null)) {
			return service.getOneByAlpha2Code(alpha2Code);
		} else {
			PaysDto paysDto = restTemplate.getForObject("https://restcountries.eu/rest/v2/alpha/" + alpha2Code,
					PaysDto.class);
			//service.create(paysDto, alpha2Code);
			return null;
		}
	}
	
*/	

	@GetMapping("/{alpha2Code}")
	public PaysViewDto getOneByAlpha2Code(@PathVariable("alpha2Code") String alpha2Code) {
		if((service.getOneByAlpha2Code(alpha2Code) != null)){
			return service.getOneByAlpha2Code(alpha2Code);
		}else {
			PaysDto paysDto = restTemplate.getForObject("https://restcountries.eu/rest/v2/alpha/" + alpha2Code, PaysDto.class);
			return (PaysViewDto) service.create(paysDto, alpha2Code);
		}
	}
	
	@RequestMapping("/ext/{alpha2Code}")
	public Pays getPaysInfo(@PathVariable("alpha2Code") String alpha2Code) {
		PaysDto paysDto = restTemplate.getForObject("https://restcountries.eu/rest/v2/alpha/"+ alpha2Code, PaysDto.class);
		return new Pays(alpha2Code, paysDto.getName(), paysDto.getRegion(), paysDto.getFlag());
	}

	@GetMapping("/c/{alpha2Code}")
	protected Pays create(@PathVariable("alpha2Code") String alpha2Code) {
		PaysDto paysDto = restTemplate.getForObject("https://restcountries.eu/rest/v2/alpha/" + alpha2Code, PaysDto.class);
		return service.create(paysDto, alpha2Code);
	}

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
