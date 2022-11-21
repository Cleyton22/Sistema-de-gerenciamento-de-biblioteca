package projetoFinalPOO;

import java.util.ArrayList;

public class Usuario extends Pessoa {
	private ArrayList<Emprestimo> emprestimo = new ArrayList<Emprestimo>();
	private double divida;
	
	public Usuario() {
		super();
		this.emprestimo = new ArrayList<Emprestimo>();
		this.divida = 0;
	}
	
	public Usuario(String nome, String senha, String email, ArrayList<Emprestimo> emprestimo, double divida) {
		super(nome, senha, email);
		this.emprestimo = emprestimo;
		this.divida = divida;
	}
	
	public ArrayList<Emprestimo> getEmprestimo() {
		return this.emprestimo;
	}
	
	public void setEmprestimo(ArrayList<Emprestimo> emprestimo) {
		this.emprestimo = emprestimo;
	}
	
	public double getDivida() {
		return this.divida;
	}
	
	public void setDivida(double divida) {
		this.divida = divida;
	}
	
	@Override
	public boolean equals(Object obj) {
        if(super.getEmail().equals(((Pessoa) obj).getEmail())) {
        	return true;
        }else {
        	return false;
        }
    }
}
