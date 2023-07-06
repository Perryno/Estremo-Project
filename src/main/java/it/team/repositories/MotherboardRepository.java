package it.team.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.team.entities.Motherboard;
import it.team.enums.SocketType;

@Repository
public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {
	List<Motherboard> findByNome(String nome);

	List<Motherboard> findBySocketType(SocketType socketType);

	@Query("SELECT m FROM Motherboard m WHERE m.socketType = 'AM5'")
	List<Motherboard> findBySocketAM5();

	@Query("SELECT m FROM Motherboard m WHERE m.socketType = 'LGA1700'")
	List<Motherboard> findBySocketLGA1700();

}
