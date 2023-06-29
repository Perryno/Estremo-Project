package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Dissipatore;
import repositories.DissipatoreRepository;

@Service
public class DissipatoreService {
	@Autowired
	private DissipatoreRepository dissipatoreRepository;

	public List<Dissipatore> getAllDissipatori() {
		return dissipatoreRepository.findAll();
	}

	public Optional<Dissipatore> getDissipatoreById(Long id) {
		return dissipatoreRepository.findById(id);
	}

	public Dissipatore createDissipatore(Dissipatore dissipatore) {
		return dissipatoreRepository.save(dissipatore);
	}

	public Optional<Dissipatore> updateDissipatore(Long id, Dissipatore dissipatoreData) {
		Optional<Dissipatore> dissipatore = dissipatoreRepository.findById(id);
		if (dissipatore.isPresent()) {
			Dissipatore updatedDissipatore = dissipatore.get();
			updatedDissipatore.setNome(dissipatoreData.getNome());
			updatedDissipatore.setPrezzo(dissipatoreData.getPrezzo());

			return Optional.of(dissipatoreRepository.save(updatedDissipatore));
		} else {
			return Optional.empty();
		}
	}

	public boolean deleteDissipatore(Long id) {
		Optional<Dissipatore> dissipatore = dissipatoreRepository.findById(id);
		if (dissipatore.isPresent()) {
			dissipatoreRepository.delete(dissipatore.get());
			return true;
		} else {
			return false;
		}
	}

}
