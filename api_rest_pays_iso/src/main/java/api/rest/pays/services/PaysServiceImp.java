package api.rest.pays.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	protected void PaysServiceImpl(PaysRepository paysRepo) {
		this.paysRepo = paysRepo;
	}

	@Override
	public Pays create(PaysDto dto, String alpha2Code) {
		if((paysRepo.getOneByCode(alpha2Code) == null)){
			return populateAndSave(dto, alpha2Code);
		}else {
			return null;
		}
	}

	@Override
	public PaysViewDto getOne(Long id) {

		return paysRepo.getById(id);

	}

	@Override
	public PaysViewDto getOneByAlpha2Code(String alpha2Code) {
				return this.paysRepo.getOneByCode(alpha2Code);
	}

	@Override
	public Page<PaysViewDto> getAll(Pageable pageable) {

		return paysRepo.getAllProjectedBy(pageable);

	}

	private Pays populateAndSave(PaysDto dto, String alpha2Code){
		Pays pays = new Pays();
        pays.setName(dto.getName());
        pays.setAlpha2Code(alpha2Code);
        pays.setRegion(dto.getRegion());
        pays.setFlag(dto.getFlag());
        return paysRepo.save(pays);

    }

}
