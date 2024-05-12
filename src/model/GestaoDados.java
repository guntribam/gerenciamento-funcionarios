package model;

import java.util.ArrayList;
import java.util.List;

public class GestaoDados {

	private static final double COMISSAO_GERENTE = 0.2;
	private List<Funcionario> funcionarios;

	public GestaoDados() {
		super();
		this.funcionarios = new ArrayList<>();
	}

	public void salvar(Vendedor vendedor) {
		Double somaTotalVendas = 0.0;
		Gerente gerenteDoVendedor = getGerenteDoVendedor(vendedor);
		funcionarios.add(vendedor);
		if (gerenteDoVendedor != null) {
			for (var funcionario : funcionarios) {
				if (funcionario instanceof Vendedor) {
					if (funcionario.getDepartamento().equals(vendedor.getDepartamento())) {
						somaTotalVendas += ((Vendedor) funcionario).getTotalVendas();
					}
				}
			}
			gerenteDoVendedor.setComissao(somaTotalVendas * COMISSAO_GERENTE);
		}
	}

	public void salvar(Gerente gerente) {
		Double somaTotalVendas = 0.0;
		for (var funcionario : funcionarios) {
			if (funcionario instanceof Vendedor) {
				if (funcionario.getDepartamento().equals(gerente.getDepartamento())) {
					somaTotalVendas += ((Vendedor) funcionario).getTotalVendas();
				}
			}
		}
		gerente.setComissao(somaTotalVendas * COMISSAO_GERENTE);
		funcionarios.add(gerente);
	}

	public List<Funcionario> listar() {
		return funcionarios;
	}

	private Gerente getGerenteDoVendedor(Vendedor vendedor) {
		for (var funcionario : funcionarios) {
			if (funcionario instanceof Gerente) {
				if (funcionario.getDepartamento().equals(vendedor.getDepartamento())) {
					return (Gerente) funcionario;
				}
			}
		}
		return null;
	}

}
