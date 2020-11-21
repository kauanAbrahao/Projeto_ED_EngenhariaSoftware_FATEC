package boundary;

import java.io.IOException;

import javax.swing.JOptionPane;

import control.CRAController;

public class TelaInicialCRA {
	
	public void telaInicial() throws IOException {
		int opc = -1;
		CRAController visualiza = new CRAController();
		
		while (opc!= 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("== OPÇÕES PARA O CRA ==" + "\n" + "1 - Ver lista de candidatos inscritos no Processo Seletivo" + 
					"\n" + "2 - Acessar os Documentos Anexados e Atribuir Status" + "\n" + "3 - Retornar Status da Inscrição aos Candidatos " + "\n" + "\n" + "9 - Finalizar"));
			
			switch(opc) {
			case 1:
			visualiza.visualizaCandidatos();
			break;
			
			case 2:
			visualiza.visualizaDocumentos();	
		
			case 3: //;
			case 9: JOptionPane.showMessageDialog(null, "Finalizado");
			break;
			default: JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente");
			}
			
		}
	}

}
