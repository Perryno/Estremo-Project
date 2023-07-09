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

import it.team.entities.Ram;
import it.team.repositories.RamRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/ram")
public class RamController {

	@Autowired
	private RamRepository ramRepository;

	@GetMapping
	public List<Ram> getAllRams() {
		return ramRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ram> getRamById(@PathVariable("id") Long id) {
		Optional<Ram> ram = ramRepository.findById(id);
		if (ram.isPresent()) {
			return ResponseEntity.ok(ram.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Ram createRam(@RequestBody Ram ram) {
		return ramRepository.save(ram);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Ram> updateRam(@PathVariable("id") Long id, @RequestBody Ram ramData) {
		Optional<Ram> ram = ramRepository.findById(id);
		if (ram.isPresent()) {
			Ram updatedRam = ram.get();
			updatedRam.setNome(ramData.getNome());
			updatedRam.setPrezzo(ramData.getPrezzo());
			updatedRam.setPunteggio(ramData.getPunteggio());
			updatedRam.setCapacita(ramData.getCapacita());
			updatedRam.setFrequenza(ramData.getFrequenza());
			return ResponseEntity.ok(ramRepository.save(updatedRam));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRam(@PathVariable("id") Long id) {
		Optional<Ram> ram = ramRepository.findById(id);
		if (ram.isPresent()) {
			ramRepository.delete(ram.get());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
