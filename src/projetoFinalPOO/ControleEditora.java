package projetoFinalPOO;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControleEditora {
	Scanner sc = new Scanner(System.in);

	public ArrayList<Editora> cadastrarEditora(ArrayList<Editora> editoras, Impressoes imprimir) {
		sc = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			int identificador = 0;
			String nome = "";
			String estado = "";
			String cidade = "";
			Editora editora = new Editora();
			
			while(identificador == 0) {
				try {
					imprimir.pedidoIdEditora();
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
			editora.setIdEditora(identificador);
			if(editoras.contains(editora)) {
				imprimir.editoraInvalida();
			}else {
				while(nome.length() == 0) {
					imprimir.pedidoNomeEditora();
					sc = new Scanner(System.in);
					nome = sc.nextLine();
					if(nome.length() == 0) {
						imprimir.entradaVazia();
					}
				}
				editora.setNomeEditora(nome);
				
				while(estado.length() == 0) {
					imprimir.pedidoEstado();
					sc = new Scanner(System.in);
					estado = sc.nextLine();
					if(estado.length() == 0) {
						imprimir.entradaVazia();
					}
				}
				editora.setEstado(estado);
				
				while(cidade.length() == 0) {
					imprimir.pedidoCidade();
					sc = new Scanner(System.in);
					cidade = sc.nextLine();
					if(cidade.length() == 0) {
						imprimir.entradaVazia();
					}
				}
				editora.setCidade(cidade);
				editoras.add(editora);
				imprimir.editoraCadastrada();
				loop = false;
			}
		}
		return editoras;
	}
	
	public void listarEditoras(ArrayList<Editora> editoras) {
		if(editoras.isEmpty() == false) {
			for(int i = 0; i<editoras.size(); i++) {
				System.out.println("========================================\n");
				System.out.println("Nome da editora: " + editoras.get(i).getNomeEditora());
				System.out.println("Código da editora: " + editoras.get(i).getIdEditora());
				System.out.println("Estado: " + editoras.get(i).getEstado());
				System.out.println("Cidade: " + editoras.get(i).getCidade() + "\n");
				System.out.println("========================================\n");
			}
		}else {
			System.out.println("Não há editoras cadastradas no sistema!\n");
		}
	}
	
	public void listarInfoEditora(Editora editora) {
		System.out.println("========================================\n");
		System.out.println("Nome da editora: " + editora.getNomeEditora());
		System.out.println("Código da editora: " + editora.getIdEditora());
		System.out.println("Estado: " + editora.getEstado());
		System.out.println("Cidade: " + editora.getCidade() + "\n");
		System.out.println("========================================\n");
	}
	
	public ArrayList<Editora> efetuarEdicao(ArrayList<Editora> editoras, Impressoes imprimir, ControleEditora controleEdi){
		sc = new Scanner(System.in);
		
		if(editoras.isEmpty() == false) {
			int operacao = 0;
			
			while(operacao != 5) {
				for(int i = 0; i<editoras.size(); i++) {
					operacao = 0;
					
					while(operacao == 0) {
						try {
							controleEdi.listarInfoEditora(editoras.get(i));
							imprimir.menuAlterarEditora();
							operacao = sc.nextInt();
							System.out.println();
						}catch(InputMismatchException e) {
							imprimir.erroDigitado();
							sc = new Scanner(System.in);
							operacao = 0;
						}
						switch(operacao) {
						case 1:
							String nome = "";
							
							while(nome.length() == 0) {
								imprimir.pedidoNomeEditora2();
								sc = new Scanner(System.in);
								nome = sc.nextLine();
								if(nome.length() == 0) {
									imprimir.entradaVazia();
								}
							}
							editoras.get(i).setNomeEditora(nome);
							imprimir.nomeAlterado();
							operacao = 0;
							break;
						case 2:
							String estado = "";
							
							while(estado.length() == 0) {
								imprimir.pedidoEstado2();
								sc = new Scanner(System.in);
								estado = sc.nextLine();
								if(estado.length() == 0) {
									imprimir.entradaVazia();
								}
							}
							editoras.get(i).setEstado(estado);
							imprimir.estadoAlterado();
							operacao = 0;
							break;
						case 3:
							String cidade = "";
							
							while(cidade.length() == 0) {
								imprimir.pedidoCidade2();
								sc = new Scanner(System.in);
								cidade = sc.nextLine();
								if(cidade.length() == 0) {
									imprimir.entradaVazia();
								}
							}
							editoras.get(i).setCidade(cidade);
							imprimir.cidadeAlterado();
							operacao = 0;
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
			imprimir.editorasVazio();
		}
		return editoras;
	}
}
