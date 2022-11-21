package projetoFinalPOO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ControleEmprestimo {
	Scanner sc = new Scanner(System.in);
	
	public ArrayList<Pessoa> efetuarEmprestimo(ArrayList<Livro> livros, ArrayList<Pessoa> usuarios, int i, Impressoes imprimir) {
		sc = new Scanner(System.in);
		
		if(((Usuario) usuarios.get(i)).getEmprestimo().size() < 5) {
			int tempCodigo = 0;
			Livro l = new Livro();
			
			while(tempCodigo == 0) {
				try {
					imprimir.pedidoCodigoLivro();
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
			l.setIdentificador(tempCodigo);
			
			if(livros.contains(l)) {
				if(livros.get(livros.indexOf(l)).getDisponivel()) {
					Random rand = new Random();
					int idEmprestimo = rand.nextInt(100000);
					LocalDate date = LocalDate.now();
					Emprestimo empre = new Emprestimo(idEmprestimo, livros.get(livros.indexOf(l)), 0, date);
					livros.get(livros.indexOf(l)).setDisponivel(false);
					ArrayList<Emprestimo> emprestimos = ((Usuario) usuarios.get(i)).getEmprestimo();
					emprestimos.add(empre);
					((Usuario) usuarios.get(i)).setEmprestimo(emprestimos);
					imprimir.emprestimoEfetuado();
				}else {
					imprimir.livroIndisponivel();
				}
			}else {
				imprimir.livroInexistente();
			}
		}else {
			imprimir.emprestimosCheio();
		}
		return usuarios;
	}
	
	public void listarEmprestimos(ArrayList<Emprestimo> emprestimos, Impressoes imprimir) {
		if(emprestimos.isEmpty() == false) {
			for(int i = 0; i<emprestimos.size(); i++) {
				LocalDate date = emprestimos.get(i).getDataEmprestimo();
				int dia = date.getDayOfMonth();
				int mes = date.getMonthValue();
				int ano = date.getYear();
				if(date.getMonthValue() == 11 || date.getMonthValue() == 9 || date.getMonthValue() == 6|| date.getMonthValue() == 4) {
					if(dia + 10 > 31) {
						dia = 30 - dia;
						dia = 10 - dia;
						mes += 1;
						if(mes > 12) {
							mes = 1;
							ano += 1;
						}
					}else {
						dia += 10;
					}
				}else if(date.getMonthValue() == 2) {
					if(dia + 10 > 28) {
						dia = 28 - dia;
						dia = 10 - dia;
						mes += 1;
						if(mes > 12) {
							mes = 1;
							ano += 1;
						}
					}else {
						dia += 10;
					}
				}else {
					if(dia + 10 > 31) {
						dia = 31 - dia;
						dia = 10 - dia;
						mes += 1;
						if(mes > 12) {
							mes = 1;
							ano += 1;
						}
					}else {
						dia += 10;
					}
				}
				System.out.println("========================================\n");
				System.out.println("Empréstimo " + (i+1) + ":\n");
				System.out.println("Código do empréstimo: " + emprestimos.get(i).getIdEmprestimo());
				System.out.println("Livro: " + emprestimos.get(i).getLivro().getNomeLivro());
				System.out.println("Data do empréstimo: " + date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear());
				System.out.println("Data para devolução: " + dia + "/" + mes + "/" + ano);
				
				if(emprestimos.get(i).getMulta() != 0) {
					System.out.print("Multa: R$");
					System.out.printf("%.2f", emprestimos.get(i).getMulta());
					System.out.println();
				}
				System.out.println("\n========================================\n");
			}
		}else {
			imprimir.emprestimosVazio();
		}
	}
	
	public void listarInfoEmprestimos(Emprestimo emprestimo, int i) {
		LocalDate date = emprestimo.getDataEmprestimo();
		int dia = date.getDayOfMonth();
		int mes = date.getMonthValue();
		int ano = date.getYear();
		if(date.getMonthValue() == 11 || date.getMonthValue() == 9 || date.getMonthValue() == 6|| date.getMonthValue() == 4) {
			if(dia + 10 > 31) {
				dia = 30 - dia;
				dia = 10 - dia;
				mes += 1;
				if(mes > 12) {
					mes = 1;
					ano += 1;
				}
			}else {
				dia += 10;
			}
		}else if(date.getMonthValue() == 2) {
			if(dia + 10 > 28) {
				dia = 28 - dia;
				dia = 10 - dia;
				mes += 1;
				if(mes > 12) {
					mes = 1;
					ano += 1;
				}
			}else {
				dia += 10;
			}
		}else {
			if(dia + 10 > 31) {
				dia = 31 - dia;
				dia = 10 - dia;
				mes += 1;
				if(mes > 12) {
					mes = 1;
					ano += 1;
				}
			}else {
				dia += 10;
			}
		}
		System.out.println("========================================\n");
		System.out.println("Empréstimo " + (i+1) + ":\n");
		System.out.println("Código do empréstimo: " + emprestimo.getIdEmprestimo());
		System.out.println("Livro: " + emprestimo.getLivro().getNomeLivro());
		System.out.println("Data do empréstimo: " + date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear());
		System.out.println("Data para devolução: " + dia + "/" + mes + "/" + ano);
		
		if(emprestimo.getMulta() != 0) {
			System.out.print("Multa: R$");
			System.out.printf("%.2f", emprestimo.getMulta());
			System.out.println();
		}
		System.out.println("\n========================================\n");
	}
	
	public ArrayList<Emprestimo> efetuarDevolucao(ArrayList<Emprestimo> emprestimos, ArrayList<Livro> livros, Impressoes imprimir, ControleEmprestimo controleE, ControleLivro controleL){
		sc = new Scanner(System.in);
		
		if(emprestimos.isEmpty() == false) {
			int operacao = 0;
			ArrayList<Emprestimo> remocaoPendente = new ArrayList<Emprestimo>();
			
			while(operacao != 3) {
				for(int i = 0; i<emprestimos.size(); i++) {
					operacao = 0;
					
					while(operacao == 0) {
						try {
							controleE.listarInfoEmprestimos(emprestimos.get(i), i);
							imprimir.menuDevolucao();
							operacao = sc.nextInt();
							System.out.println();
						}catch(InputMismatchException e) {
							imprimir.erroDigitado();
							sc = new Scanner(System.in);
							operacao = 0;
						}
						switch(operacao) {
						case 1:
							livros = controleL.devolucaoLivro(livros, emprestimos.get(i).getLivro().getIdentificador());
							remocaoPendente.add(emprestimos.get(i));
							imprimir.devolucaoEfetuada();
							break;
						case 2:
							break;
						case 3:
							break;
						default:
							operacao = 0;
							imprimir.operacaoInvalida();
							break;
						}
					}
					if(operacao == 3) {
						break;
					}
				}
				operacao = 3;
			}
			if(remocaoPendente.isEmpty() == false) {
				for(Emprestimo j : remocaoPendente) {
					emprestimos.remove(j);
				}
			}
		}else {
			imprimir.emprestimosVazio();
		}
		return emprestimos;
	}
	
	public ArrayList<Emprestimo> listarParaMultar(ArrayList<Emprestimo> emprestimos, Usuario usuario, Impressoes imprimir, ControleEmprestimo controleE){
		sc = new Scanner(System.in);
		int operacao = 0;
			
		while(operacao != 3) {
			for(int i = 0; i<emprestimos.size(); i++) {
				operacao = 0;
				
				while(operacao == 0) {
					try {
						controleE.listarInfoEmprestimos(emprestimos.get(i), i);
						imprimir.menuMultarEmprestimo();
						operacao = sc.nextInt();
						System.out.println();
					}catch(InputMismatchException e) {
						imprimir.erroDigitado();
						sc = new Scanner(System.in);
						operacao = 0;
					}
					switch(operacao) {
					case 1:
						if(emprestimos.get(i).getMulta() != 0) {
							imprimir.multaImpedida();
						}else {
							emprestimos.get(i).setMulta(3);
							usuario.setDivida(usuario.getDivida() + 3);
							imprimir.multaEfetuada();
						}
						break;
					case 2:
						break;
					case 3:
						break;
					default:
						operacao = 0;
						imprimir.operacaoInvalida();
						break;
					}
				}
				if(operacao == 3) {
					break;
				}
			}
			operacao = 3;
		}
		return emprestimos;
	}
}
