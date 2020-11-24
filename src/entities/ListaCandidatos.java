package entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import boundary.TelaInicialCPS;

public class ListaCandidatos {
	Candidato inicio;
	Candidato fim;
	Candidato paraRetorno;
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
	
 
	public void inserirInicio(Candidato candidato) {
		
		
		candidato.anterior = null;
		candidato.setProximo(inicio);
		
		if (inicio != null) {
			inicio.setAnterior(candidato);
		}
		inicio = candidato;
		if (isEmpty()) {
			fim = inicio;
		}
		tamanho++;
	}
	
//	--------------------------------------------------------------------
	
	public Candidato removerInicio() {
		if (isEmpty()) {
			return null;
		}
		Candidato aux = inicio;
		inicio = inicio.getProximo();
		if (inicio != null) {
			inicio.setAnterior(null);
		}
		else {
			fim = null;
		}
		tamanho--;
		return aux;
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
//	public String removerFim() {
//		if (isEmpty()) {
//			return "Lista vazia, não há elementos para serem retirados";
//		}
//		else {
//			String out = fim.getNome();
//			fim = fim.getAnterior();
//			if (fim != null) {
//				fim.setProximo(null);
//			}
//			else {
//				inicio = null;
//			}
//			tamanho--;
//			return "removido: " + out; 
//		}
//		
//	}
	
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
	public String mostraLista(String verificacao, int nomeOuNota) {
		String r = "";
		Candidato aux = inicio;
		if (nomeOuNota == 1) {
			if (verificacao.contains("apenas matriculados")) {
				while (aux != null){
					if(!aux.getStatus().contains("semstatus")) {
						r = r + "\n" + "Nome: " + aux.getNome().toUpperCase() + ", CPF: " + aux.getCpf().toUpperCase();
					}
					aux = aux.getProximo();
				}
				return r;
				
			} else {
				while (aux != null){
					r = r + "\n" + "Nome: " + aux.getNome().toUpperCase() + ", CPF: " + aux.getCpf().toUpperCase();
					aux = aux.getProximo();
				}
				return r;
				
			}
		}else {
			if (verificacao.contains("apenas matriculados e deferidos")) {
				while (aux != null){
					if(aux.getStatus().contains("deferido")) {
						r = r + "\n" + "Nome: " + aux.getNome().toUpperCase() + ", NOTA FINAL: " + aux.getNotaFinal();
					}
					aux = aux.getProximo();
				}
				r = r + "\n\n" + "CANDIDATO: Para maiores informações, faça login no Sistema!";
				return r;
				
			} else {
				while (aux != null){
					r = r + "\n" + "Nome: " + aux.getNome().toUpperCase() + ", CPF: " + aux.getCpf().toUpperCase();
					aux = aux.getProximo();
				}
				return r;
				
			}
			
		}
		
	}
	
//	---------------------------------------------------------------------------
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
					parte[8], parte[9], parte[10], parte[11], parte[12]);
			inserirFim(novocandidato);
			linha = buffer.readLine();
		}
		buffer.close();
	}
	
//	---------------------------------------------------------------------
	public void mostraListaOrdanadaPorNome(String verificacao, int cont) {
		
		QuickSort quicksort = new QuickSort();
		//Transforma a lista em vetor para ordenar.
		
		Candidato vet[] = new Candidato[this.tamanho];
		vet = transformaListaEmVetor(vet);
		
		//Chama o QuickSort
		vet = quicksort.quickSort(vet, 0, vet.length-1, 1);
		
		//Transforma o vetor ordenado em Lista Encadeada novamente
		inicio = null;
		fim = null;
		this.tamanho=0;
		Candidato aux;
		
		for (int i = 0; i < vet.length; i++) {
			aux = vet[i];
			inserirFim(aux);
		}
		if (cont < 1) {
		JOptionPane.showMessageDialog(null, mostraLista(verificacao, 1));;
		}
	}
	
//	-----------------------------------------------------------------
	public void mostraListaOrdanadaPorNotaFinal(String verificacao) {
		QuickSort quicksort = new QuickSort();
		//Transforma a lista em vetor para ordenar.
		
		Candidato vet[] = new Candidato[this.tamanho];
		vet = transformaListaEmVetor(vet);
		
		//Chama o QuickSort
		vet = quicksort.quickSort(vet, 0, vet.length-1, 2);
		
		//Transforma o vetor ordenado em Lista Encadeada novamente
		inicio = null;
		fim = null;
		this.tamanho=0;
		Candidato aux;
		
		for (int i = 0; i < vet.length; i++) {
			aux = vet[i];
			inserirFim(aux);
		}
		JOptionPane.showMessageDialog(null, mostraLista(verificacao, 2));;
	}
	
//	-----------------------------------------------------------------
	
	private Candidato[] transformaListaEmVetor(Candidato[] vet) {
		Candidato aux = inicio;
		int i = 0;
		
		while(aux!=null) {
			vet[i] = aux;
			i++;
			aux = aux.getProximo();
		}
		
		return vet;
	}
	
	public Candidato getInicio() {
		return this.inicio;
	}
//	---------------------------------------------------------------------
	//Busca o Cpf do candidato e acessa seu curriculo Lattes
	public Candidato buscaCandidatoPorCPF(String CPF) throws Exception {
		Candidato aux = inicio;
		TelaInicialCPS processo = new TelaInicialCPS();
		while(aux != null) {
			if (
				(aux.getCpf().contains(CPF))) {
				processo.telaInicio(aux);
				return aux;
				
			}
			aux = aux.getProximo();
		}
		return aux;
		
		
		
		
		
	}

}


