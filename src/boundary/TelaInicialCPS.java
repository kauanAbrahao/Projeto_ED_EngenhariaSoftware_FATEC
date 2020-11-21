package boundary;

import java.io.IOException;

import javax.swing.JOptionPane;

import control.InscricaoProcessoController;
import control.VerificaProcessoController;
import entities.Candidato;
import entities.ListaCandidatos;
import control.AcessoLattesController;
import boundary.AcessoLattes;
import boundary.NotaCurriculo;




public class TelaInicialCPS {
		
	public Candidato telaInicio(Candidato candidato) throws Exception {
		
		
		NotaEntrevista NEntrevista = new NotaEntrevista();
		
		AcessoLattes  VerLattes = new AcessoLattes();
		
		NotaCurriculo NCurriculo = new NotaCurriculo();
		
		AgendaEntrevista AgendaEntrevista = new AgendaEntrevista();
		
		NotaFinal NotaFinal = new NotaFinal();
		
		RetornaNotaFinal RetornaNotaFinal = new RetornaNotaFinal();
		
		int opc = -1;
		
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("== OPÇÕES PARA O CPS ==" + "\n" + "1 - Ver Lattes" + "\n" + 
			"2 - Atribuir nota ao Lattes" + "\n" + "3 - Agendar entrevista" + "\n" +  "4 - Atribuir nota à entrevista" + "\n" + "5 - Atribuir nota final" + "\n" +  "6 - Retornar nota final" + "\n" + "9 - Retornar"));
			
			switch(opc) {
				case 1: VerLattes.verificaLattes(candidato);
				break;
					
				case 2: ((NotaCurriculo) NCurriculo).NCurriculo(candidato);
				break;
				
				case 3: ((AgendaEntrevista) AgendaEntrevista).AgendaEntrevista(candidato);
				break;
				
				case 4: ((NotaEntrevista) NEntrevista).NEntrevista(candidato);
				break;
				
				case 5: ((NotaFinal) NotaFinal).NotaFinal(candidato);
				break;
				
				case 6:  RetornaNotaFinal.RetornaNotaFinal(candidato);
				break;
				
				case 9:
					opc = 9;
				break;
			
				default: JOptionPane.showMessageDialog(null, "Opção inserida é inválida");
			}
		}
		return candidato;		
	}
}