package it.team.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.team.entities.Ram;

@Repository
public interface RamRepository extends JpaRepository<Ram, Long> {
	List<Ram> findByNome(String nome);

}
