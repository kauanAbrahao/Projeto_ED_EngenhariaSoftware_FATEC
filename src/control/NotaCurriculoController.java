package control;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import entities.Candidato;

public class NotaCurriculoController {
	
	public void NotaLattes(Candidato aux) throws IOException {
		//getNotaEntrevista est� retornando a nota do lattes
		
		String N = aux.getNotaLattes();
		if(aux.getNotaLattes().contains("nl-1")) {
			
			String Nlattes = JOptionPane.showInputDialog("Atribua uma nota ao Lattes");
			
			aux.setNotaLattes(Nlattes);
			
			alteraTxtComDadosNovos(aux);
			
			
		
		} else {
			JOptionPane.showMessageDialog(null, "J� foi atribuida nota ao Lattes " + N);
		}
		
		NotaFinalController NotaFinal = new NotaFinalController();
		NotaFinal.NotaFinal(aux);
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
					linha = linha.replaceAll("nl-1", candidato.getNotaLattes());
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