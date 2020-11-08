package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
	public Candidato buscaCandidatoPorCPF(String cpf) {
		Candidato aux = inicio;
		while(aux != null) {
			if (aux.getCpf().contains(cpf)) {
				return aux;
			}
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
	public void buscaCandidatosNoTxt() throws FileNotFoundException {
		String dir = System.getProperty("user.dir");
		Scanner scan = new Scanner(new File(dir + "//Cadastros1.txt"));
		
	while(scan.hasNext()) {
		scan.nextLine();
		scan.nextLine();
		String nome = scan.nextLine();
		String telefone = scan.nextLine();
		String cpf = scan.nextLine();
		String processo = scan.nextLine();
		String lattes = scan.nextLine();
		String historico = scan.nextLine();
		String notaLattes = scan.nextLine();
		String notaEntrevista = scan.nextLine();
		String notaFinal = scan.nextLine();
		String status = scan.nextLine();
		Candidato novocandidato = new Candidato(nome, telefone, cpf, processo, lattes, historico, notaLattes, notaEntrevista, notaFinal, status);
		inserirFim(novocandidato);
		if(scan.hasNext()) {
			scan.nextLine();
			scan.nextLine();
		}
	}
		scan.close();
		
	}

}
