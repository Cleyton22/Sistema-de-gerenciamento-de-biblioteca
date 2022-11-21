package projetoFinalPOO;

public class Livro {
	private int identificador;
	private String nomeLivro;
	private String tema;
	private String nomeAutor;
	private Editora editora;
	private boolean disponivel;
	
	public Livro() {
		this.identificador = 0;
		this.nomeLivro = null;
		this.tema = null;
		this.nomeAutor = null;
		this.editora = null;
		this.disponivel = true;
	}
	
	public Livro(int identificador, String nomeLivro, String tema, String nomeAutor, Editora editora, boolean disponivel) {
		this.identificador = identificador;
		this.nomeLivro = nomeLivro;
		this.tema = tema;
		this.nomeAutor = nomeAutor;
		this.editora = editora;
		this.disponivel = disponivel;
	}
	
	public int getIdentificador() {
		return this.identificador;
	}
	
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	public String getNomeLivro() {
		return this.nomeLivro;
	}
	
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	
	public String getTema() {
		return this.tema;
	}
	
	public void setTema(String tema) {
		this.tema = tema;
	}
	
	public String getNomeAutor() {
		return this.nomeAutor;
	}
	
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	
	public Editora getEditora() {
		return this.editora;
	}
	
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	public boolean getDisponivel() {
		return this.disponivel;
	}
	
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	@Override
	public boolean equals(Object obj) {
        if(this.identificador == ((Livro) obj).getIdentificador()) {
        	return true;
        }else {
        	return false;
        }
    }
}
