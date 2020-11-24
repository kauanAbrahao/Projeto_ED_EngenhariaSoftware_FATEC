package control;

import javax.swing.JOptionPane;

import boundary.AcessoLattes;
public class DefineCandidatoCPS {
	
	public static void visualizaCandidatos() throws Exception {
		
		JOptionPane.showMessageDialog(null, "Bem vindo ao CPS");
		
		AcessoLattes  VerLattes = new AcessoLattes();
		VerLattes.verificaLattes(null);
		
	}
	
	
}