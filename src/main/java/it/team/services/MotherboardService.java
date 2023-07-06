package it.team.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.team.entities.Motherboard;
import it.team.enums.SocketType;
import it.team.repositories.MotherboardRepository;

@Service
public class MotherboardService {
	@Autowired
	private MotherboardRepository motherboardRepository;

	public List<Motherboard> getAllMotherboards() {
		return motherboardRepository.findAll();
	}

	public Optional<Motherboard> getMotherboardById(Long id) {
		return motherboardRepository.findById(id);
	}

	public Motherboard createMotherboard(Motherboard motherboard) {
		return motherboardRepository.save(motherboard);
	}

	public Optional<Motherboard> updateMotherboard(Long id, Motherboard motherboardData) {
		Optional<Motherboard> motherboard = motherboardRepository.findById(id);
		if (motherboard.isPresent()) {
			Motherboard updatedMotherboard = motherboard.get();
			updatedMotherboard.setNome(motherboardData.getNome());
			updatedMotherboard.setPrezzo(motherboardData.getPrezzo());
			updatedMotherboard.setSocketType(motherboardData.getSocketType());
			return Optional.of(motherboardRepository.save(updatedMotherboard));
		} else {
			return Optional.empty();
		}
	}

	public boolean deleteMotherboard(Long id) {
		Optional<Motherboard> motherboard = motherboardRepository.findById(id);
		if (motherboard.isPresent()) {
			motherboardRepository.delete(motherboard.get());
			return true;
		} else {
			return false;
		}
	}

	public List<Motherboard> findBySocketType(SocketType socketType) {
		return motherboardRepository.findBySocketType(socketType);
	}
}
