package api.rest.pays.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import api.rest.pays.dtos.PaysDto;
import api.rest.pays.dtos.PaysViewDto;
import api.rest.pays.entitites.Pays;
import api.rest.pays.repositories.PaysRepository;

@Service
public class PaysServiceImp implements PaysService {
	@Autowired
	private PaysRepository paysRepo;
	
	@Autowired
	private RestTemplate restTemplate;

	protected void PaysServiceImpl(PaysRepository paysRepo) {
		this.paysRepo = paysRepo;
	}

	@Override
	public PaysViewDto getOneByAlpha2Code(String alpha2Code) {
		if((paysRepo.getOneByCode(alpha2Code) == null)){
			PaysDto paysDto = restTemplate.getForObject("https://restcountries.eu/rest/v2/alpha/" + alpha2Code, PaysDto.class);
			populateAndSave(paysDto);
			return this.getOneByAlpha2Code(alpha2Code);
		}else {
			return this.paysRepo.getOneByCode(alpha2Code);
		}
	}

	private void populateAndSave(PaysDto dto){
		Pays pays = new Pays();
        pays.setName(dto.getName());
        pays.setAlpha2Code(dto.getAlpha2Code());
        pays.setRegion(dto.getRegion());
        pays.setFlag(dto.getFlag());
        paysRepo.save(pays);

    }
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
