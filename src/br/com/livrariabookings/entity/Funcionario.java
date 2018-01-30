package br.com.livrariabookings.entity;

public class Funcionario extends Usuario {

	private static final long serialVersionUID = 1L;
	
	private Nivel nivel;
	
	public Funcionario() {

	}

	@Override
	public String toString() {
		return super.toString() + ", " + nivel.toString();
	}

	public Nivel getNivel() {
		return nivel;
	}


	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	public enum Nivel {
		ADMIN, NORMAL
	}
}
