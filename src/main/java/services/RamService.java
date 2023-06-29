package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Ram;
import repositories.RamRepository;

@Service
public class RamService {
	@Autowired
	private RamRepository ramRepository;

	public List<Ram> getAllRams() {
		return ramRepository.findAll();
	}

	public Optional<Ram> getRamById(Long id) {
		return ramRepository.findById(id);
	}

	public Ram createRam(Ram ram) {
		return ramRepository.save(ram);
	}

	public Optional<Ram> updateRam(Long id, Ram ramData) {
		Optional<Ram> ram = ramRepository.findById(id);
		if (ram.isPresent()) {
			Ram updatedRam = ram.get();
			updatedRam.setNome(ramData.getNome());
			updatedRam.setPrezzo(ramData.getPrezzo());
			updatedRam.setPunteggio(ramData.getPunteggio());
			updatedRam.setCapacita(ramData.getCapacita());
			updatedRam.setFrequenza(ramData.getFrequenza());
			return Optional.of(ramRepository.save(updatedRam));
		} else {
			return Optional.empty();
		}
	}

	public boolean deleteRam(Long id) {
		Optional<Ram> ram = ramRepository.findById(id);
		if (ram.isPresent()) {
			ramRepository.delete(ram.get());
			return true;
		} else {
			return false;
		}
	}
}
