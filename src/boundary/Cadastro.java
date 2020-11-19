package boundary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import entities.Candidato;

public class Cadastro {
	Candidato candidato = new Candidato();
	
	public void cadastrarCandidato() throws IOException {
		String pass_cadastra = null;
		String user_cadastra = JOptionPane.showInputDialog("Escolha um nome de usuário: ");
		boolean sucesso = false;
		
		while(!sucesso) { //Toda a lógica para cadastrar usuário e senha está dentro deste while
			sucesso = cadastraUsuarioSenha(user_cadastra, pass_cadastra);
		}
		cadastraDados();
		persisteDados();			
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
			candidato.setLogin(user_cadastra);
			candidato.setSenha(pass_cadastra);
			
		return true;
		}
		
	}
//	-------------------------------------------------------------------------------------------------------
	private void cadastraDados() throws IOException {
		
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
		
	}
	
//		---------------------------------------------------------------------------------------------------------
	public boolean confereInformacoes(String validacao, Pattern patern, Matcher match) {
		if (match.find()) {
			JOptionPane.showMessageDialog(null, "Informação cadastrada!");
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Informações inseridas inválidas. Verifique se os dados foram inseridos corretamente. "
					+ "Por favor, tente novamente");
			return false;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------------
	public void persisteDados() throws IOException	{
		String path = System.getProperty("user.dir");
		String nome = "CadastrosGerais.txt";
		
		File dir = new File(path);
		File arq = new File(path, nome);
		if(dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if(arq.exists()) {
				existe = true;
			}
			
			String conteudo = geraEscrita();
			FileWriter writer = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(writer);
			print.write(conteudo);
			print.flush();
			print.close();
			writer.close();
			
		} else {
			throw new IOException("Diretório inválido");
		}
		
	}

	private String geraEscrita() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(candidato.getLogin() + "," + candidato.getSenha() + "," + candidato.getNome() + "," + candidato.getCpf()
		+ "," + candidato.getTelefone() + "," + candidato.getLattes() + "," + candidato.getHistorico() + "," + candidato.getNotaLattes()
		+ "," + candidato.getNotaEntrevista() + "," + candidato.getNotaFinal() + "," + candidato.getStatus() + "," + 
		candidato.getDataEntrevista() + "\n");
		
		return buffer.toString();
	}

}
