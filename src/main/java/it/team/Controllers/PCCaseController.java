package it.team.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.team.entities.PCCase;
import it.team.repositories.PCCaseRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/pccase")
public class PCCaseController {

	@Autowired
	private PCCaseRepository pcCaseRepository;

	@GetMapping
	public List<PCCase> getAllPCCases() {
		return pcCaseRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<PCCase> getPCCaseById(@PathVariable("id") Long id) {
		Optional<PCCase> pcCase = pcCaseRepository.findById(id);
		if (pcCase.isPresent()) {
			return ResponseEntity.ok(pcCase.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public PCCase createPCCase(@RequestBody PCCase pcCase) {
		return pcCaseRepository.save(pcCase);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PCCase> updatePCCase(@PathVariable("id") Long id, @RequestBody PCCase pcCaseData) {
		Optional<PCCase> pcCase = pcCaseRepository.findById(id);
		if (pcCase.isPresent()) {
			PCCase updatedPCCase = pcCase.get();
			updatedPCCase.setNome(pcCaseData.getNome());
			updatedPCCase.setPrezzo(pcCaseData.getPrezzo());
			return ResponseEntity.ok(pcCaseRepository.save(updatedPCCase));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePCCase(@PathVariable("id") Long id) {
		Optional<PCCase> pcCase = pcCaseRepository.findById(id);
		if (pcCase.isPresent()) {
			pcCaseRepository.delete(pcCase.get());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
