package boundary;

import java.io.IOException;

import javax.swing.JOptionPane;

import control.InscricaoProcessoController;
import control.VerificaProcessoController;
import entities.Candidato;
import entities.ListaCandidatos;

public class TelaInicialCandidato {
		
	public void telaInicial(String cpfValidador) throws IOException {
		
		//Essas 3 linhas puxam as informa��es do txt e transformam em um lista. Ademais, puxa o candidato que logou no sistema
		ListaCandidatos lista = new ListaCandidatos();
		lista.buscaCandidatosNoTxt();
		Candidato candidato = lista.buscaCandidatoPorCPF(cpfValidador);
		VerificaProcessoController processo = new VerificaProcessoController();
		InscricaoProcessoController inscreve = new InscricaoProcessoController();
		
		int opc = -1;
		
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("== OP��ES PARA O CANDIDATO ==" + "\n" + "1 - Inscri��o em Processo Seletivo" + "\n" + 
			"2 - Verificar Situa��o no Processo Seletivo" + "\n" + "9 - Retornar"));
			
			switch(opc) {
				case 1: inscreve.inscreveProcesso(candidato);
				break;
					
				case 2: processo.verificaProcesso(candidato);
				break;
				
				case 9:
					opc = 9;
				break;
			
				default: JOptionPane.showMessageDialog(null, "Op��o inserida � inv�lida");
			}
		}		
	}
}