package modulo2Projeto1;


import java.time.LocalDate;

import lombok.Data;

@Data
public class Aluno extends Pessoa implements Comparable<Aluno> {
	private String matricula;
	private double nota;
	private static int num = 1;
	private static int numAtendimento = 0;
	private int alunoAtend;

	public Aluno(String nome, String matricula, long cpf, int codigo, double nota, int alunoAtend, LocalDate data, long tel) {
		super(nome, codigo, cpf, data, tel);
		this.matricula = matricula;
		this.codigo = num++;
		this.nota = nota;
		this.alunoAtend = numAtendimento;

	}

	@Override
	public int compareTo(Aluno aluno) {
		if (this.alunoAtend > aluno.alunoAtend) {
			return -1;
		} else if (this.alunoAtend < aluno.alunoAtend) {
			return 1;
		}
		return this.getNome().compareToIgnoreCase(aluno.getNome());
	}

}
