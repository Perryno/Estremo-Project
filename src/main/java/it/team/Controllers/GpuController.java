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

import it.team.entities.Gpu;
import it.team.repositories.GpuRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/gpu")
public class GpuController {

	@Autowired
	private GpuRepository gpuRepository;

	@GetMapping
	public List<Gpu> getAllGpus() {
		return gpuRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Gpu> getGpuById(@PathVariable("id") Long id) {
		Optional<Gpu> gpu = gpuRepository.findById(id);
		if (gpu.isPresent()) {
			return ResponseEntity.ok(gpu.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Gpu createGpu(@RequestBody Gpu gpu) {
		return gpuRepository.save(gpu);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Gpu> updateGpu(@PathVariable("id") Long id, @RequestBody Gpu gpuData) {
		Optional<Gpu> gpu = gpuRepository.findById(id);
		if (gpu.isPresent()) {
			Gpu updatedGpu = gpu.get();
			updatedGpu.setNome(gpuData.getNome());
			updatedGpu.setPrezzo(gpuData.getPrezzo());
			updatedGpu.setVram(gpuData.getVram());
			updatedGpu.setPunteggio(gpuData.getPunteggio());
			return ResponseEntity.ok(gpuRepository.save(updatedGpu));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteGpu(@PathVariable("id") Long id) {
		Optional<Gpu> gpu = gpuRepository.findById(id);
		if (gpu.isPresent()) {
			gpuRepository.delete(gpu.get());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
