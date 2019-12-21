package api.rest.pays.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.rest.pays.dtos.PaysViewDto;
import api.rest.pays.entitites.Pays;

@Repository
public interface PaysRepository extends JpaRepository<Pays, String> {

	PaysViewDto getById(Long id);

	Page<PaysViewDto> getAllProjectedBy(Pageable pageable);
	
	PaysViewDto getOneByAlpha2Code(String alpha2Code);
}
