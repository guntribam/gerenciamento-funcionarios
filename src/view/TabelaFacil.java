package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabelaFacil {

	private String[] cabecalhos;
	private List<Object[]> linhas;

	public TabelaFacil(String... cabecalhos) {
		this.cabecalhos = cabecalhos;
		this.linhas = new ArrayList<>();
	}

	public void adicionarLinha(Object... colunas) {
		linhas.add(colunas);
	}

	public JScrollPane gerar() {

		var model = new DefaultTableModel(cabecalhos, 0);

		for (var linha : linhas) {
			model.addRow(linha);
		}
		JTable tabela = new JTable(model);

		return new JScrollPane(tabela);

	}

}
