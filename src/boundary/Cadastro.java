package boundary;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import entities.Candidato;

public class Cadastro {
	
	public void cadastrarCandidato() throws IOException {
		Candidato candidato = new Candidato();
		String pass_cadastra = null;
		String user_cadastra = JOptionPane.showInputDialog("Escolha um nome de usuário: ");
		boolean sucesso = false;
		
		while(!sucesso) { //Toda a lógica para cadastrar usuário e senha está dentro deste while
			sucesso = cadastraUsuarioSenha(user_cadastra, pass_cadastra);
		}
		cadastraDados(candidato);
		
				
	}
	
//	--------------------------------------------------------------------------------------------------------
	private boolean cadastraUsuarioSenha(String user_cadastra, String pass_cadastra) throws IOException {
		
		//Cadastra usuário e senha
		pass_cadastra = JOptionPane.showInputDialog("Escolha uma senha: ");
		String confere = JOptionPane.showInputDialog("Confirme a senha: ");
		if (!pass_cadastra.equals(confere)) {
			JOptionPane.showMessageDialog(null, "As senhas estão diferentes. Tente novamente.");
			return false;
		}
		else {
			JOptionPane.showMessageDialog(null, "Login e senha cadastrados com sucesso");
			
		//Grava usuário e senha no arquivo txt
		String dir = System.getProperty("user.dir");
		BufferedWriter gravar = new BufferedWriter(new FileWriter(dir + "//Cadastros1.txt", true));
		gravaCadastroSenhaUsuario(dir, gravar, user_cadastra, pass_cadastra);
		return true;
		}
		
	}
//	-------------------------------------------------------------------------------------------------------
	private void cadastraDados(Candidato candidato) throws IOException {
		
		JOptionPane.showMessageDialog(null, "Agora, vamos cadastrar seus dados!");
		boolean valido = false;
		String nome = "";
		String telefone = "";
		String cpf = "";
		
		//Cadastrar nome
		while(!valido) {
			nome = JOptionPane.showInputDialog("Inserir nome completo: ");
			Pattern patern = Pattern.compile("^[a-zA-Z_ ]*$");
			Matcher match = patern.matcher(nome);
			valido = confereInformacoes(nome, patern, match);
		}
		candidato.setNome(nome);
		
		//Cadastrar telefone
		valido = false;
		while(!valido) {
			telefone = JOptionPane.showInputDialog("Inserir telefone (somente números): ");
			Pattern patern = Pattern.compile("^[0-9]*$");
			Matcher match = patern.matcher(telefone);
			valido = confereInformacoes(telefone, patern, match);
		}
		candidato.setTelefone(telefone);
		
		//Cadastra cpf
		valido = false;
		while(!valido) {
			cpf = JOptionPane.showInputDialog("Inserir CPF (somente números): ");
			Pattern patern = Pattern.compile("^[0-9]{11}$");
			Matcher match = patern.matcher(cpf);
			valido = confereInformacoes(cpf, patern, match);
			
		}
		candidato.setCpf(cpf);

		//Grava usuário e senha no arquivo txt
		String dir = System.getProperty("user.dir");
		BufferedWriter gravar = new BufferedWriter(new FileWriter(dir + "//Cadastros1.txt", true));
		gravaCadastroNomeTelefoneCpf(dir, gravar, nome, telefone, cpf);
		
	}
	
//		---------------------------------------------------------------------------------------------------------
	public boolean confereInformacoes(String validacao, Pattern patern, Matcher match) {
		if (match.find()) {
			JOptionPane.showMessageDialog(null, "Informação cadastrada!");
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Informações inseridas inválidas. Por favor, tente novamente");
			return false;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------------
		public void gravaCadastroSenhaUsuario(String dir, BufferedWriter gravar, String user_cadastra, String pass_cadastra) throws IOException {
			gravar.write(user_cadastra);
			gravar.newLine();
			gravar.write(pass_cadastra);
			gravar.newLine();
			gravar.close();
		}
		//		---------------------------------------------------------------------------------------------------------
		public void gravaCadastroNomeTelefoneCpf(String dir, BufferedWriter gravar, String nome, String telefone, String cpf) throws IOException {
			gravar.write(nome);
			gravar.newLine();
			gravar.write(telefone);
			gravar.newLine();
			gravar.write(cpf);
			gravar.newLine();
			gravar.write("Sem inscricoes"); 
			gravar.newLine();
			gravar.write("semlattes");
			gravar.newLine();
			gravar.write("semhistorico");
			gravar.newLine();
			gravar.write("-1");
			gravar.newLine();
			gravar.write("-1");
			gravar.newLine();
			gravar.write("-1");
			gravar.newLine();
			gravar.write("Sem status");
			gravar.newLine();
			gravar.newLine();
			gravar.close();
		}
//		-----------------------------------------------------------------------------------------------------------------
	

}
