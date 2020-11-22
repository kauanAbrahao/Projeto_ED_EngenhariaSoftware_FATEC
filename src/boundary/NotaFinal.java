package boundary;

import javax.swing.JOptionPane;

import entities.Candidato;
import entities.ListaCandidatos;

public class NotaFinal {
	//Digite o CPF do Candidato
	String CPF;
	public void NotaFinal(Candidato candidato) throws Exception {
		ListaCandidatos lista = new ListaCandidatos();
		lista.buscaCandidatosPersistidos();
		
		CPF = JOptionPane.showInputDialog("Digite o CPF do candidato ");
		
		candidato = lista.buscaCandidatoPorCPFNotaFinal(CPF);
		
	}
}