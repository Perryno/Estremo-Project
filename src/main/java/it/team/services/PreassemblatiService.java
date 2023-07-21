package it.team.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.team.entities.Preassemblati;
import it.team.repositories.PreassemblatiRepository;

@Service
public class PreassemblatiService {
	@Autowired
	private PreassemblatiRepository preassemblatiRepository;

	public List<Preassemblati> getAllPreassemblati() {
		return preassemblatiRepository.findAll();
	}

	public Optional<Preassemblati> getPreassemblatiById(Long id) {
		return preassemblatiRepository.findById(id);
	}

	public Preassemblati createPreassemblati(Preassemblati preassemblati) {
		return preassemblatiRepository.save(preassemblati);
	}

	public Optional<Preassemblati> updatePreassemblati(Long id, Preassemblati preassemblatiData) {
		Optional<Preassemblati> preassemblati = preassemblatiRepository.findById(id);
		if (preassemblati.isPresent()) {
			Preassemblati updatedPreassemblati = preassemblati.get();
			updatedPreassemblati.setNome(preassemblatiData.getNome());
			updatedPreassemblati.setPrezzo(preassemblatiData.getPrezzo());
			updatedPreassemblati.setCpu(preassemblatiData.getCpu());
			updatedPreassemblati.setGpu(preassemblatiData.getGpu());
			updatedPreassemblati.setSsd(preassemblatiData.getSsd());
			updatedPreassemblati.setPunteggio(preassemblatiData.getPunteggio());
			return Optional.of(preassemblatiRepository.save(updatedPreassemblati));
		} else {
			return Optional.empty();
		}
	}

	public boolean deletePreassemblati(Long id) {
		Optional<Preassemblati> preassemblati = preassemblatiRepository.findById(id);
		if (preassemblati.isPresent()) {
			preassemblatiRepository.delete(preassemblati.get());
			return true;
		} else {
			return false;
		}
	}
}
