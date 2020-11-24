package boundary;

import java.io.IOException;
import entities.Candidato;
import entities.ListaCandidatos;
import entities.Candidato;
import entities.ListaCandidatos;

import javax.swing.JOptionPane;

public class AcessoLattes {
	//Digite o CPF do Candidato
	String CPF;
	public void verificaLattes(Candidato candidato) throws Exception {
		ListaCandidatos lista = new ListaCandidatos();
		lista.buscaCandidatosPersistidos();
		
		CPF = JOptionPane.showInputDialog("Escolha um candidato digitando seu CPF");
		
		candidato = lista.buscaCandidatoPorCPF(CPF);
		
	}
}