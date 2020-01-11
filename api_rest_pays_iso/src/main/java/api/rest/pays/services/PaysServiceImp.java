package api.rest.pays.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rest.pays.dtos.PaysDto;
import api.rest.pays.dtos.PaysViewDto;
import api.rest.pays.entitites.Pays;
import api.rest.pays.repositories.PaysRepository;

@Service
public class PaysServiceImp implements PaysService {
	@Autowired
	private PaysRepository paysRepo;

	protected void PaysServiceImpl(PaysRepository paysRepo) {
		this.paysRepo = paysRepo;
	}

	@Override
	public PaysViewDto create(PaysDto dto, String alpha2Code) {
		if((paysRepo.getOneByCode(alpha2Code) == null)){
			populateAndSave(dto);
			return this.getOneByAlpha2Code(alpha2Code);
		}else {
			return null;
		}
	}

	@Override
	public PaysViewDto getOneByAlpha2Code(String alpha2Code) {
				return this.paysRepo.getOneByCode(alpha2Code);
	}

	private void populateAndSave(PaysDto dto){
		Pays pays = new Pays();
        pays.setName(dto.getName());
        pays.setAlpha2Code(dto.getAlpha2Code());
        pays.setRegion(dto.getRegion());
        pays.setFlag(dto.getFlag());
        paysRepo.save(pays);

    }

}
