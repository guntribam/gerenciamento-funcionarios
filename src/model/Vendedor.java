package model;

public class Vendedor extends Funcionario {

	private Double totalVendas;

	public Vendedor(String nome, String cpf, String departamento, Double totalVendas) {
		super(nome, cpf, departamento);
		this.totalVendas = totalVendas;
	}

	public Double getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(Double totalVendas) {
		this.totalVendas = totalVendas;
	}

}
