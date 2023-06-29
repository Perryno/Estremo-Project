package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.PCCase;
import repositories.PCCaseRepository;

@Service
public class PCCaseService {
	@Autowired
	private PCCaseRepository pcCaseRepository;

	public List<PCCase> getAllPCCases() {
		return pcCaseRepository.findAll();
	}

	public Optional<PCCase> getPCCaseById(Long id) {
		return pcCaseRepository.findById(id);
	}

	public PCCase createPCCase(PCCase pcCase) {
		return pcCaseRepository.save(pcCase);
	}

	public Optional<PCCase> updatePCCase(Long id, PCCase pcCaseData) {
		Optional<PCCase> pcCase = pcCaseRepository.findById(id);
		if (pcCase.isPresent()) {
			PCCase updatedPCCase = pcCase.get();
			updatedPCCase.setNome(pcCaseData.getNome());
			updatedPCCase.setPrezzo(pcCaseData.getPrezzo());
			return Optional.of(pcCaseRepository.save(updatedPCCase));
		} else {
			return Optional.empty();
		}
	}

	public boolean deletePCCase(Long id) {
		Optional<PCCase> pcCase = pcCaseRepository.findById(id);
		if (pcCase.isPresent()) {
			pcCaseRepository.delete(pcCase.get());
			return true;
		} else {
			return false;
		}
	}
}
