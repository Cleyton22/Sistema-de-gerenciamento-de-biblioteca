package projetoFinalPOO;

public class Administrador extends Pessoa {
	private int codigoAdmin;
	
	public Administrador() {
		super();
		this.codigoAdmin = 0;
	}
	
	public Administrador(String nome, String senha, String email, int codigoAdmin) {
		super();
		this.codigoAdmin = codigoAdmin;
	}
	
	public int getCodigoAdmin() {
		return this.codigoAdmin;
	}
	
	public void setCodigoAdmin(int codigoAdmin) {
		this.codigoAdmin = codigoAdmin;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Administrador) {
			if(super.getEmail().equals(((Pessoa) obj).getEmail()) || this.codigoAdmin == ((Administrador) obj).getCodigoAdmin()) {
	        	return true;
	        }else {
	        	return false;
	        }
		}else {
			if(super.getEmail().equals(((Pessoa) obj).getEmail())) {
	        	return true;
	        }else {
	        	return false;
	        }
		}
    }
}
