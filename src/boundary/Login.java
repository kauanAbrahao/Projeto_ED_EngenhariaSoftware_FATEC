package boundary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Login {
	
	public String acessarSistema() throws FileNotFoundException {
		int r = 0;
		String dir = System.getProperty("user.dir");
		Scanner scan = new Scanner(new File(dir + "//Cadastros1.txt"));
		String user_fornecido = JOptionPane.showInputDialog("inserir nome de usuário: ");
		String pass_fornecido = JOptionPane.showInputDialog("Senha:");
		String valCPF = null;
		
		while(scan.hasNext()) {
			String user = scan.nextLine();
			String pass = scan.nextLine();
				
			if(user_fornecido.equals(user) && pass_fornecido.equals(pass)) {
				r = 9;
				
				break;
			}
		}
		if (r == 0) {
			JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
		}
		if (r == 9) {
			JOptionPane.showMessageDialog(null, "Bem-vindo ao SysGETI - Perfil Aluno");
			valCPF = scan.nextLine();
			valCPF = scan.nextLine();
			valCPF = scan.nextLine();
			scan.close();
		}
		
		scan.close();
		return valCPF;
		
	}

}
