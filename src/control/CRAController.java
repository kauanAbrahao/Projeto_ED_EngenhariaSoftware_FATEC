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
import entities.ListaCandidatos;

public class CRAController {
	int cont = 0;
	public void visualizaCandidatos() throws IOException {
		ListaCandidatos lista = new ListaCandidatos();
		lista.buscaCandidatosPersistidos();
		lista.mostraListaOrdanadaPorNome("apenas matriculados", cont);
		
		
	}
	
	
	public void visualizaDocumentos() throws IOException {
		ListaCandidatos lista = new ListaCandidatos();
		lista.buscaCandidatosPersistidos();
		
		Candidato candidato = lista.getInicio();
			
		while(candidato != null) {
			if(candidato.getStatus().contains("naoanalisado") && !candidato.getStatus().contains("semstatus")) {	
				int opc = Integer.parseInt(JOptionPane.showInputDialog("Candidato: " + candidato.getNome().toUpperCase() + "\nInscrição: " + candidato.getStatus().toUpperCase()
						+ "\nLink para o Lattes: " + candidato.getLattes() + "\n" + "Histórico em anexo: " + candidato.getHistorico() +
						"\n\n" + "Você deseja atribuir um status à inscrição do candidato agora?" + "\n" + "1- Sim" + "\n" + "2 - Não"));
				
				
				switch(opc) {
				
				case 1:
				if(!candidato.getStatus().contains("naoanalisado")) {
					JOptionPane.showMessageDialog(null, "O candidato já possui uma atribuição de status da inscrição");
					break;
				} else {
					atribuiStatus(candidato);
					alteraTxtComDadosNovos(candidato);
				}
				
				
				
				case 2:
				break;
					
				default: JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente");
				break;
				
				}
			} else {
					JOptionPane.showMessageDialog(null, "Candidato " + candidato.getNome().toUpperCase() + " já foi avaliado");
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
			InputStreamReader leitor = new InputStreamReader(fluxo); //lê e converte o arquivo
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
			throw new IOException("Arquivo inválido");
		}
		
		return conteudo.toString();
	}


	public boolean divulgaLista() throws IOException {
		ListaCandidatos lista = new ListaCandidatos();
		lista.buscaCandidatosPersistidos();
		
		Candidato aux = lista.getInicio();
		while(aux!=null) {
			if(aux.getStatus().contains("semstatus") || aux.getStatus().contains("indeferido")) {
				aux = aux.getProximo();
			} 
			else {
				if(aux.getNotaFinal().contains("nf-1")) {
					JOptionPane.showMessageDialog(null, "ATENÇÃO! Todos os Candidatos participantes do Processo Seletivo necessitam"
							+ " do campo Nota Final atribuído antes da divulgação.");
					return false;
				}
			}
			aux = aux.getProximo();
		}
		JOptionPane.showMessageDialog(null, "== LISTA DE CLASSIFICAÇÃO DIVULGADA ==");
		return true;
	}

}
