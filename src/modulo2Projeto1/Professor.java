package modulo2Projeto1;
import java.time.LocalDate;

import lombok.Data;

import lombok.Data;

@Data 
public class Professor extends Pessoa {

	 private String experiencia, formacao, estado;
	private static int num = 1;

	public Professor(String nome, int codigo, long cpf, String formacao, String experiencia, String estado, LocalDate data, long tel) {
		super(nome, codigo, cpf, data, tel);
		this.codigo = num++;
		this.experiencia = experiencia;
		this.estado = estado;
		this.formacao = formacao;
	}

}
