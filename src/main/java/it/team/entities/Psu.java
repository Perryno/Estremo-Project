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
@Table(name = "alimentatori")
public class Psu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "prezzo")
	private double prezzo;

	@Column(name = "wattaggio")
	private int wattaggio;

	@Column(name = "modulare")
	private boolean modulare;

}