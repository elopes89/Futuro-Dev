package modulo2Projeto1;

import java.time.LocalDate;

import lombok.Data;

@Data
public abstract class Pessoa {

	String nome;
	long telefone;
	LocalDate dataNascimento;
	long cpf;
	int codigo;

	public Pessoa(String nome, int codigo, long cpf, LocalDate data, long tel) {
		this.nome = nome;
		this.codigo = codigo;
		this.cpf = cpf;
		this.dataNascimento = data;
		this.telefone = tel;
	}

	public Pessoa() {

	}

	public int compareTo1(Pedagogo ped) {

		return 0;
	}
}
