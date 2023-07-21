package it.team.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.team.entities.Preassemblati;

@Repository
public interface PreassemblatiRepository extends JpaRepository<Preassemblati, Long> {
	List<Preassemblati> findByNome(String nome);
}
