package modulo2Projeto1;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Data
public class LabSchool {

	static int atend = 0;

	public static void main(String[] args) {

		List<Pedagogo> listaPedagogo = new ArrayList<>();
		List<Aluno> listaAluno = new ArrayList<>();
		List<Professor> listaProfessor = new ArrayList<>();
		List<Pedagogo> atendPedagogo = new ArrayList<>();
		List<Aluno> atendAluno = new ArrayList<>();

		Scanner s = new Scanner(System.in);

		String nome = "", formacao = "", experiencia = "", estado = "", matricula = "";
		long cpf = 0, telefone = 0;
		int opcao = 10;
		String dataCompleta = "2022-09-09";
		LocalDate data = LocalDate.parse(dataCompleta);

		System.out.println("BEM VINDO AO LAB SCHOOL");
		try {
			while (opcao != 0) {

				System.out.println(
						"MENU LAB SCHOOL \nEscolha as opções: \n1 Cadastrar: \n2 Listar Usuários \n3 Alterar Matrícula \n0 SAIR");
				opcao = s.nextInt();
				int opcaoCadastro = 10;
				if (opcao == 1) {

					while (opcaoCadastro != 0) {
						System.out.println(
								"Escolha as opções: 1 Pedagogo 2 Aluno 3 Professor 4 Atendimento Pedagógico 0 VOLTAR");
						opcaoCadastro = s.nextInt();

						if (opcaoCadastro == 1) {
							System.out.println("Nome do pedagogo: ");
							nome = s.next();
							System.out.println("Digite o Cpf (apenas números):");
							cpf = s.nextLong();
							System.out.println("Digite a data de nascimento: (ano-mês-dia Exemplo 2022-09-09");
							dataCompleta = s.next();
							data = LocalDate.parse(dataCompleta);
							System.out.println("Digite o telefone: ");
							telefone = s.nextLong();

							Pedagogo pedagogo = new Pedagogo(nome, 0, cpf, 0, data, telefone);
							listaPedagogo.add(pedagogo);
							atendPedagogo.add(pedagogo);
						} else if (opcaoCadastro == 2) {
							System.out.println("Nome do aluno: ");
							nome = s.next();
							System.out.println("Digite o Cpf (apenas números):");
							cpf = s.nextLong();
							int nota = 111;
							while (nota < 0 || nota > 10) {
								System.out.println("Nota do aluno: ");
								nota = s.nextInt();

								if (nota < 0 || nota > 10) {
									System.out.println("valor inválido");
								}
							}

							System.out.println("Escolha qual a situação da matrícula: \n 1 Ativo "
									+ "2 Irregular 3 Inativo 4 Atendimento pedagógico");
							int opcaoMatricula = 0;
							opcaoMatricula = s.nextInt();

							if (opcaoMatricula == 1) {
								matricula = "Ativo";
							} else if (opcaoMatricula == 2) {
								matricula = "Irregular";
							} else if (opcaoMatricula == 3) {
								matricula = "Inativo";
							} else if (opcaoMatricula == 4) {
								matricula = "Atendimento Pedagógico";
							} else {
								System.out.println("Opção inválida");
							}
							System.out.println("Digite a data de nascimento: (ano-mês-dia Exemplo 2022-09-09");
							dataCompleta = s.next();
							data = LocalDate.parse(dataCompleta);
							System.out.println("Digite o telefone: ");
							telefone = s.nextLong();
							Aluno aluno = new Aluno(nome, matricula, cpf, 0, nota, 0, data, telefone);
							listaAluno.add(aluno);
							atendAluno.add(aluno);

						} else if (opcaoCadastro == 3) {
							System.out.println("Nome do Professor: ");
							nome = s.next();
							System.out.println("Digite o Cpf (apenas números):");
							cpf = s.nextLong();
							System.out.println("Escolha qual a especialização: \n 1 Front 2 Back 3 FullStack");
							int opcaoExperiencia = s.nextInt();
							if (opcaoExperiencia == 1) {
								experiencia = "Front";
							} else if (opcaoExperiencia == 2) {
								experiencia = "Back";
							} else if (opcaoExperiencia == 3) {
								experiencia = "FullStack";
							} else {
								System.out.println("Opção inválida");
							}
							System.out.println("Escolha qual a formação: \n 1 Graduação 2 Mestrado 3 Doutorado");

							int opcaoFormacao = s.nextInt();

							if (opcaoFormacao == 1) {
								formacao = "Graduação";
							} else if (opcaoFormacao == 2) {
								formacao = "Mestrado";
							} else if (opcaoFormacao == 3) {
								formacao = "Doutorado";
							} else {
								System.out.println("Opção inválida");
							}
							System.out.println("Digite a data de nascimento: (ano-mês-dia Exemplo 2022-09-09");
							dataCompleta = s.next();
							data = LocalDate.parse(dataCompleta);
							System.out.println("Digite o telefone: ");
							telefone = s.nextLong();
							Professor professor = new Professor(nome, 0, cpf, formacao, experiencia, estado, data,
									telefone);
							listaProfessor.add(professor);
						} else if (opcaoCadastro == 4) {
							if (listaAluno.size() == 0 || listaPedagogo.size() == 0) {
								System.out.println("Não há alunos ou Pedagogos cadastrados");
							} else {
								System.out.println("LISTA DE PEDAGOGOS:");
								for (Pedagogo pedagogo : listaPedagogo) {
									System.out.println("ID: " + pedagogo.codigo + " Nome: " + pedagogo.nome);
								}
								System.out.println("\nID do pedagogo do atendimento: ");
								int idAtend = s.nextInt();
								System.out.println("LISTA DE ALUNOS:");
								for (Aluno aluno : listaAluno) {
									System.out.println("ID: " + aluno.codigo + " Nome: " + aluno.nome);
								}
								System.out.println("\nNome do aluno do atendimento: ");
								int idAlunoAtend = s.nextInt();
								int cont = 0;
								int index = 0;
								int contador = 0;
								for (int i = 0; i < listaPedagogo.size(); i++) {
									if (listaPedagogo.get(i).codigo == idAtend) {
										index = i;
										contador++;
									}
								}
								for (int j = 0; j < listaAluno.size(); j++) {
									if (listaAluno.get(j).codigo == idAlunoAtend && contador == 1) {
										listaAluno.get(j).setAlunoAtend(listaAluno.get(j).getAlunoAtend() + 1);
										listaPedagogo.get(index).setAtendimentoPessoal(
												listaPedagogo.get(index).getAtendimentoPessoal() + 1);
										atend++;
										cont++;
										System.out.println("CADASTRO REALIZADO COM SUCESSO");

									}
								}
								if (cont == 0) {
									System.out.println("UM DOS NOMES NÃO CONFERE!");
								}
							}
						}
					}
				} else if (opcao == 2) {

					int opcaoListar = 10;
					while (opcaoListar != 0) {
						System.out.println(
								"Escolha o que listar: \n1 Pedagogos 2 Alunos 3 Professores 4 Atendimentos Pedagógicos 5 Funcionarios  6 Todos 0 VOLTAR");
						opcaoListar = s.nextInt();

						if (opcaoListar == 1) {
							System.out.println("LISTA DE PEDAGOGOS");

							if (listaPedagogo.size() == 0) {
								System.out.println("Não há Pedagogos cadastrados");
							} else {
								for (Pedagogo pedagogo : listaPedagogo) {
									System.out.println("ID: " + pedagogo.codigo + " Nome: " + pedagogo.nome + " Cpf: "
											+ pedagogo.cpf + pedagogo.getAtendimentoPessoal());
								}
							}
						} else if (opcaoListar == 2) {
							if (listaAluno.size() == 0) {
								System.out.println("Não há Alunos cadastrados");
							} else {
								int opcaoAluno = 67;
								while (opcaoAluno != 0) {
									System.out.println(
											"Digite quais alunos quer listar:\n 1 Ativo 2 Irregular 3 Atend. Pedagógico 4 Inativo 5 Todos");
									opcaoAluno = s.nextInt();
									if (opcaoAluno == 1) {
										System.out.println("ALUNOS COM MATRICULA ATIVA:");
										for (Aluno aluno2 : listaAluno) {
											if (aluno2.getMatricula().equals("Ativo"))
												System.out.println("ID: " + aluno2.codigo + " Nome: " + aluno2.nome
														+ " Nota: " + aluno2.getNota() + " Matrícula: "
														+ aluno2.getMatricula() + " Atendimentos Pedagógicos: "
														+ aluno2.getAlunoAtend());
										}
									} else if (opcaoAluno == 2) {
										System.out.println("ALUNOS COM MATRICULA IRREGULAR:");
										for (Aluno aluno2 : listaAluno) {
											if (aluno2.getMatricula().equals("Irregular"))
												System.out.println("ID: " + aluno2.codigo + " Nome: " + aluno2.nome
														+ " Nota: " + aluno2.getNota() + " Matrícula: "
														+ aluno2.getMatricula() + " Atendimentos Pedagógicos: "
														+ aluno2.getAlunoAtend());
										}
									} else if (opcaoAluno == 3) {
										System.out.println("ALUNOS COM MATRICULA ATENDIMENTO PEDAGÓGICO:");
										for (Aluno aluno2 : listaAluno) {
											if (aluno2.getMatricula().equals("Atendimento Pedagógico"))
												System.out.println("ID: " + aluno2.codigo + " Nome: " + aluno2.nome
														+ " Nota: " + aluno2.getNota() + " Matrícula: "
														+ aluno2.getMatricula() + " Atendimentos Pedagógicos: "
														+ aluno2.getAlunoAtend());
										}
									} else if (opcaoAluno == 4) {
										System.out.println("ALUNOS COM MATRICULA INATIVA:");
										for (Aluno aluno2 : listaAluno) {
											if (aluno2.getMatricula().equals("Inativo"))
												System.out.println("ID: " + aluno2.codigo + " Nome: " + aluno2.nome
														+ " Nota: " + aluno2.getNota() + " Matrícula: "
														+ aluno2.getMatricula() + " Atendimentos Pedagógicos: "
														+ aluno2.getAlunoAtend());
										}
									} else if (opcaoAluno == 5) {
										System.out.println("LISTA DE TODOS ALUNOS");
										for (Aluno aluno2 : listaAluno) {
											System.out
													.println("ID: " + aluno2.codigo + " Nome: " + aluno2.nome + " Nota: "
															+ aluno2.getNota() + " Matrícula: " + aluno2.getMatricula()
															+ " Atendimentos Pedagógicos: " + aluno2.getAlunoAtend());
										}
									} else {
										System.out.println("OPÇÃO INVÁLIDA");
									}
								}
							}
						} else if (opcaoListar == 3) {
							if (listaProfessor.size() == 0) {
								System.out.println("NÃO HÁ PROFESSORES CADASTRADOS");
							} else {
								int opcaoProfessor = 80;
								while (opcaoProfessor != 0) {
									System.out.println("Digite 1 Front 2 Back 3 FullStack 4 Todos 0 VOLTAR");
									opcaoProfessor = s.nextInt();
									if (opcaoProfessor == 1) {
										System.out.println("LISTA DE PROFESSORES FRONT");
										for (Professor professor2 : listaProfessor) {
											if (professor2.getExperiencia().equals("Front")) {
												System.out.println(" ID: " + professor2.codigo + " Cpf: " + "Nome: "
														+ professor2.nome + professor2.cpf + " Formação: "
														+ professor2.getFormacao() + " Experiência: "
														+ professor2.getExperiencia());

											}
										}
									} else if (opcaoProfessor == 2) {

										System.out.println("LISTA DE PROFESSORES BACK");
										for (Professor professor2 : listaProfessor) {
											if (professor2.getExperiencia().equals("Back")) {
												System.out.println("ID: " + professor2.codigo + " Nome: "
														+ professor2.nome + " Cpf: " + professor2.cpf + " Formação: "
														+ professor2.getFormacao() + " Experiência: "
														+ professor2.getExperiencia());

											}
										}
									} else if (opcaoProfessor == 3) {
										System.out.println("LISTA DE PROFESSORES FULLSTACK");
										for (Professor professor2 : listaProfessor) {
											if (professor2.getExperiencia().equals("Full Stack")) {
												System.out.println("ID: " + professor2.codigo + " Nome: "
														+ professor2.nome + " Cpf: " + professor2.cpf + " Formação: "
														+ professor2.getFormacao() + " Experiência: "
														+ professor2.getExperiencia());

											}
										}
									} else if (opcaoProfessor == 4) {
										System.out.println("LISTA DE TODOS PROFESSORES ");
										for (Professor professor2 : listaProfessor) {
											System.out.println(
													"ID: " + professor2.codigo + " Nome: " + professor2.nome + " Cpf: "
															+ professor2.cpf + " Formação: " + professor2.getFormacao()
															+ " Experiência: " + professor2.getExperiencia());
										}
									}
								}
							}
						} else if (opcaoListar == 4) {
							int cont = 0;
							System.out.println("LISTA DE ATENDIMENTOS PEDAGÓGICOS: ");
							System.out.println("Total de atendimentos pedagógicos: " + atend);
							if (atend > 0) {
								System.out.println("Pedagogos com mais atendimentos pedagógicos: ");
								Collections.sort(atendPedagogo);
								for (Pedagogo pedagogo : atendPedagogo) {
									if (pedagogo.getAtendimentoPessoal() > 0 && cont < 5)
										System.out.println("ID: " + pedagogo.codigo + " Nome: " + pedagogo.nome
												+ " Atendimentos: " + pedagogo.getAtendimentoPessoal());
									cont++;
								}
								cont = 0;
								System.out.println("Alunos com mais atendimenots pedagógicos");
								Collections.sort(atendAluno);
								for (Aluno aluno : atendAluno) {
									if (aluno.getAlunoAtend() > 0 && cont < 5)
										System.out.println("ID: " + aluno.codigo + " Nome: " + aluno.nome
												+ " Atendimentos: " + aluno.getAlunoAtend());
									cont++;
								}

							}
						} else if (opcaoListar == 5) {
							if (listaPedagogo.size() == 0 && listaProfessor.size() == 0) {
								System.out.println("NÃO HÁ FUNCIONÁRIOS CADASTRADOS: ");
							} else {
								System.out.println("LISTA DE FUNCIONÁRIOS: ");

								if (listaPedagogo.size() == 0) {
									System.out.println("Não há Pedagogos cadastrados");
								} else {
									System.out.println("LISTA DE PEDAGOGOS");
									for (Pedagogo pedagogo : listaPedagogo) {
										System.out.println("Id: " + pedagogo.codigo + "Nome: " + pedagogo.nome + "Cpf: "
												+ pedagogo.cpf);
									}
								}
								if (listaProfessor.size() == 0) {
									System.out.println("NÃO HÁ PROFESSORES CADASTRADOS");
								} else {
									System.out.println("LISTA DE TODOS PROFESSORES ");
									for (Professor professor2 : listaProfessor) {
										System.out.println("ID: " + professor2.codigo + " Nome: " + professor2.nome
												+ " Cpf: " + professor2.cpf + " Formação: " + professor2.getFormacao()
												+ " Experiência: " + professor2.getExperiencia());
									}
								}
							}

						} else if (opcaoListar == 6) {

							if (listaPedagogo.size() == 0) {
								System.out.println("Não há Pedagogos cadastrados");
							} else {
								System.out.println("LISTA DE PEDAGOGOS");
								for (Pedagogo pedagogo : listaPedagogo) {

									System.out.println("Id: " + pedagogo.codigo + " Nome: " + pedagogo.nome + " Cpf:"
											+ pedagogo.cpf);
								}

							}

							if (listaAluno.size() == 0) {
								System.out.println("Não há Alunos cadastrados");
							} else {
								System.out.println("LISTA DE ALUNOS");
								for (Aluno aluno2 : listaAluno) {
									System.out.println(
											"ID: " + aluno2.codigo + " Nome: " + aluno2.nome + " Matrícula: " + " Cpf: "
													+ aluno2.cpf + aluno2.getMatricula() + " Nota: " + aluno2.getNota()
													+ " Atendimentos Pedagógicos: " + aluno2.getAlunoAtend());
								}
							}
							if (listaProfessor.size() == 0) {
								System.out.println("Não há Professores cadastrados");
							} else {
								System.out.println("LISTA DE TODOS PROFESSORES ");
								for (Professor professor2 : listaProfessor) {
									System.out.println("ID: " + professor2.codigo + " Nome: " + professor2.nome
											+ " Cpf: " + professor2.cpf + " Formação: " + professor2.getFormacao()
											+ " Experiência: " + professor2.getExperiencia());
								}
							}
							int cont = 0;
							System.out.println("LISTA DE ATENDIMENTOS PEDAGÓGICOS: ");
							System.out.println("Total de atendimentos pedagógicos: " + atend);
							if (atend > 0) {
								System.out.println("Pedagogos com mais atendimentos pedagógicos: ");
								Collections.sort(atendPedagogo);
								for (Pedagogo pedagogo : atendPedagogo) {
									if (pedagogo.getAtendimentoPessoal() > 0 && cont < 5)
										System.out.println("ID: " + pedagogo.codigo + " Nome: " + pedagogo.nome
												+ " Atendimentos: " + pedagogo.getAtendimentoPessoal());
									cont++;
								}
								cont = 0;
								System.out.println("Alunos com mais atendimenots pedagógicos");
								Collections.sort(atendAluno);
								for (Aluno aluno : atendAluno) {
									if (aluno.getAlunoAtend() > 0 && cont < 5)
										System.out.println("ID: " + aluno.codigo + " Nome: " + aluno.nome
												+ " Atendimentos: " + aluno.getAlunoAtend());
									cont++;
								}

							}
						}
					}

				} else if (opcao == 3) {
					int contMatricula = 0;
					int codigoAluno = 0;
					int atualizaMatricula = 0;

					if (listaAluno.size() > 0) {
						System.out.println("LISTA DE ALUNOS");
						for (Aluno aluno2 : listaAluno) {
							System.out.println("ID: " + aluno2.codigo + " Nome: " + aluno2.nome
									+ " Situação Matrícula: " + aluno2.getMatricula());
						}

						System.out.println("Digite o ID do aluno que quer editar:");
						codigoAluno = s.nextInt();
						for (int i = 0; i < listaAluno.size(); i++) {
							if (listaAluno.get(i).codigo == codigoAluno) {
								contMatricula++;
								System.out.println(
										"Atualize a matrícula: \n 1 Ativo 2 Irregular 3 Inativo 4 Atendimento pedagógico");
								atualizaMatricula = s.nextInt();
								if (atualizaMatricula == 1) {
									listaAluno.get(i).setMatricula("Ativo");
								} else if (atualizaMatricula == 2) {
									listaAluno.get(i).setMatricula("Irregular");
								} else if (atualizaMatricula == 3) {
									listaAluno.get(i).setMatricula("Inativo");
								} else if (atualizaMatricula == 4) {
									listaAluno.get(i).setMatricula("Atendimento Pedagógico");
								} else {
									System.out.println("Opção inválida");
								}
							}
						}
						if (atualizaMatricula > 0 && atualizaMatricula < 5) {
							System.out.println("ATUALIZADO COM SUCESSO");

						}
						if (contMatricula == 0) {
							System.out.println("Aluno não encontrado");
						}
					} else {
						System.out.println("NÃO TEMOS ALUNOS CADASTRADOS");
					}
				} else if (opcao == 0) {
					System.out.println("Você escolheu SAIR");

				} else {
					System.out.println("OPÇÃO INVÁLIDA!!!");
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("ERRO! USE NÚMEROS!");
		} catch (DateTimeParseException e) {
			System.out.println("ENTRADA DE DATA INVÁLIDA");
		}
		s.close();

	}
}
