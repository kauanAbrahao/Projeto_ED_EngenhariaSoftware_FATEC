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

public class InscricaoProcessoController {
	
	public void inscreveProcesso(Candidato candidato) throws IOException {
		if(candidato.getStatus().contains("semstatus")) {
			JOptionPane.showMessageDialog(null, "== PROCESSOS ABERTOS == " + "\n" + "1 - " + candidato.getProcessoSeletivo().getCurso());
			
			String lattes = JOptionPane.showInputDialog("Para se cadastrar, você precisa inserir alguns documentos\nInsira o link do seu Curriculo Lattes:");
			String historico = JOptionPane.showInputDialog("Por favor, anexe o seu histórico unviersitário: ");
			
			candidato.setLattes(lattes);
			candidato.setHistorico(historico);
			candidato.setStatus("naoanalisado");
			
			alteraTxtComDadosNovos(candidato);
		
		} else {
			JOptionPane.showMessageDialog(null, "Você já se cadastrou no Processo Seletivo!");
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
			InputStreamReader leitor = new InputStreamReader(fluxo); //lê e converte o arquivo
			BufferedReader buffer = new BufferedReader(leitor); // coloca o arquivo no buffer 
			
			String linha = buffer.readLine();
			while(linha != null) { // procurando EOF (End of File)
				if(linha.contains(candidato.getCpf())) {
					linha = linha.replaceAll("semlattes", candidato.getLattes());
					linha = linha.replaceAll("semhistorico", candidato.getHistorico());
					linha = linha.replaceAll("semstatus", candidato.getStatus());
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