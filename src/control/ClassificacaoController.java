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
			JOptionPane.showMessageDialog(null, "Sua matrícula no Processo Seletivo não foi encontrada!");
		} else if (candidato.getStatus().contains("indefereido")) {
			JOptionPane.showMessageDialog(null, "Sua matrícula consta como indeferida. Infelizmente, não foi possível dar continuidade ao seu processo.");
		} else {
			while(!aux.getCpf().contains(candidato.getCpf())) {
				aux = aux.getProximo();
				c++;
				
			}
			if (c <= candidato.getProcessoSeletivo().getVagas()) {
				JOptionPane.showMessageDialog(null, "PARABÉNS " + candidato.getNome().toUpperCase() + "! Você foi APROVADO no Curso de Pós-Graduação em " + candidato.getProcessoSeletivo().getCurso() + 
						"\n\n" + "Colocação: " + c+"°" + "\nNúmero de vagas: " + candidato.getProcessoSeletivo().getVagas() + "\nAguarde os próximos contatos para dar início à matrícula");
			} else {
				JOptionPane.showMessageDialog(null, candidato.getNome().toUpperCase() + ", você está em LISTA DE ESPERA" + 
						"\n\n" + "Colocação: " + c+"°" + "\nNúmero de vagas: " + candidato.getProcessoSeletivo().getVagas());
			}
		}
		
		
		
	}

}
