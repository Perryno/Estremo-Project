package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.PCCase;

@Repository
public interface PCCaseRepository extends JpaRepository<PCCase, Long> {
	List<PCCase> findByNome(String nome);

}
