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
	public void verificaLattes(Candidato candidato) throws IOException {
		ListaCandidatos lista = new ListaCandidatos();
		lista.buscaCandidatosPersistidos();
		
		CPF = JOptionPane.showInputDialog("Digite o CPF do candidato ");
		
		candidato = lista.buscaCandidatoPorCPF(CPF);
		
	}
}