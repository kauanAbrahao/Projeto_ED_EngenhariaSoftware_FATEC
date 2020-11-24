package control;

import java.io.IOException;

import javax.swing.JOptionPane;

import entities.Candidato;
import entities.ListaCandidatos;

public class ClassificacaoController {
	
	public void mostraClassificacao(Candidato candidato) throws IOException {
		ListaCandidatos lista = new ListaCandidatos();
		lista.buscaCandidatosPersistidos();
		lista.mostraListaOrdanadaPorNotaFinal("apenas matriculados e deferidos");
		Candidato aux = lista.getInicio();
		int c = 1;
		
		
		if(candidato.getStatus().contains("semstatus")) {
			JOptionPane.showMessageDialog(null, "Sua matr�cula no Processo Seletivo n�o foi encontrada!");
		} else if (candidato.getStatus().contains("indefereido")) {
			JOptionPane.showMessageDialog(null, "Sua matr�cula consta como indeferida. Infelizmente, n�o foi poss�vel dar continuidade ao seu processo.");
		} else {
			while(!aux.getCpf().contains(candidato.getCpf())) {
				aux = aux.getProximo();
				c++;
				
			}
			if (c <= candidato.getProcessoSeletivo().getVagas()) {
				JOptionPane.showMessageDialog(null, "PARAB�NS " + candidato.getNome().toUpperCase() + "! Voc� foi APROVADO no Curso de P�s-Gradua��o em " + candidato.getProcessoSeletivo().getCurso() + 
						"\n\n" + "Coloca��o: " + c+"�" + "\nN�mero de vagas: " + candidato.getProcessoSeletivo().getVagas() + "\nAguarde os pr�ximos contatos para dar in�cio � matr�cula");
			} else {
				JOptionPane.showMessageDialog(null, candidato.getNome().toUpperCase() + ", voc� est� em LISTA DE ESPERA" + 
						"\n\n" + "Coloca��o: " + c+"�" + "\nN�mero de vagas: " + candidato.getProcessoSeletivo().getVagas());
			}
		}
		
		
		
	}

}
