package boundary;

import javax.swing.JOptionPane;

import entities.Candidato;
import entities.ListaCandidatos;

public class AcessoLattes {
	//Digite o CPF do Candidato
	String CPF;
	public void verificaLattes(Candidato candidato) throws Exception {
		ListaCandidatos lista = new ListaCandidatos();
		lista.buscaCandidatosPersistidos();
		lista.mostraListaOrdanadaPorNome("apenas matriculados");
		String CPF = JOptionPane.showInputDialog(lista.mostraLista("apenas matriculados", 1) + "\n\n" + "Por favor, inserir o CPF do candidado desejado:");
		candidato = lista.buscaCandidatoPorCPF(CPF);
		JOptionPane.showMessageDialog(null, candidato.getLattes());
		
	}
}