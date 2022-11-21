package projetoFinalPOO;

public class Editora {
	private int idEditora;
	private String nomeEditora;
	private String estado;
	private String cidade;
	
	public Editora() {
		this.idEditora = 0;
		this.nomeEditora = null;
		this.estado = null;
		this.cidade = null;
	}
	
	public Editora(int idEditora, String nomeEditora, String estado, String cidade) {
		this.idEditora = idEditora;
		this.nomeEditora = nomeEditora;
		this.estado = estado;
		this.cidade = cidade;
	}
	
	public int getIdEditora() {
		return this.idEditora;
	}
	
	public void setIdEditora(int idEditora) {
		this.idEditora = idEditora;
	}
	
	public String getNomeEditora() {
		return this.nomeEditora;
	}
	
	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCidade() {
		return this.cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	@Override
	public boolean equals(Object obj) {
        if(this.idEditora == ((Editora) obj).getIdEditora()) {
        	return true;
        }else {
        	return false;
        }
    }
}
