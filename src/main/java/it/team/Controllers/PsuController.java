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

import it.team.entities.Psu;
import it.team.repositories.PsuRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/psu")
public class PsuController {

	@Autowired
	private PsuRepository psuRepository;

	@GetMapping
	public List<Psu> getAllPsus() {
		return psuRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Psu> getPsuById(@PathVariable("id") Long id) {
		Optional<Psu> psu = psuRepository.findById(id);
		if (psu.isPresent()) {
			return ResponseEntity.ok(psu.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Psu createPsu(@RequestBody Psu psu) {
		return psuRepository.save(psu);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Psu> updatePsu(@PathVariable("id") Long id, @RequestBody Psu psuData) {
		Optional<Psu> psu = psuRepository.findById(id);
		if (psu.isPresent()) {
			Psu updatedPsu = psu.get();
			updatedPsu.setNome(psuData.getNome());
			updatedPsu.setPrezzo(psuData.getPrezzo());
			updatedPsu.setWattaggio(psuData.getWattaggio());
			updatedPsu.setModulare(psuData.isModulare());
			return ResponseEntity.ok(psuRepository.save(updatedPsu));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePsu(@PathVariable("id") Long id) {
		Optional<Psu> psu = psuRepository.findById(id);
		if (psu.isPresent()) {
			psuRepository.delete(psu.get());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
