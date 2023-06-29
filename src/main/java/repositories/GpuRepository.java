package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.Gpu;

@Repository
public interface GpuRepository extends JpaRepository<Gpu, Long> {
	List<Gpu> findByNome(String nome);

}
