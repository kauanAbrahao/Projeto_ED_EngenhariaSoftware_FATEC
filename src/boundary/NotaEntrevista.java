package boundary;

import java.io.IOException;
import entities.Candidato;
import entities.ListaCandidatos;
import entities.Candidato;
import entities.ListaCandidatos;
import boundary.TelaInicialCPS;

import javax.swing.JOptionPane;

public class NotaEntrevista {
	//Digite o CPF do Candidato
	String CPF;
	public void NEntrevista(Candidato candidato) throws Exception {
		ListaCandidatos lista = new ListaCandidatos();
		lista.buscaCandidatosPersistidos();
		
		CPF = JOptionPane.showInputDialog("Digite o CPF do candidato ");
		
		candidato = lista.buscaCandidatoPorCPFEntrevista(CPF);
		
	}
}