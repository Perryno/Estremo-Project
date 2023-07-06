package it.team.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.team.entities.Ssd;

@Repository
public interface SsdRepository extends JpaRepository<Ssd, Long> {

}
