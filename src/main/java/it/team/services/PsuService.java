package it.team.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.team.entities.Psu;
import it.team.repositories.PsuRepository;

@Service
public class PsuService {
	@Autowired
	private PsuRepository psuRepository;

	public List<Psu> getAllPsus() {
		return psuRepository.findAll();
	}

	public Optional<Psu> getPsuById(Long id) {
		return psuRepository.findById(id);
	}

	public Psu createPsu(Psu psu) {
		return psuRepository.save(psu);
	}

	public Optional<Psu> updatePsu(Long id, Psu psuData) {
		Optional<Psu> psu = psuRepository.findById(id);
		if (psu.isPresent()) {
			Psu updatedPsu = psu.get();
			updatedPsu.setNome(psuData.getNome());
			updatedPsu.setPrezzo(psuData.getPrezzo());
			updatedPsu.setWattaggio(psuData.getWattaggio());
			updatedPsu.setModulare(psuData.isModulare());
			return Optional.of(psuRepository.save(updatedPsu));
		} else {
			return Optional.empty();
		}
	}

	public boolean deletePsu(Long id) {
		Optional<Psu> psu = psuRepository.findById(id);
		if (psu.isPresent()) {
			psuRepository.delete(psu.get());
			return true;
		} else {
			return false;
		}
	}
}
