package boundary;

import javax.swing.JOptionPane;

import entities.Candidato;
import entities.ListaCandidatos;

public class RetornaNotaFinal {
	//Digite o CPF do Candidato
	String CPF;
	public void RetornaNotaFinal(Candidato candidato) throws Exception {
		ListaCandidatos lista = new ListaCandidatos();
		lista.buscaCandidatosPersistidos();
		
		CPF = JOptionPane.showInputDialog("Digite o CPF do candidato ");
		
		candidato = lista.buscaCandidatoPorCPFRetornaNotaFinal(CPF);
		
	}
}