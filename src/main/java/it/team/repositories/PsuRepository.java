package it.team.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.team.entities.Psu;

@Repository
public interface PsuRepository extends JpaRepository<Psu, Long> {
	List<Psu> findByNome(String nome);

}
