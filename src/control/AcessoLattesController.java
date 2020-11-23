package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import entities.Candidato;
import javax.swing.JOptionPane;
import boundary.AcessoLattes;

public class AcessoLattesController {
	
	public void verificaLattes(Candidato aux) throws IOException {
		String dir = System.getProperty("user.dir");
		File arq = new File(dir, "CadastrosGerais.txt");
		FileInputStream fluxo = new FileInputStream(arq); //abre o arquivo
		InputStreamReader leitor = new InputStreamReader(fluxo); //lê e converte o arquivo
		BufferedReader buffer = new BufferedReader(leitor); // coloca o arquivo no buffer 
		String linha = buffer.readLine();
		
		while(linha!=null) {
			if(linha.contains(aux.getCpf())) {
				String[] parte = linha.split("\\,");
				
				if(parte[10].contentEquals("semlattes")) {
					JOptionPane.showMessageDialog(null, "Este Candidato não cadastrou o Lattes");	
				} else {
					JOptionPane.showMessageDialog(null, parte[5]);
				}
			
			
			}
			linha = buffer.readLine();
		}
		buffer.close();
		fluxo.close();
		leitor.close();
	}		
}