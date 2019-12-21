package api.rest.pays.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import api.rest.pays.dtos.PaysDto;
import api.rest.pays.dtos.PaysViewDto;

public interface PaysService {

	void create(PaysDto dto);

	PaysViewDto getOne(Long id);

	PaysViewDto getOneByAlpha2Code(String alpha2Code);

	Page<PaysViewDto> getAll(Pageable pageable);

}
