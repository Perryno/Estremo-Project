package it.team.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.team.entities.Cpu;
import it.team.enums.SocketType;
import it.team.repositories.CpuRepository;

@Service
public class CpuService {
	@Autowired
	private CpuRepository cpuRepository;

	public List<Cpu> getAllCpus() {
		return cpuRepository.findAll();
	}

	public Optional<Cpu> getCpuById(Long id) {
		return cpuRepository.findById(id);
	}

	public Cpu createCpu(Cpu cpu) {
		return cpuRepository.save(cpu);
	}

	public Optional<Cpu> updateCpu(Long id, Cpu cpuData) {
		Optional<Cpu> cpu = cpuRepository.findById(id);
		if (cpu.isPresent()) {
			Cpu updatedCpu = cpu.get();
			updatedCpu.setNome(cpuData.getNome());
			updatedCpu.setPrezzo(cpuData.getPrezzo());
			updatedCpu.setSocketType(cpuData.getSocketType());
			updatedCpu.setPunteggio(cpuData.getPunteggio());
			return Optional.of(cpuRepository.save(updatedCpu));
		} else {
			return Optional.empty();
		}
	}

	@Transactional
	public void insertCpu() {
		Cpu cpu = new Cpu();
		cpu.setNome("5800x3D");
		cpu.setPrezzo(350);
		cpu.setSocketType(SocketType.AM5);
		cpu.setPunteggio(300);

		cpuRepository.save(cpu);
	}

	public boolean deleteCpu(Long id) {
		Optional<Cpu> cpu = cpuRepository.findById(id);
		if (cpu.isPresent()) {
			cpuRepository.delete(cpu.get());
			return true;
		} else {
			return false;
		}
	}

	public List<Cpu> findBySocketType(SocketType socketType) {
		return cpuRepository.findBySocketType(socketType);
	}
}
