package projetoFinalPOO;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControleLivro {
	Scanner sc = new Scanner(System.in);
	
	public ArrayList<Livro> cadastrarLivro(ArrayList<Livro> livros, ArrayList<Editora> editoras, Impressoes imprimir) {
		if(editoras.size() == 0) {
			imprimir.editorasVazio2();
		}else {
			sc = new Scanner(System.in);
			boolean loop = true;
			
			while(loop) {
				int identificador = 0;
				int identEditora = 0;
				String titulo = "";
				String tema = "";
				String nomeAutor = "";
				Livro livro = new Livro();
				Editora editora = new Editora();
				
				while(identificador == 0) {
					try {
						imprimir.pedidoIdLivro();
						sc = new Scanner(System.in);
						identificador = sc.nextInt();
					}catch(InputMismatchException e) {
						imprimir.erroDigitado2();
						sc = new Scanner(System.in);
						identificador = 0;
					}
					if(identificador == 0) {
						imprimir.entradaVazia();
					}
				}
				livro.setIdentificador(identificador);
				if(livros.contains(livro)) {
					imprimir.livroInvalido();
				}else {
					while(titulo.length() == 0) {
						imprimir.pedidoNomeLivro();
						sc = new Scanner(System.in);
						titulo = sc.nextLine();
						if(titulo.length() == 0) {
							imprimir.entradaVazia();
						}
					}
					livro.setNomeLivro(titulo);
					
					while(tema.length() == 0) {
						imprimir.pedidoTema();
						sc = new Scanner(System.in);
						tema = sc.nextLine();
						if(tema.length() == 0) {
							imprimir.entradaVazia();
						}
					}
					livro.setTema(tema);
					
					while(nomeAutor.length() == 0) {
						imprimir.pedidoNomeAutor();
						sc = new Scanner(System.in);
						nomeAutor = sc.nextLine();
						if(nomeAutor.length() == 0) {
							imprimir.entradaVazia();
						}
					}
					livro.setNomeAutor(nomeAutor);
					
					while(identEditora == 0) {
						try {
							imprimir.pedidoIdEditora();
							sc = new Scanner(System.in);
							identEditora = sc.nextInt();
						}catch(InputMismatchException e) {
							imprimir.erroDigitado2();
							sc = new Scanner(System.in);
							identEditora = 0;
						}
						if(identEditora == 0) {
							imprimir.entradaVazia();
						}
						editora.setIdEditora(identEditora);
						if(editoras.contains(editora)) {
							editora = editoras.get(editoras.indexOf(editora));
						}else {
							if(identEditora != 0) {
								identEditora = 0;
								imprimir.editoraIdInvalida();
							}
						}
					}
					livro.setEditora(editora);
					livros.add(livro);
					imprimir.livroCadastrado();
					loop = false;
				}
			}
		}
		return livros;
	}
	
	public void listarLivros(ArrayList<Livro> livros) {
		if(livros.isEmpty() == false) {
			for(int i = 0; i<livros.size(); i++) {
				System.out.println("========================================\n");
				System.out.println("Título: " + livros.get(i).getNomeLivro());
				System.out.println("Tema: " + livros.get(i).getTema());
				System.out.println("Autor: " + livros.get(i).getNomeAutor());
				System.out.println("Editora: " + livros.get(i).getEditora().getNomeEditora());
				System.out.println("Código do livro: " + livros.get(i).getIdentificador());
				
				if(livros.get(i).getDisponivel()) {
					System.out.println("Estado: Disponível\n");
				}else {
					System.out.println("Estado: Indisponível\n");
				}
				System.out.println("========================================\n");
			}
		}else {
			System.out.println("Não há livros cadastrados na biblioteca!\n");
		}
	}
	
	public void listarInfoLivro(Livro livro) {
		System.out.println("========================================\n");
		System.out.println("Título: " + livro.getNomeLivro());
		System.out.println("Tema: " + livro.getTema());
		System.out.println("Autor: " + livro.getNomeAutor());
		System.out.println("Editora: " + livro.getEditora().getNomeEditora());
		System.out.println("Código do livro: " + livro.getIdentificador());
		
		if(livro.getDisponivel()) {
			System.out.println("Estado: Disponível\n");
		}else {
			System.out.println("Estado: Indisponível\n");
		}
		System.out.println("========================================\n");
	}
	
	public ArrayList<Livro> devolucaoLivro(ArrayList<Livro> livros, int identificador){
		Livro livro = new Livro();
		livro.setIdentificador(identificador);
		livros.get(livros.indexOf(livro)).setDisponivel(true);
		
		return livros;
	}
	
	public ArrayList<Livro> efetuarEdicao(ArrayList<Livro> livros, Impressoes imprimir, ControleLivro controleL){
		sc = new Scanner(System.in);
		
		if(livros.isEmpty() == false) {
			int operacao = 0;
			
			while(operacao != 5) {
				for(int i = 0; i<livros.size(); i++) {
					operacao = 0;
					
					while(operacao == 0) {
						try {
							controleL.listarInfoLivro(livros.get(i));
							imprimir.menuAlterarLivro();
							operacao = sc.nextInt();
							System.out.println();
						}catch(InputMismatchException e) {
							imprimir.erroDigitado();
							sc = new Scanner(System.in);
							operacao = 0;
						}
						switch(operacao) {
						case 1:
							if(livros.get(i).getDisponivel() == false) {
								imprimir.livroIndisponivel2();
							}else {
								String titulo = "";
								
								while(titulo.length() == 0) {
									imprimir.pedidoNomeLivro2();
									sc = new Scanner(System.in);
									titulo = sc.nextLine();
									if(titulo.length() == 0) {
										imprimir.entradaVazia();
									}
								}
								livros.get(i).setNomeLivro(titulo);
								imprimir.nomeLivroAlterado();
								operacao = 0;
							}
							break;
						case 2:
							if(livros.get(i).getDisponivel() == false) {
								imprimir.livroIndisponivel2();
							}else {
								String tema = "";
								
								while(tema.length() == 0) {
									imprimir.pedidoTema2();
									sc = new Scanner(System.in);
									tema = sc.nextLine();
									if(tema.length() == 0) {
										imprimir.entradaVazia();
									}
								}
								livros.get(i).setTema(tema);
								imprimir.temaAlterado();
								operacao = 0;
							}
							break;
						case 3:
							if(livros.get(i).getDisponivel() == false) {
								imprimir.livroIndisponivel2();
							}else {
								String nomeAutor = "";
								
								while(nomeAutor.length() == 0) {
									imprimir.pedidoNomeAutor2();
									sc = new Scanner(System.in);
									nomeAutor = sc.nextLine();
									if(nomeAutor.length() == 0) {
										imprimir.entradaVazia();
									}
								}
								livros.get(i).setNomeAutor(nomeAutor);
								imprimir.nomeAutorAlterado();
								operacao = 0;
							}
							break;
						case 4:
							break;
						case 5:
							break;
						default:
							operacao = 0;
							imprimir.operacaoInvalida();
							break;
						}
					}
					if(operacao == 5) {
						break;
					}
				}
				operacao = 5;
			}
		}else {
			imprimir.livrosVazio();
		}
		return livros;
	}
}
