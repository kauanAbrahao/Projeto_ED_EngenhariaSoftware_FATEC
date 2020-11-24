package boundary;

import javax.swing.JOptionPane;

import control.DefineCandidatoCPS;
import entities.ListaCandidatos;


public class TelaInicialMain {
	static boolean divulgacao = false;
	
	public static void main(String[] args) throws Exception {
		int opc = -1;
		
		while (opc!= 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("== Bem vindo ao SysGETI ==" + "\n" + "1 - Plataforma Aluno" + 
					"\n" + "2 - Plataforma CRA" + "\n" + "3 - Plataforma CPS " + "\n\n" + "4 - RESULTADO DO PROCESSO"+"\n\n" + "9 - Finalizar"));
			
			switch(opc) {
			case 1: SignIn signin = new SignIn();
			signin.interfaceLogin(divulgacao);
			break;
			
			case 2:
				TelaInicialCRA cra = new TelaInicialCRA();
				divulgacao = cra.telaInicial(divulgacao);
				break;
				
			case 3: 
				DefineCandidatoCPS.visualizaCandidatos();
				break;
				
			case 4:
				if (divulgacao) {
					ListaCandidatos lista = new ListaCandidatos();
					lista.buscaCandidatosPersistidos();
					lista.mostraListaOrdanadaPorNotaFinal("apenas matriculados e deferidos");
				} else {
					JOptionPane.showMessageDialog(null, "RESULTADO AINDA NÃO DIVULGADO - AGUARDE");
				}
				break;
			
			case 9: JOptionPane.showMessageDialog(null, "Finalizado");
			break;
			default: JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente");
			}
			
		}
		
		
		
	}

}
			
			

