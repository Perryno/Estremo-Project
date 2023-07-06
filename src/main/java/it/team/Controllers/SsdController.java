package it.team.Controllers;

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

import it.team.entities.Ssd;
import it.team.services.SsdService;

@RestController
@RequestMapping("/api/ssd")
public class SsdController {

	@Autowired
	private SsdService ssdService;

	@GetMapping
	public List<Ssd> getAllSsds() {
		return ssdService.getAllSsds();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ssd> getSsdById(@PathVariable("id") Long id) {
		Optional<Ssd> ssd = ssdService.getSsdById(id);
		if (ssd.isPresent()) {
			return ResponseEntity.ok(ssd.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Ssd createSsd(@RequestBody Ssd ssd) {
		return ssdService.createSsd(ssd);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Ssd> updateSsd(@PathVariable("id") Long id, @RequestBody Ssd ssdData) {
		Optional<Ssd> ssd = ssdService.updateSsd(id, ssdData);
		if (ssd.isPresent()) {
			return ResponseEntity.ok(ssd.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSsd(@PathVariable("id") Long id) {
		boolean deleted = ssdService.deleteSsd(id);
		if (deleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
