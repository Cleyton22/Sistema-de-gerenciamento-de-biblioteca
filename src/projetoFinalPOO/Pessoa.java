package projetoFinalPOO;

public class Pessoa {
	private String nome;
	private String senha;
	private String email;
	
	public Pessoa() {
		this.nome = null;
		this.senha = null;
		this.email = null;
	}
	
	public Pessoa(String nome, String senha, String email) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public boolean equals(Object obj) {
        if(this.email.equals(((Pessoa) obj).getEmail())) {
        	return true;
        }else {
        	return false;
        }
    }
}
