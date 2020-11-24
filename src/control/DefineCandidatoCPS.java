package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import boundary.AcessoLattes;
import entities.Candidato;
import entities.ListaCandidatos;

public class DefineCandidatoCPS {
	
	public static void visualizaCandidatos() throws Exception {
		ListaCandidatos lista = new ListaCandidatos();
		lista.buscaCandidatosPersistidos();
		
		JOptionPane.showMessageDialog(null, "Bem vindo ao CPS");
		
		AcessoLattes  VerLattes = new AcessoLattes();
		lista.mostraListaOrdanadaPorNome("apenas matriculados");
		VerLattes.verificaLattes(null);
		
	}
	
	
	public void visualizaDocumentos() throws IOException {
		ListaCandidatos lista = new ListaCandidatos();
		lista.buscaCandidatosPersistidos();
		
		Candidato candidato = lista.getInicio();
			
		while(candidato != null) {
			if(candidato.getStatus().contains("naoanalisado") && !candidato.getStatus().contains("semstatus")) {	
				int opc = Integer.parseInt(JOptionPane.showInputDialog("Candidato: " + candidato.getNome().toUpperCase() + "\nInscri��o: " + candidato.getStatus().toUpperCase()
						+ "\nLink para o Lattes: " + candidato.getLattes() + "\n" + "Hist�rico em anexo: " + candidato.getHistorico() +
						"\n\n" + "Voc� deseja atribuir um status � inscri��o do candidato agora?" + "\n" + "1- Sim" + "\n" + "2 - N�o"));
				
				
				switch(opc) {
				
				case 1:
				if(!candidato.getStatus().contains("naoanalisado")) {
					JOptionPane.showMessageDialog(null, "O candidato j� possui uma atribui��o de status da inscri��o");
					break;
				} else {
					atribuiStatus(candidato);
					alteraTxtComDadosNovos(candidato);
				}
				
				
				
				case 2:
				break;
					
				default: JOptionPane.showMessageDialog(null, "Op��o inv�lida, tente novamente");
				break;
				
				}
			} else {
					JOptionPane.showMessageDialog(null, "Candidato " + candidato.getNome().toUpperCase() + " j� foi avaliado");
			}
			candidato = candidato.getProximo();
		}
		
	}

	private static void atribuiStatus(Candidato candidato) {
		int status;
		
		status = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Deferido\n2 - Indeferido"));
		if(status == 1) {
			candidato.setStatus("deferido");
		}
		if(status == 2) {
			candidato.setStatus("indeferido");
		}
	}
	
	public void alteraTxtComDadosNovos(Candidato candidato) throws IOException {
		String path = System.getProperty("user.dir");
		String nome = "CadastrosGerais.txt";
		File arq = new File(path, nome);
		String conteudoAntigo = readTxt(path, nome);
		BufferedReader reader = null;
		FileWriter writer = null;
		StringBuffer buffer = new StringBuffer();
		
		try {
			reader = new BufferedReader(new FileReader(arq));
			String linha = reader.readLine();
			while(linha!=null) {
				buffer.append(conteudoAntigo + linha + System.lineSeparator());
				linha = reader.readLine();
			}
			
			String conteudonovo = conteudoAntigo.replaceAll("naoanalisado", candidato.getStatus());
			writer = new FileWriter(arq);
			writer.write(conteudonovo);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			reader.close();
			writer.close();
		}
	}



	private String readTxt(String path, String nome) throws IOException {
		File arq = new File(path, nome);
		StringBuffer conteudo = new StringBuffer();
		if(arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq); //abre o arquivo
			InputStreamReader leitor = new InputStreamReader(fluxo); //l� e converte o arquivo
			BufferedReader buffer = new BufferedReader(leitor); // coloca o arquivo no buffer 
			
			String linha = buffer.readLine();
			while(linha != null) { // procurando EOF (End of File)
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
