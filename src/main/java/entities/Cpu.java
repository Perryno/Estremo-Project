package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enums.SocketType;
import lombok.Data;

@Data
@Entity
@Table(name = "processori")
public class Cpu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "prezzo")
	private double prezzo;

	@Column(name = "socket")
	private SocketType socketType;

	@Column(name = "punteggio")
	private double punteggio;

}