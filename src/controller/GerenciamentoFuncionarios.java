package controller;

import java.util.List;

import model.Funcionario;
import model.Gerente;
import model.GestaoDados;
import model.Vendedor;

public class GerenciamentoFuncionarios {
	private GestaoDados gestaoDados;

	public GerenciamentoFuncionarios() {
		super();
		gestaoDados = new GestaoDados();
	}

	public void salvarFuncionario(String nome, String cpf, String departamento, Double totalVendas) {
		var vendedor = new Vendedor(nome, cpf, departamento, totalVendas);
		gestaoDados.salvar(vendedor);
	}

	public void salvarFuncionario(String nome, String cpf, String departamento) {
		var gerente = new Gerente(nome, cpf, departamento, null);
		gestaoDados.salvar(gerente);
	}

	public List<Funcionario> listarFuncionarios() {
		return gestaoDados.listar();
	}

}
