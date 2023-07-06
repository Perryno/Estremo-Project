package it.team.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.team.entities.Ssd;
import it.team.repositories.SsdRepository;

@Service
public class SsdService {

	@Autowired
	private SsdRepository ssdRepository;

	public List<Ssd> getAllSsds() {
		return ssdRepository.findAll();
	}

	public Optional<Ssd> getSsdById(Long id) {
		return ssdRepository.findById(id);
	}

	public Ssd createSsd(Ssd ssd) {
		return ssdRepository.save(ssd);
	}

	public Optional<Ssd> updateSsd(Long id, Ssd ssdData) {
		Optional<Ssd> ssd = ssdRepository.findById(id);
		if (ssd.isPresent()) {
			Ssd updatedSsd = ssd.get();
			updatedSsd.setNome(ssdData.getNome());
			updatedSsd.setCapacita(ssdData.getCapacita());
			updatedSsd.setPrezzo(ssdData.getPrezzo());
			updatedSsd.setVelocita(ssdData.getVelocita());
			return Optional.of(ssdRepository.save(updatedSsd));
		}
		return Optional.empty();
	}

	public boolean deleteSsd(Long id) {
		Optional<Ssd> ssd = ssdRepository.findById(id);
		if (ssd.isPresent()) {
			ssdRepository.delete(ssd.get());
			return true;
		}
		return false;
	}

}
