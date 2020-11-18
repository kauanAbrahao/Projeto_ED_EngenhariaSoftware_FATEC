package boundary;

import java.io.IOException;

import javax.swing.JOptionPane;

import control.InscricaoProcessoController;
import control.VerificaProcessoController;
import entities.Candidato;
import entities.ListaCandidatos;

public class TelaInicialCandidato {
		
	public void telaInicial(String cpfValidador) throws IOException {
		
		//Essas 3 linhas puxam as informações do txt e transformam em um lista. Ademais, puxa o candidato que logou no sistema
		ListaCandidatos lista = new ListaCandidatos();
		lista.buscaCandidatosNoTxt();
		Candidato candidato = lista.buscaCandidatoPorCPF(cpfValidador);
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