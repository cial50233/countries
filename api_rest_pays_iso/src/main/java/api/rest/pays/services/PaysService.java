package api.rest.pays.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import api.rest.pays.dtos.PaysDto;
import api.rest.pays.dtos.PaysViewDto;
import api.rest.pays.entitites.Pays;

public interface PaysService {

	PaysViewDto create(PaysDto dto, String alpha2Code);

	PaysViewDto getOne(Long id);

	PaysViewDto getOneByAlpha2Code(String alpha2Code);

	Page<PaysViewDto> getAll(Pageable pageable);

}
