package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import entities.Candidato;

public class VerificaProcessoController {
	
	public void verificaProcesso(Candidato candidato) throws IOException {
		String dir = System.getProperty("user.dir");
		File arq = new File(dir, "CadastrosGerais.txt");
		FileInputStream fluxo = new FileInputStream(arq); //abre o arquivo
		InputStreamReader leitor = new InputStreamReader(fluxo); //l� e converte o arquivo
		BufferedReader buffer = new BufferedReader(leitor); // coloca o arquivo no buffer 
		String linha = buffer.readLine();
		
		while(linha!=null) {
			if(linha.contains(candidato.getCpf())) {
				String[] parte = linha.split("\\,");
				
				if(parte[10].contentEquals("semstatus")) {
					JOptionPane.showMessageDialog(null, "ATEN��O! Voc� ainda n�o est� matriculado em nenhum Processo Seletivo!");
				}
				if(parte[10].contentEquals("deferido")) {
					JOptionPane.showMessageDialog(null, "Sua inscri��o foi deferida");
				}
				if(parte[10].contentEquals("indeferido")) {
					JOptionPane.showMessageDialog(null, "Sua inscri��o foi indeferida");
				}
				if(parte[10].contentEquals("naoanalisado")) {
					JOptionPane.showMessageDialog(null, "Sua inscri��o ainda est� sendo processada");
				}
			
			
			}
			linha = buffer.readLine();
		}
		buffer.close();
		fluxo.close();
		leitor.close();
	}		
}
