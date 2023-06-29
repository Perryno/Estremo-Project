package Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Motherboard;
import enums.SocketType;
import repositories.MotherboardRepository;

@RestController
@RequestMapping("/api/motherboard")
public class MotherboardController {

	@Autowired
	private MotherboardRepository motherboardRepository;

	@GetMapping
	public List<Motherboard> getAllMotherboards() {
		return motherboardRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Motherboard> getMotherboardById(@PathVariable("id") Long id) {
		Optional<Motherboard> motherboard = motherboardRepository.findById(id);
		if (motherboard.isPresent()) {
			return ResponseEntity.ok(motherboard.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/socket/{socketType}")
	public List<Motherboard> getMotherboardsBySocketType(@PathVariable("socketType") SocketType socketType) {
		return motherboardRepository.findBySocketType(socketType);
	}

	@PostMapping
	public Motherboard createMotherboard(@RequestBody Motherboard motherboard) {
		return motherboardRepository.save(motherboard);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Motherboard> updateMotherboard(@PathVariable("id") Long id,
			@RequestBody Motherboard motherboardData) {
		Optional<Motherboard> motherboard = motherboardRepository.findById(id);
		if (motherboard.isPresent()) {
			Motherboard updatedMotherboard = motherboard.get();
			updatedMotherboard.setNome(motherboardData.getNome());
			updatedMotherboard.setPrezzo(motherboardData.getPrezzo());
			updatedMotherboard.setSocketType(motherboardData.getSocketType());

			return ResponseEntity.ok(motherboardRepository.save(updatedMotherboard));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMotherboard(@PathVariable("id") Long id) {
		Optional<Motherboard> motherboard = motherboardRepository.findById(id);
		if (motherboard.isPresent()) {
			motherboardRepository.delete(motherboard.get());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
