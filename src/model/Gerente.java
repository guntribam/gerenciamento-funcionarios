package model;

public class Gerente extends Funcionario {

	private Double comissao;

	public Gerente(String nome, String cpf, String departamento, Double comissao) {
		super(nome, cpf, departamento);
		this.comissao = comissao;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

}
