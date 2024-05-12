package model;

public abstract class Funcionario {

	private String nome;
	private String cpf;
	private String departamento;
	
	
	public Funcionario(String nome, String cpf, String departamento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

}
