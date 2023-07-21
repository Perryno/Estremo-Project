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

import it.team.entities.Preassemblati;
import it.team.repositories.PreassemblatiRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/preassemblati")
public class PreassemblatiController {
	@Autowired
	private PreassemblatiRepository preassemblatiRepository;

	@GetMapping
	public List<Preassemblati> getAllPreassemblati() {
		return preassemblatiRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Preassemblati> getPreassemblatiById(@PathVariable("id") Long id) {
		Optional<Preassemblati> preassemblati = preassemblatiRepository.findById(id);
		if (preassemblati.isPresent()) {
			return ResponseEntity.ok(preassemblati.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Preassemblati createPreassemblati(@RequestBody Preassemblati preassemblati) {
		return preassemblatiRepository.save(preassemblati);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Preassemblati> updatePreassemblati(@PathVariable("id") Long id,
			@RequestBody Preassemblati preassemblatiData) {
		Optional<Preassemblati> preassemblati = preassemblatiRepository.findById(id);
		if (preassemblati.isPresent()) {
			Preassemblati updatedPreassemblati = preassemblati.get();
			updatedPreassemblati.setNome(preassemblatiData.getNome());
			updatedPreassemblati.setPrezzo(preassemblatiData.getPrezzo());
			updatedPreassemblati.setCpu(preassemblatiData.getCpu());
			updatedPreassemblati.setGpu(preassemblatiData.getGpu());
			updatedPreassemblati.setSsd(preassemblatiData.getSsd());
			updatedPreassemblati.setPunteggio(preassemblatiData.getPunteggio());
			return ResponseEntity.ok(preassemblatiRepository.save(updatedPreassemblati));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePreassemblati(@PathVariable("id") Long id) {
		Optional<Preassemblati> preassemblati = preassemblatiRepository.findById(id);
		if (preassemblati.isPresent()) {
			preassemblatiRepository.delete(preassemblati.get());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
