package boundary;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import entities.Candidato;
import entities.ListaCandidatos;

public class TelaInicialCandidato {
	
	
	
	public void telaInicial(String cpfValidador) throws FileNotFoundException {
		
		//Essas 3 linhas puxam as informa��es do txt e transformam em um lista. Ademais, puxa o candidato que logou no sistema
		ListaCandidatos lista = new ListaCandidatos();
		lista.buscaCandidatosNoTxt();
		Candidato candidato = lista.buscaCandidatoPorCPF(cpfValidador);
		
		int opc = -1;
		
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("== OP��ES PARA O CANDIDATO ==" + "\n" + "1 - Inscri��o em Processo Seletivo" + "\n" + 
			"2 - Verificar Situa��o no Processo Seletivo" + "\n" + "9 - Voltar"));
			
//			switch(opc) {
//				case1: // 
//				case2: //
//			}
		}		
		
			
		
		
	}

}
