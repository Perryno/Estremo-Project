package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import entities.Cpu;
import enums.SocketType;

@Repository
public interface CpuRepository extends JpaRepository<Cpu, Long> {
	List<Cpu> findByNome(String nome);

	List<Cpu> findBySocketType(SocketType socketType);

	@Query("SELECT c FROM Cpu c WHERE c.socketType = 'AM5'")
	List<Cpu> findBySocketAM5();

	@Query("SELECT c FROM Cpu c WHERE c.socketType = 'LGA1700'")
	List<Cpu> findBySocketLGA1700();
}
