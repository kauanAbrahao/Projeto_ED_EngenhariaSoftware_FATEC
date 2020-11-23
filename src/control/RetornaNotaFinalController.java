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

public class RetornaNotaFinalController {
	
	public void RetornaNotaFinal(Candidato aux) throws IOException {
		//getNotaEntrevista está retornando a nota do lattes
		
		String N = aux.getdivulgaNotaFinal();
		if(aux.getdivulgaNotaFinal().contains("N")) {
		
			int opc = -1;
			while (opc!= 2) {
				opc = Integer.parseInt(JOptionPane.showInputDialog("DESEJA LIBERAR A NOTA AO CANDIDATO?" + "\n" + "1 - Sim" + "\n" + "2 - Não"));
			
				switch(opc) {
				case 1:	String RetornaNotaFinal = ("S");
					aux.setdivulgaNotaFinal(RetornaNotaFinal);
					alteraTxtComDadosNovos(aux);
					opc = 2;
					break;
				case 2: ;
				break;
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "A nota final já foi divulgada ");
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
					linha = linha.replaceAll("N", candidato.getdivulgaNotaFinal());
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