package boundary;

import java.io.IOException;
import entities.Candidato;
import entities.ListaCandidatos;
import entities.Candidato;
import entities.ListaCandidatos;
import boundary.TelaInicialCPS;

import javax.swing.JOptionPane;

public class NotaCurriculo {
	//Digite o CPF do Candidato
	String CPF;
	public void NCurriculo(Candidato candidato) throws Exception {
		ListaCandidatos lista = new ListaCandidatos();
		lista.buscaCandidatosPersistidos();
		
		CPF = JOptionPane.showInputDialog("Digite o CPF do candidato ");
		
		candidato = lista.buscaCandidatoPorCPFCurriculo(CPF);
		
	}
}