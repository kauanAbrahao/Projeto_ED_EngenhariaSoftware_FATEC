package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import entities.Candidato;

public class VerificaProcessoController {
	
	public void verificaProcesso(Candidato candidato) throws FileNotFoundException {
		
		String dir = System.getProperty("user.dir");
		Scanner scan = new Scanner(new File(dir + "//Cadastros1.txt"));
		String verificacao = scan.nextLine();
		
		while(scan.hasNext()) {
			if(verificacao.contains(candidato.getCpf())) {
				for(int i = 0; i <= 6; i ++) {
					verificacao = scan.nextLine();
				}
				
			System.out.println(verificacao);	
			if(verificacao.contentEquals("Sem status")) {
				JOptionPane.showMessageDialog(null, "Sua inscri��o ainda est� sendo processada");
			}
			if(verificacao.contentEquals("Inscri��o aprovada")) {
				JOptionPane.showMessageDialog(null, "Sua inscri��o foi deferida");
			}
			if(verificacao.contentEquals("Inscri��o reprovada")) {
				JOptionPane.showMessageDialog(null, "Sua inscri��o foi indeferida");
			}
			
			break;
							
			}
			
		verificacao = scan.nextLine();
			
		}
	}
}