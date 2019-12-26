package api.rest.pays.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import api.rest.pays.dtos.PaysViewDto;
import api.rest.pays.entitites.Pays;

@Repository
public interface PaysRepository extends JpaRepository<Pays, String> {

	PaysViewDto getById(Long id);

	Page<PaysViewDto> getAllProjectedBy(Pageable pageable);
	
	@Query(value = "SELECT p FROM Pays p where p.alpha2Code = :alpha2Code")
	PaysViewDto getOneByCode(@Param("alpha2Code") String alpha2Code);
}
