package projetoFinalPOO;

import java.util.ArrayList;
import java.util.Scanner;

public class ControleUsuario {
	Scanner sc = new Scanner(System.in);
	
	public ArrayList<Pessoa> cadastrarUsuario(ArrayList<Pessoa> usuarios, Impressoes imprimir){
		sc = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			String tempEmail = "";
			String tempSenha = "";
			String tempNome = "";
			Usuario u = new Usuario();
			
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
				while(tempNome.length() == 0) {
					imprimir.pedidoNome2();
					sc = new Scanner(System.in);
					tempNome = sc.nextLine();
					if(tempNome.length() == 0) {
						imprimir.entradaVazia();
					}
				}
				u.setNome(tempNome);
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
				loop = false;
			}
		}
		return usuarios;
	}
	
	public ArrayList<Pessoa> editarLoginNome(ArrayList<Pessoa> usuarios, int i, Impressoes imprimir){
		sc = new Scanner(System.in);
		String tempNome = "";
		System.out.println("Nome atual: " + usuarios.get(i).getNome());
		
		while(tempNome.length() == 0) {
			imprimir.pedidoNome3();
			sc = new Scanner(System.in);
			tempNome = sc.nextLine();
			if(tempNome.length() == 0) {
				imprimir.entradaVazia();
			}
		}
		imprimir.nomeAlterado();
		usuarios.get(i).setNome(tempNome);
		return usuarios;
	}
	
	public ArrayList<Pessoa> editarLoginSenha(ArrayList<Pessoa> usuarios, int i, Impressoes imprimir){
		sc = new Scanner(System.in);
		String tempSenha = "";
		System.out.println("Senha atual: " + usuarios.get(i).getSenha());
		
		while(tempSenha.length() == 0) {
			imprimir.pedidoSenha3();
			sc = new Scanner(System.in);
			tempSenha = sc.nextLine();
			if(tempSenha.length() == 0) {
				imprimir.entradaVazia();
			}
		}
		imprimir.senhaAlterado();
		usuarios.get(i).setSenha(tempSenha);
		return usuarios;
	}
	
	public void consultarDivida(double divida) {
		System.out.print("Dívida total: R$");
		System.out.printf("%.2f", divida);
		System.out.println("\n");
	}
	
	public void listarUsuarios(ArrayList<Pessoa> usuarios) {
		if(usuarios.isEmpty() == false) {
			for(int i = 0; i<usuarios.size(); i++) {
				System.out.println("========================================\n");
				if(usuarios.get(i) instanceof Usuario) {
					System.out.println("Usuário: \n");
				}else {
					System.out.println("Administrador: \n");
				}
				System.out.println("Nome: " + usuarios.get(i).getNome());
				System.out.println("Email: " + usuarios.get(i).getEmail() + "\n");
				
				System.out.println("========================================\n");
			}
		}else {
			System.out.println("Não há usuários cadastrados no sistema!\n");
		}
	}
	
	public void listarInfoUsuarios(ArrayList<Pessoa> usuarios, int i) {
		System.out.println("========================================\n");
		System.out.println("Usuário: \n");
		System.out.println("Nome: " + usuarios.get(i).getNome());
		System.out.println("Email: " + usuarios.get(i).getEmail() + "\n");		
		System.out.println("========================================\n");
			
	}
}
