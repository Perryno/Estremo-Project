package it.team.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "preassemblati")
public class Preassemblati {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "prezzo")
	private double prezzo;

	@Column(name = "cpu")
	private String cpu;

	@Column(name = "gpu")
	private String gpu;

	@Column(name = "ssd")
	private String ssd;

	@Column(name = "punteggio")
	private int punteggio;
}