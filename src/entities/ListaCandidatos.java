package entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListaCandidatos {
	Candidato inicio;
	Candidato fim;
	int tamanho;
	
	public boolean isEmpty() {
		if (tamanho == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
//	----------------------------------------------------------------------
	
 
	public void inserirInicio(String nome, String telefone, String cpf) {
		Candidato novocandidato = new Candidato();
		
		novocandidato.setNome(nome);
		
		novocandidato.anterior = null;
		novocandidato.setProximo(inicio);
		
		if (inicio != null) {
			inicio.setAnterior(novocandidato);
		}
		inicio = novocandidato;
		if (isEmpty()) {
			fim = inicio;
		}
		tamanho++;
	}
	
//	--------------------------------------------------------------------
	
	public String removerInicio() {
		if (isEmpty()) {
			return "Lista vazia, não há elementos para serem retirados";
		}
		String out = inicio.getNome();
		inicio = inicio.getProximo();
		if (inicio != null) {
			inicio.setAnterior(null);
		}
		else {
			fim = null;
		}
		tamanho--;
		return "removido: " + out;
	}
//	---------------------------------------------------------------------
	
	public void inserirFim(Candidato novocandidato) {
		
		
		novocandidato.setProximo(null);
		novocandidato.setAnterior(fim);
		
		if (fim != null) {
			fim.setProximo(novocandidato);
		}
		fim = novocandidato;
		if (isEmpty()) {
			inicio = fim;
		}
		tamanho++;
		
	}
	
//	----------------------------------------------------------------------
	public String removerFim() {
		if (isEmpty()) {
			return "Lista vazia, não há elementos para serem retirados";
		}
		else {
			String out = fim.getNome();
			fim = fim.getAnterior();
			if (fim != null) {
				fim.setProximo(null);
			}
			else {
				inicio = null;
			}
			tamanho--;
			return "removido: " + out; 
		}
		
	}
	
//	-------------------------------------------------------------------
//	public void inserirPosicao(String nome, String curso, int id, int pos) { //BUGADO - POINTERS NÃO ESTÃO CERTOS!!! ~ Arrumado
//		if (pos <= 0) {
//			inserirInicio(nome, curso, id);
//		} else if (pos >= tamanho) {
//			inserirFim(nome, curso, id);
//		} else {
//			Candidato aux = inicio;
//			for(int i = 0; i < pos-1; i++) {
//				aux = aux.getProximo();
//			}
//			Candidato novoaluno = new Candidato();
//			
////			Atribuição de nome, curso e id ao aluno
//			novoaluno.setNome(nome);
//			
//			novoaluno.setAnterior(aux);
//			novoaluno.setProximo(aux.getProximo());
//			aux.proximo = novoaluno;
//			novoaluno.proximo.anterior = novoaluno;
//			tamanho++;
//		}
//	}
	
//	----------------------------------------------------------
	public Candidato buscaCandidatoPorLoginSenha(String usuario, String senha) {
		Candidato aux = inicio;
		while(aux != null) {
			if (
				(aux.getLogin().contains(usuario)) 
				&& 
				(aux.getSenha().contains(senha))) {
				return aux;
			}
			aux = aux.getProximo();
		}
		return null;
		
	}
		
	
//	-----------------------------------------------------------
	public String mostraLista() {
		String r = "";
		Candidato aux = inicio;
		while (aux != null){
			r = r + "\n" + "Nome: " + aux.getNome();
			aux = aux.getProximo();
		}
		return r;
	}
	
//	-----------------------------------------------------------------------------
	public void buscaCandidatosPersistidos() throws IOException {
		
		String path = System.getProperty("user.dir");
		String nome = "CadastrosGerais.txt";
		
		File arq = new File(path, nome);
		FileInputStream fluxo = new FileInputStream(arq);
		InputStreamReader reader = new InputStreamReader(fluxo);
		BufferedReader buffer = new BufferedReader(reader);
		String linha = buffer.readLine();
		
		while(linha!=null) {
			String[] parte = linha.split("\\,");
			Candidato novocandidato = new Candidato(parte[0], parte[1], parte[2], parte[3], parte[4], parte[5], parte[6], parte[7],
					parte[8], parte[9], parte[10], parte[11]);
			inserirFim(novocandidato);
			linha = buffer.readLine();
		}
		buffer.close();
	}
	
//	---------------------------------------------------------------------

}
