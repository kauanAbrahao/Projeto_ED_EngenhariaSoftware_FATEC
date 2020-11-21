package boundary;

import java.io.IOException;
import entities.Candidato;
import javax.swing.JOptionPane;
import boundary.TelaInicialCPS;


public class TelaInicialMain {
	
	public static void main(String[] args) throws Exception {
		int opc = -1;
		
		while (opc!= 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("== Bem vindo ao SysGETI ==" + "\n" + "1 - Plataforma Aluno" + 
					"\n" + "2 - Plataforma CRA" + "\n" + "3 - Plataforma CPS " + "\n" + "\n" + "9 - Finalizar"));
			
			switch(opc) {
			case 1: SignIn signin = new SignIn();
			signin.interfaceLogin();
			break;
			
			case 2:
				TelaInicialCRA cra = new TelaInicialCRA();
				cra.telaInicial();
				break;
				
			case 3: Candidato candidato = new Candidato();
			TelaInicialCPS VerLattes = new TelaInicialCPS();
			candidato = VerLattes.telaInicio(candidato);
			break;
			
			case 9: JOptionPane.showMessageDialog(null, "Finalizado");
			break;
			default: JOptionPane.showMessageDialog(null, "Op��o inv�lida, tente novamente");
			}
			
		}
		
		
		
	}

}
			
			

