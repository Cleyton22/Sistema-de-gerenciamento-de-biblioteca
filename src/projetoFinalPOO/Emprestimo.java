package projetoFinalPOO;

import java.time.LocalDate;

public class Emprestimo {
	private int idEmprestimo;
	private Livro livro;
	private float multa;
	private LocalDate dataEmprestimo = LocalDate.now();
	
	public Emprestimo() {
		this.idEmprestimo = 0;
		this.livro = null;
		this.multa = 0;
		this.dataEmprestimo = null;
	}
	
	public Emprestimo(int idEmprestimo, Livro livro, float multa, LocalDate dataEmprestimo) {
		this.idEmprestimo = idEmprestimo;
		this.livro = livro;
		this.multa = multa;
		this.dataEmprestimo = dataEmprestimo;
	}
	
	public int getIdEmprestimo() {
		return this.idEmprestimo;
	}
	
	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	
	public Livro getLivro() {
		return this.livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public float getMulta() {
		return this.multa;
	}
	
	public void setMulta(float multa) {
		this.multa = multa;
	}
	
	public LocalDate getDataEmprestimo() {
		return this.dataEmprestimo;
	}
	
	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
}
