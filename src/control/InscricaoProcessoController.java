package control;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import entities.Candidato;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import entities.Candidato;

public class InscricaoProcessoController {
	
	public void inscreveProcesso(Candidato candidato) throws IOException {
		JOptionPane.showMessageDialog(null, "Agora, vamos cadastrar suas informações");
		boolean valido = false;
//		String Inscricao = "";
		String Lattes = "";
		String Historico = "";
		
		String dir = System.getProperty("user.dir");
		Scanner scan = new Scanner(new File(dir + "//Cadastros1.txt"));
		String verificacao = scan.nextLine();
		
		while(scan.hasNext()) {
			if(verificacao.contains(candidato.getCpf())) {
				for(int i = 0; i <= 7; i ++) {
					verificacao = scan.nextLine();
				}
				//while(!valido) {
					//Inscricao = JOptionPane.showInputDialog("Inserir nome completo: ");
					//Pattern patern = Pattern.compile("^[a-zA-Z_ ]*$");
					//Matcher match = patern.matcher(Inscricao);
					//valido = confereInformacoes(Inscricao, patern, match);
				//}
				//candidato.setProcessoSeletivo(Inscricao);
				valido = false;
				while(!valido) {
					Lattes = JOptionPane.showInputDialog("Inserir o currículo Lattes ");
					Pattern patern = Pattern.compile("^[a-zA-Z_ ]*$");
					Matcher match = patern.matcher(Lattes);
					valido = confereInformacoes(Lattes, patern, match);
				}
				candidato.setLattes(Lattes);
				
				valido = false;
				while(!valido) {
					Lattes = JOptionPane.showInputDialog("Inserir o Histórico ");
					Pattern patern = Pattern.compile("^[a-zA-Z_ ]*$");
					Matcher match = patern.matcher(Historico);
					valido = confereInformacoes(Historico, patern, match);
				}
				candidato.setHistorico(Historico);
			
			
			break;
							
			}
			
		verificacao = scan.nextLine();
			
		}
		
		BufferedWriter gravar = new BufferedWriter(new FileWriter(dir + "//Cadastros1.txt", true));
		gravar.write(Lattes);
		gravar.write(Historico);
		gravar.close();
		
		
		
	}


	
private boolean confereInformacoes(String lattes, Pattern patern, Matcher match) {
		// TODO Auto-generated method stub
		return false;
	}


}