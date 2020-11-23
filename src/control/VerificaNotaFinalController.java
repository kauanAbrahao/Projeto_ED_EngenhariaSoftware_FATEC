package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import entities.Candidato;

public class VerificaNotaFinalController {
	
	public void verificaNotaProcesso(Candidato candidato) throws IOException {
		String dir = System.getProperty("user.dir");
		File arq = new File(dir, "CadastrosGerais.txt");
		FileInputStream fluxo = new FileInputStream(arq); //abre o arquivo
		InputStreamReader leitor = new InputStreamReader(fluxo); //lê e converte o arquivo
		BufferedReader buffer = new BufferedReader(leitor); // coloca o arquivo no buffer 
		String linha = buffer.readLine();
		
		while(linha!=null) {
			if(linha.contains(candidato.getCpf())) {
				String[] parte = linha.split("\\,");
				if(!parte[9].contentEquals("nf-1") && parte[12].contentEquals("S")) {
				JOptionPane.showMessageDialog(null,"Sua nota final é: " + parte[9]);
				} else {
				JOptionPane.showMessageDialog(null,"Sua nota ainda não foi liberada");
			}
			}
			linha = buffer.readLine();
		}
		buffer.close();
		fluxo.close();
		leitor.close();
	}		
}
