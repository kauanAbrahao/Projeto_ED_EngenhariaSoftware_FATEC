package boundary;

import java.io.IOException;

import javax.swing.JOptionPane;

import control.CRAController;

public class TelaInicialCRA {
	
	public boolean telaInicial(boolean divulgacao) throws IOException {
		divulgacao = false;
		int opc = -1;
		CRAController visualiza = new CRAController();
		
		while (opc!= 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("== OP��ES PARA O CRA ==" + "\n" + "1 - Ver lista de candidatos inscritos no Processo Seletivo" + 
					"\n" + "2 - Acessar os Documentos Anexados e Atribuir Status" + "\n" + "\n" + 
					"4 - Divulgar Lista de Classifica��o" + "\n\n" + "9 - Finalizar"));
			
			switch(opc) {
			case 1:
			visualiza.visualizaCandidatos();
			break;
			
			case 2:
			visualiza.visualizaDocumentos();
			break;
		
			case 3: //;
			break;
			
			case 4:
			divulgacao = visualiza.divulgaLista();
			divulgacao = true;
			break;
			
			case 9: JOptionPane.showMessageDialog(null, "Finalizado");
			break;
			default: JOptionPane.showMessageDialog(null, "Op��o inv�lida, tente novamente");
			}
			
		}
		return divulgacao;
	}

}
