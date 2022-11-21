package projetoFinalPOO;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControleAdmin {
	Scanner sc = new Scanner(System.in);

	public ArrayList<Pessoa> cadastrarAdmin(ArrayList<Pessoa> usuarios, Impressoes imprimir) {
		sc = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			String tempEmail = "";
			String tempSenha = "";
			String nome = "";
			Administrador u = new Administrador();
			
			while(tempEmail.length() == 0) {
				imprimir.pedidoEmail2();
				sc = new Scanner(System.in);
				tempEmail = sc.nextLine();
				if(tempEmail.length() == 0) {
					imprimir.entradaVazia();
				}
			}
			u.setEmail(tempEmail);
			
			if(usuarios.contains(u)) {
				imprimir.emailInvalido();
			}else {
				boolean loop2 = true;
				
				while(loop2) {
					int tempCodigo = 0;
					
					while(tempCodigo == 0) {
						try {
							imprimir.pedidoCodigoAdmin2();
							sc = new Scanner(System.in);
							tempCodigo = sc.nextInt();
						}catch(InputMismatchException e) {
							imprimir.erroDigitado();
							sc = new Scanner(System.in);
							tempCodigo = 0;
						}
						if(tempCodigo == 0) {
							imprimir.entradaVazia();
						}
					}
					u.setCodigoAdmin(tempCodigo);
					
					if(usuarios.contains(u)) {
						imprimir.codigoAdminInvalido();
					}else {
						while(nome.length() == 0) {
							imprimir.pedidoNome2();
							sc = new Scanner(System.in);
							nome = sc.nextLine();
							if(nome.length() == 0) {
								imprimir.entradaVazia();
							}
						}
						u.setNome(nome);
						
						while(tempSenha.length() == 0) {
							imprimir.pedidoSenha2();
							sc = new Scanner(System.in);
							tempSenha = sc.nextLine();
							if(tempSenha.length() == 0) {
								imprimir.entradaVazia();
							}
						}
						u.setSenha(tempSenha);
						usuarios.add(u);
						imprimir.loginCadastrado();
						loop2 = false;
					}
				}
				loop = false;
			}
		}
		return usuarios;
	}
	
	public ArrayList<Pessoa> efetuarMultas(ArrayList<Pessoa> usuarios, Impressoes imprimir, ControleUsuario controleU, ControleEmprestimo controleE){
		sc = new Scanner(System.in);
		int operacao = 0;
		int contem = 0;
		
		while(operacao != 3) {
			for(int i = 0; i<usuarios.size(); i++) {
				if(usuarios.get(i) instanceof Usuario) {
					contem = 1;
					operacao = 0;
					
					while(operacao == 0) {
						try {
							controleU.listarInfoUsuarios(usuarios, i);
							imprimir.menuMultar();
							operacao = sc.nextInt();
							System.out.println();
						}catch(InputMismatchException e) {
							imprimir.erroDigitado();
							sc = new Scanner(System.in);
							operacao = 0;
						}
						switch(operacao) {
						case 1:
							if(((Usuario) usuarios.get(i)).getEmprestimo().isEmpty()) {
								imprimir.emprestimosVazio2();
							}else {
								((Usuario) usuarios.get(i)).setEmprestimo(controleE.listarParaMultar(((Usuario) usuarios.get(i)).getEmprestimo(), ((Usuario) usuarios.get(i)), imprimir, controleE));
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
			}
			operacao = 3;
		}
		if(contem == 0) {
			imprimir.usuariosVazio();
		}
		return usuarios;
	}
}
