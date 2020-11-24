package control;

import javax.swing.JOptionPane;

import entities.Candidato;

public class VerificaNotaFinalController {
	
	public void verificaNotaProcesso(Candidato candidato) {

		
		if(!candidato.getNotaFinal().contains("nf-1") && candidato.getStatus().contains("deferido") && candidato.getdivulgaNotaFinal().contentEquals("S")){
			JOptionPane.showMessageDialog(null, candidato.getNome().toUpperCase() + "\n" + candidato.getProcessoSeletivo().getCurso().toUpperCase()
					+ "\nNota Lattes: " + candidato.getNotaLattes() + "\nNota Entrevista: " + candidato.getNotaEntrevista() + "\nNOTA FINAL: " + candidato.getNotaFinal());
		} else {
			if(candidato.getStatus().contains("indeferido")) {
				JOptionPane.showMessageDialog(null, "Sua inscrição foi INDEFEREIDA. Não é possível continuar");
			
			} else {
				JOptionPane.showMessageDialog(null, "Sua Nota Final está sendo processada. Por favor, aguarde.");
			}
		}
	}		
}
