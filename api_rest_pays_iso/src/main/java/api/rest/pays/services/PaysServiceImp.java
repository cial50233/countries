package api.rest.pays.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import api.rest.pays.dtos.PaysDto;
import api.rest.pays.dtos.PaysViewDto;
import api.rest.pays.entitites.Pays;
import api.rest.pays.repositories.PaysRepository;

@Service
public class PaysServiceImp implements PaysService {
	private PaysRepository paysRepo;

	protected void PaysServiceImpl(PaysRepository paysRepo) {
		this.paysRepo = paysRepo;
	}

	@Override
	public void create(PaysDto dto) {

		Pays pays = new Pays();
		populateAndSave(dto, pays);

	}

	@Override
	public PaysViewDto getOne(Long id) {

		return paysRepo.getById(id);

	}

	@Override
	public PaysViewDto getOneByAlpha2Code(String alpha2Code) {

		return null;

	}

	@Override
	public Page<PaysViewDto> getAll(Pageable pageable) {

		return paysRepo.getAllProjectedBy(pageable);

	}

	private void populateAndSave(PaysDto dto, Pays pays){
        pays.setName(dto.getName());
        pays.setAlpha2Code(dto.getAlpha2Code());
        pays.setRegion(dto.getRegion());
        pays.setFlag(dto.getFlag());
        paysRepo.save(pays);

    }

}
