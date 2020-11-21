package boundary;

import java.io.IOException;
import entities.Candidato;
import entities.ListaCandidatos;
import entities.Candidato;
import entities.ListaCandidatos;
import boundary.TelaInicialCPS;

import javax.swing.JOptionPane;

public class AgendaEntrevista {
	//Digite o CPF do Candidato
	String CPF;
	public void AgendaEntrevista(Candidato candidato) throws Exception {
		ListaCandidatos lista = new ListaCandidatos();
		lista.buscaCandidatosPersistidos();
		
		CPF = JOptionPane.showInputDialog("Digite o CPF do candidato ");
		
		candidato = lista.buscaCandidatoPorCPFAgendaEntrevista(CPF);
		
	}
}