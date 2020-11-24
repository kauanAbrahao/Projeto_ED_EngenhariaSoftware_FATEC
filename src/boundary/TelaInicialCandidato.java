package boundary;

import java.io.IOException;

import javax.swing.JOptionPane;

import control.ClassificacaoController;
import control.InscricaoProcessoController;
import control.RetornaAgendaEntrevistaController;
import control.VerificaNotaFinalController;
import control.VerificaProcessoController;
import entities.Candidato;

public class TelaInicialCandidato {
		
	public void telaInicial(Candidato candidato, boolean divulgacao) throws IOException {
		
		RetornaAgendaEntrevistaController mostra= new RetornaAgendaEntrevistaController();
		VerificaNotaFinalController Ver = new VerificaNotaFinalController();
		VerificaProcessoController processo = new VerificaProcessoController();
		InscricaoProcessoController inscreve = new InscricaoProcessoController();
		JOptionPane.showMessageDialog(null, "SEJA BEM-VINDO(A), " + candidato.getNome().toUpperCase() + "!");
		
		int opc = -1;
		
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("== OPÇÕES PARA O CANDIDATO ==" + "\n" + "1 - Inscrição em Processo Seletivo" + "\n" + 
			"2 - Verificar Situação no Processo Seletivo" + "\n"+ "3 - Verificar data entrevista"+ "\n"+ "4 - Verificar Nota Final" + "\n5 - VERIFICAR RESULTADO"+ "\n" + "9 - Retornar"));
			
			switch(opc) {
				case 1: inscreve.inscreveProcesso(candidato);
				break;
					
				case 2: processo.verificaProcesso(candidato);
				break;
				
				case 3: mostra.RetornaAgenda(candidato);
				break;
				
				case 4: Ver.verificaNotaProcesso(candidato);
				break;
				
				case 5:
				if(divulgacao) {
					ClassificacaoController classificacao = new ClassificacaoController();
					classificacao.mostraClassificacao(candidato);
					
				} else {
					JOptionPane.showMessageDialog(null, "Aguarde a divulgação dos resultados");
				}
				break;
				case 9:
				opc = 9;
				break;
			
				default: JOptionPane.showMessageDialog(null, "Opção inserida é inválida");
			}
		}		
	}
}