package api.rest.pays.services;

import api.rest.pays.dtos.PaysDto;
import api.rest.pays.dtos.PaysViewDto;

public interface PaysService {

	PaysViewDto create(PaysDto dto, String alpha2Code);

	PaysViewDto getOneByAlpha2Code(String alpha2Code);


}
