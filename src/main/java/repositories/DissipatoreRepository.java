package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Dissipatore;

@Repository
public interface DissipatoreRepository extends JpaRepository<Dissipatore, Long> {
	List<Dissipatore> findByNome(String nome);

}
