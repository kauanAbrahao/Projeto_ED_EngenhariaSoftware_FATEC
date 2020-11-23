package control;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import control.NotaFinalController;
import entities.Candidato;

public class NotaEntrevistaController {
	
	public void NotaEntrevista(Candidato aux) throws IOException {
		//getNotaEntrevista está retornando a nota do lattes
		
		String N = aux.getNotaEntrevista();
		if(aux.getNotaEntrevista().contains("ne-1")) {
			
			String NEntrevista = JOptionPane.showInputDialog("Atribua uma nota à entrevista");
			
			aux.setNotaEntrevista(NEntrevista);
			
			alteraTxtComDadosNovos(aux);
			
		
		} else {
			JOptionPane.showMessageDialog(null, "Já foi atribuida nota à entrevista " + N);
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
			InputStreamReader leitor = new InputStreamReader(fluxo); //lê e converte o arquivo
			BufferedReader buffer = new BufferedReader(leitor); // coloca o arquivo no buffer 
			
			String linha = buffer.readLine();
			while(linha != null) { // procurando EOF (End of File)
				if(linha.contains(candidato.getCpf())) {
					linha = linha.replaceAll("ne-1", candidato.getNotaEntrevista());
				}
				conteudo.append(linha + System.lineSeparator());
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} else {
			throw new IOException("Arquivo inválido");
		}
		
		return conteudo.toString();
	}
	

}	