package control;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import entities.Candidato;

public class NotaFinalController {
	
	public void NotaFinal(Candidato aux) throws IOException {
		//getNotaEntrevista est� retornando a nota do lattes
		
		if(aux.getNotaFinal().contains("nf-1") && !aux.getNotaLattes().contains("nl-1") && !aux.getNotaEntrevista().contains("ne-1")) {
			double N1 = Double.parseDouble(aux.getNotaLattes());
			double N2 = Double.parseDouble(aux.getNotaEntrevista());
			double M;
			M = (N1+N2)/2;
			String NFinal = String.valueOf(M);
			
			aux.setNotaFinal(NFinal);
			
			alteraTxtComDadosNovos(aux);
		}
	}
	
	
	
	public void alteraTxtComDadosNovos(Candidato candidato) throws IOException {
		String path = System.getProperty("user.dir");
		String nome = "CadastrosGerais.txt";
		File arq = new File(path, nome);
		String conteudo = readTxt(path, nome, candidato);
		BufferedReader reader = null;
		FileWriter writer = null;
		
		try {
			reader = new BufferedReader(new FileReader(arq));
			writer = new FileWriter(arq);
			writer.write(conteudo);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			reader.close();
			writer.close();
		}
	}



	private String readTxt(String path, String nome, Candidato candidato) throws IOException {
		File arq = new File(path, nome);
		StringBuffer conteudo = new StringBuffer();
		if(arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq); //abre o arquivo
			InputStreamReader leitor = new InputStreamReader(fluxo); //l� e converte o arquivo
			BufferedReader buffer = new BufferedReader(leitor); // coloca o arquivo no buffer 
			
			String linha = buffer.readLine();
			while(linha != null) { // procurando EOF (End of File)
				if(linha.contains(candidato.getCpf())) {
					linha = linha.replaceAll("nf-1", candidato.getNotaFinal());
				}
				conteudo.append(linha + System.lineSeparator());
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} else {
			throw new IOException("Arquivo inv�lido");
		}
		
		return conteudo.toString();
	}
	

}	