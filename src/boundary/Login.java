package boundary;

import java.io.IOException;

import javax.swing.JOptionPane;

import entities.Candidato;
import entities.ListaCandidatos;

public class Login {
	
	public Candidato acessarSistema(Candidato candidato) throws IOException {
		ListaCandidatos lista = new ListaCandidatos();
		lista.buscaCandidatosPersistidos();
		
		
		String user_fornecido = JOptionPane.showInputDialog("inserir nome de usuário: ");
		String pass_fornecido = JOptionPane.showInputDialog("Senha:");
		
		
		
		
		candidato = lista.buscaCandidatoPorLoginSenha(user_fornecido, pass_fornecido);
		if (candidato!=null) {
			JOptionPane.showMessageDialog(null, "Bem-vindo ao SysGETI - Perfil Aluno");
			return candidato;
			
		} else {
			JOptionPane.showMessageDialog(null, "Usuário ou senha inválido");
			return null;
		}
	}

}
