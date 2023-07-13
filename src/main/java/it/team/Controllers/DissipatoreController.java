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

import it.team.entities.Dissipatore;
import it.team.repositories.DissipatoreRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/dissipatore")
public class DissipatoreController {

	@Autowired
	private DissipatoreRepository dissipatoreRepository;

	@GetMapping
	public List<Dissipatore> getAllDissipatori() {
		return dissipatoreRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Dissipatore> getDissipatoreById(@PathVariable("id") Long id) {
		Optional<Dissipatore> dissipatore = dissipatoreRepository.findById(id);
		if (dissipatore.isPresent()) {
			return ResponseEntity.ok(dissipatore.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Dissipatore createDissipatore(@RequestBody Dissipatore dissipatore) {
		return dissipatoreRepository.save(dissipatore);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Dissipatore> updateDissipatore(@PathVariable("id") Long id,
			@RequestBody Dissipatore dissipatoreData) {
		Optional<Dissipatore> dissipatore = dissipatoreRepository.findById(id);
		if (dissipatore.isPresent()) {
			Dissipatore updatedDissipatore = dissipatore.get();
			updatedDissipatore.setNome(dissipatoreData.getNome());
			updatedDissipatore.setPrezzo(dissipatoreData.getPrezzo());

			return ResponseEntity.ok(dissipatoreRepository.save(updatedDissipatore));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDissipatore(@PathVariable("id") Long id) {
		Optional<Dissipatore> dissipatore = dissipatoreRepository.findById(id);
		if (dissipatore.isPresent()) {
			dissipatoreRepository.delete(dissipatore.get());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
