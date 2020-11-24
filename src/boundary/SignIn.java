package boundary;

import java.io.IOException;

import javax.swing.JOptionPane;

import entities.Candidato;

public class SignIn {
	public void interfaceLogin(boolean divulgacao) throws IOException {
	JOptionPane.showMessageDialog(null, "== Você está no SysGETI - Perfil Aluno ==");
	int opc_login = -1;
	
			
	while(opc_login != 9) {
		opc_login = Integer.parseInt(JOptionPane.showInputDialog("1 - Fazer login" + "\n" + "\n" + "2 - Não sou cadastrado" + "\n" + 
	"3 - Voltar"));
		
		switch(opc_login) {
		case 1:
		Candidato candidato = new Candidato();
		Login login = new Login();
		candidato = login.acessarSistema(candidato);
		
		if(candidato != null) {
			TelaInicialCandidato tela = new TelaInicialCandidato();
			tela.telaInicial(candidato, divulgacao);
			opc_login = 9;
		}
		
		break;
		
		case 2:
		Cadastro cadastro = new Cadastro();
		cadastro.cadastrarCandidato();
		break;
		
		case 3:
		opc_login = 9;
		break;
		
		default: JOptionPane.showMessageDialog(null, "Opção Inválida");
		
		
		}
	}		
	
	
		
	
	
}

}
