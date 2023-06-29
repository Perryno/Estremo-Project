package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Gpu;
import repositories.GpuRepository;

@Service
public class GpuService {
	@Autowired
	private GpuRepository gpuRepository;

	public List<Gpu> getAllGpus() {
		return gpuRepository.findAll();
	}

	public Optional<Gpu> getGpuById(Long id) {
		return gpuRepository.findById(id);
	}

	public Gpu createGpu(Gpu gpu) {
		return gpuRepository.save(gpu);
	}

	public Optional<Gpu> updateGpu(Long id, Gpu gpuData) {
		Optional<Gpu> gpu = gpuRepository.findById(id);
		if (gpu.isPresent()) {
			Gpu updatedGpu = gpu.get();
			updatedGpu.setNome(gpuData.getNome());
			updatedGpu.setPrezzo(gpuData.getPrezzo());
			updatedGpu.setVram(gpuData.getVram());
			updatedGpu.setPunteggio(gpuData.getPunteggio());
			return Optional.of(gpuRepository.save(updatedGpu));
		} else {
			return Optional.empty();
		}
	}

	public boolean deleteGpu(Long id) {
		Optional<Gpu> gpu = gpuRepository.findById(id);
		if (gpu.isPresent()) {
			gpuRepository.delete(gpu.get());
			return true;
		} else {
			return false;
		}
	}
}
