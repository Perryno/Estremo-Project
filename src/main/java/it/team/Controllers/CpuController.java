package it.team.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.team.entities.Cpu;
import it.team.enums.SocketType;
import it.team.repositories.CpuRepository;

@RestController
@RequestMapping("/cpu")
public class CpuController {

	private final CpuRepository cpuRepository;

	@Autowired
	public CpuController(CpuRepository cpuRepository) {
		this.cpuRepository = cpuRepository;
	}

	@GetMapping("/cpus")
	public Iterable<Cpu> getCpus() {
		return cpuRepository.findAll();
	}

	@GetMapping("/{id}")
	public Cpu getCpuById(@PathVariable Long id) {
		return cpuRepository.findById(id).orElse(null);
	}

	@GetMapping("/socket/{socket}")
	public List<Cpu> getCpusBySocket(@PathVariable SocketType socketType) {
		return cpuRepository.findBySocketType(socketType);
	}

	@PostMapping
	public Cpu createCpu(@RequestBody Cpu cpu) {
		return cpuRepository.save(cpu);
	}

	@PutMapping("/{id}")
	public Cpu updateCpu(@PathVariable Long id, @RequestBody Cpu updatedCpu) {
		Cpu cpu = cpuRepository.findById(id).orElse(null);
		if (cpu != null) {

			cpu.setNome(updatedCpu.getNome());
			cpu.setPrezzo(updatedCpu.getPrezzo());
			cpu.setSocketType(updatedCpu.getSocketType());
			cpu.setPunteggio(updatedCpu.getPunteggio());

			return cpuRepository.save(cpu);
		} else {
			return null;
		}
	}

	@DeleteMapping("/{id}")
	public void deleteCpu(@PathVariable Long id) {
		cpuRepository.deleteById(id);
	}
}
