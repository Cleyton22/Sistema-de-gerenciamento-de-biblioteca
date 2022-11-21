package projetoFinalPOO;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int operacao = 0;
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Impressoes imprimir = new Impressoes();
		ControleUsuario controleU = new ControleUsuario();
		ControleAdmin controleA = new ControleAdmin();
		ControleLivro controleL = new ControleLivro();
		ControleEmprestimo controleE = new ControleEmprestimo();
		ControleEditora controleEdi = new ControleEditora();
		ArrayList<Pessoa> usuarios = new ArrayList<Pessoa>();
		ArrayList<Livro> livros = new ArrayList<Livro>();
		ArrayList<Editora> editoras = new ArrayList<Editora>();
		/*Editora edi = new Editora();
		edi.setNomeEditora("Alura");
		Livro l = new Livro(777, "Besta", "Animais", "Jorge Roma", edi, true);
		Livro l2 = new Livro(888, "Praias", "Locais", "Pedro Alok", edi, true);
		livros.add(l);
		livros.add(l2);*/
		imprimir.bemVindo();
		
		do {
			try {
				imprimir.menuInicial();
				operacao = sc.nextInt();
				System.out.println();
			}catch(InputMismatchException e) {
				imprimir.erroDigitado();
				sc = new Scanner(System.in);
				operacao = 0;
			}
			if(operacao == 1) {
				String tempEmail;
				String tempSenha;
				Usuario u = new Usuario();
				imprimir.pedidoEmail();
				sc = new Scanner(System.in);
				tempEmail = sc.nextLine();
				u.setEmail(tempEmail);
				
				if(usuarios.contains(u)) {
					if(usuarios.get(usuarios.indexOf(u)) instanceof Usuario) {
						imprimir.pedidoSenha();
						tempSenha = sc.nextLine();
						
						if(usuarios.get(usuarios.indexOf(u)).getSenha().equals(tempSenha)) {
							imprimir.loginValido();
							
							do {
								try {
									imprimir.menuUsuario();;
									operacao = sc.nextInt();
									System.out.println();
								} catch (InputMismatchException e) {
									imprimir.erroDigitado();
									sc = new Scanner(System.in);
									operacao = 0;
								}
								switch(operacao) {
								case 1:
									sc = new Scanner(System.in);
									int alteracao = 0;
									
									do {
										try {
											imprimir.menuAlterarLogin();
											alteracao = sc.nextInt();
											System.out.println();
										}catch(InputMismatchException e) {
											imprimir.erroDigitado();
											sc = new Scanner(System.in);
											alteracao = 0;
										}
										switch(alteracao) {
										case 1:
											usuarios = controleU.editarLoginNome(usuarios, usuarios.indexOf(u), imprimir);
											break;
										case 2:
											usuarios = controleU.editarLoginSenha(usuarios, usuarios.indexOf(u), imprimir);
											break;
										default:
											if(alteracao < 1 || alteracao > 3) {
												imprimir.operacaoInvalida();
												alteracao = 0;
											}
											break;
										}
									}while(alteracao != 3);
									break;
								case 2:
									controleL.listarLivros(livros);
									break;
								case 3:
									if(((Usuario) usuarios.get(usuarios.indexOf(u))).getDivida() == 0) {
										if(livros.isEmpty()) {
											imprimir.livrosVazio();
										}else {
											usuarios = controleE.efetuarEmprestimo(livros, usuarios, usuarios.indexOf(u), imprimir);
										}
									}else {
										imprimir.emprestimoImpedido();
									}
									break;
								case 4:
									controleE.listarEmprestimos(((Usuario) usuarios.get(usuarios.indexOf(u))).getEmprestimo(), imprimir);
									break;
								case 5:
									controleU.consultarDivida(((Usuario) usuarios.get(usuarios.indexOf(u))).getDivida());
									break;
								case 6:
									if(((Usuario) usuarios.get(usuarios.indexOf(u))).getDivida() == 0) {
										imprimir.semMultas();
									}else {
										((Usuario) usuarios.get(usuarios.indexOf(u))).setDivida(0);
										for(int i = 0; i<((Usuario) usuarios.get(usuarios.indexOf(u))).getEmprestimo().size(); i++) {
											((Usuario) usuarios.get(usuarios.indexOf(u))).getEmprestimo().get(i).setMulta(0);
										}
										imprimir.pagamentoEfetuado();
									}
									break;
								case 7:
									((Usuario) usuarios.get(usuarios.indexOf(u))).setEmprestimo(controleE.efetuarDevolucao(((Usuario) usuarios.get(usuarios.indexOf(u))).getEmprestimo(), livros, imprimir, controleE, controleL));
									break;
								default:
									if(operacao != 8) {
										imprimir.operacaoInvalida();
									}
									break;
								}
							}while(operacao != 8);
						}else {
							imprimir.loginInvalido();
						}
					}else {
						imprimir.emailInvalido3();
					}
				}else {
					imprimir.emailInvalido2();
				}
				operacao = 1;
			}else if(operacao == 2) {
				sc = new Scanner(System.in);
				int tempCodigo = 0;
				String tempEmail;
				String tempSenha = "";
				Administrador a = new Administrador();
				imprimir.pedidoEmail();
				tempEmail = sc.nextLine();
				a.setEmail(tempEmail);
				if(usuarios.contains(a)) {
					if(usuarios.get(usuarios.indexOf(a)) instanceof Administrador) {
						while(tempCodigo == 0) {
							try {
								imprimir.pedidoCodigoAdmin();
								sc = new Scanner(System.in);
								tempCodigo = sc.nextInt();
							}catch(InputMismatchException e) {
								imprimir.erroDigitado2();
								sc = new Scanner(System.in);
								tempCodigo = 0;
							}
							if(tempCodigo == 0) {
								imprimir.entradaVazia();
							}
						}
						if(((Administrador) usuarios.get(usuarios.indexOf(a))).getCodigoAdmin() == tempCodigo) {
							imprimir.pedidoSenha();
							tempSenha = sc2.nextLine();
							
							if(usuarios.get(usuarios.indexOf(a)).getSenha().equals(tempSenha)) {
								imprimir.loginValido();
								
								do {
									try {
										imprimir.menuAdmin();;
										operacao = sc.nextInt();
										System.out.println();
									} catch (InputMismatchException e) {
										imprimir.erroDigitado();
										sc = new Scanner(System.in);
										operacao = 0;
									}
									switch(operacao) {
									case 1:
										sc = new Scanner(System.in);
										int alteracao = 0;
										
										do {
											try {
												imprimir.menuAlterarLogin();
												alteracao = sc.nextInt();
												System.out.println();
											}catch(InputMismatchException e) {
												imprimir.erroDigitado();
												sc = new Scanner(System.in);
												alteracao = 0;
											}
											switch(alteracao) {
											case 1:
												usuarios = controleU.editarLoginNome(usuarios, usuarios.indexOf(a), imprimir);
												break;
											case 2:
												usuarios = controleU.editarLoginSenha(usuarios, usuarios.indexOf(a), imprimir);
												break;
											default:
												if(alteracao < 1 || alteracao > 3) {
													imprimir.operacaoInvalida();
													alteracao = 0;
												}
												break;
											}
										}while(alteracao != 3);
										break;
									case 2:
										controleL.listarLivros(livros);
										break;
									case 3:
										controleU.listarUsuarios(usuarios);
										break;
									case 4:
										controleEdi.listarEditoras(editoras);
										break;
									case 5:
										editoras = controleEdi.cadastrarEditora(editoras, imprimir);
										break;
									case 6:
										editoras = controleEdi.efetuarEdicao(editoras, imprimir, controleEdi);
										break;
									case 7:
										livros = controleL.cadastrarLivro(livros, editoras, imprimir);
										break;
									case 8:
										livros = controleL.efetuarEdicao(livros, imprimir, controleL);
										break;
									case 9:
										usuarios = controleA.efetuarMultas(usuarios, imprimir, controleU, controleE);
										break;
									default:
										if(operacao != 10) {
											imprimir.operacaoInvalida();
										}
										break;
									}
								}while(operacao != 10);
							}else {
								imprimir.loginInvalido();
							}
						}else {
							imprimir.loginInvalido2();
						}
					}else {
						imprimir.emailInvalido4();
					}
				}else {
					imprimir.emailInvalido2();
				}
				operacao = 1;
			}else if(operacao == 3) {
				sc = new Scanner(System.in);
				int cargo = 0;
				
				while(cargo == 0) {
					try {
						imprimir.menuCadastro();
						cargo = sc.nextInt();
						System.out.println();
					}catch(InputMismatchException e) {
						imprimir.erroDigitado();
						sc = new Scanner(System.in);
						cargo = 0;
					}
					if(cargo < 1 || cargo > 2) {
						imprimir.cargoInvalido();
						cargo = 0;
					}
				}
				if(cargo == 1) {
					usuarios = controleU.cadastrarUsuario(usuarios, imprimir);
				}else {
					usuarios = controleA.cadastrarAdmin(usuarios, imprimir);
				}
				operacao = 3;
			}
			if (operacao < 1 || operacao > 4) {
				imprimir.operacaoInvalida();
			}
		}while(operacao != 4);
		sc.close();
		sc2.close();
	}
}
