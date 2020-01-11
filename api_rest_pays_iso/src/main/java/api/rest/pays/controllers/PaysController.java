package api.rest.pays.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import api.rest.pays.dtos.PaysDto;
import api.rest.pays.dtos.PaysViewDto;
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

	@GetMapping("/{alpha2Code}")
	public PaysViewDto getOneByAlpha2Code(@PathVariable("alpha2Code") String alpha2Code) {
		PaysViewDto pays = service.getOneByAlpha2Code(alpha2Code); 
		if((pays != null)){
			return pays;
		}else {
			PaysDto paysDto = restTemplate.getForObject("https://restcountries.eu/rest/v2/alpha/" + alpha2Code, PaysDto.class);
			return service.create(paysDto, alpha2Code);
		}
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
