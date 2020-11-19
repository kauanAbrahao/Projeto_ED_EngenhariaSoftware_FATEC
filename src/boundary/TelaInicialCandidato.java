package boundary;

import java.io.IOException;

import javax.swing.JOptionPane;

import control.InscricaoProcessoController;
import control.VerificaProcessoController;
import entities.Candidato;
import entities.ListaCandidatos;

public class TelaInicialCandidato {
		
	public void telaInicial(Candidato candidato) throws IOException {
		
		
		VerificaProcessoController processo = new VerificaProcessoController();
		InscricaoProcessoController inscreve = new InscricaoProcessoController();
		
		int opc = -1;
		
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("== OPÇÕES PARA O CANDIDATO ==" + "\n" + "1 - Inscrição em Processo Seletivo" + "\n" + 
			"2 - Verificar Situação no Processo Seletivo" + "\n" + "9 - Retornar"));
			
			switch(opc) {
				case 1: inscreve.inscreveProcesso(candidato);
				break;
					
				case 2: processo.verificaProcesso(candidato);
				break;
				
				case 9:
					opc = 9;
				break;
			
				default: JOptionPane.showMessageDialog(null, "Opção inserida é inválida");
			}
		}		
	}
}