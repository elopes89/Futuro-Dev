package modulo2Projeto1;
import java.time.LocalDate;

import lombok.Data;

import lombok.Data;

@Data
public class Pedagogo extends Pessoa implements Comparable<Pedagogo> {

	private int atendimentoPessoal = 0;
	private static int atendimento = 0;
	private static int num = 1;

	public Pedagogo(String nome, int codigo, long cpf, int atendimento, LocalDate data, long tel) {
		super(nome, codigo, cpf, data, tel);
		this.nome = nome;
		this.codigo = num++;
		this.atendimentoPessoal = atendimento;
	}

	@Override
	public int compareTo(Pedagogo pedagogo) {
		if (this.atendimentoPessoal > pedagogo.atendimentoPessoal) {
			return -1;
		} else if (this.atendimentoPessoal < pedagogo.atendimentoPessoal) {
			return 1;
		}
		return this.getNome().compareToIgnoreCase(pedagogo.getNome());
	}

}
