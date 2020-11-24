package boundary;

import javax.swing.JOptionPane;

import control.AcessoLattesController;
import control.AgendaEntrevistaController;
import control.DefineCandidatoCPS;
import control.NotaCurriculoController;
import control.NotaEntrevistaController;
import control.NotaFinalController;
import control.RetornaNotaFinalController;
import entities.Candidato;




public class TelaInicialCPS {
		
	public Candidato telaInicio(Candidato aux) throws Exception {
		
		
		Candidato candidato = new Candidato();
		
		
		
		int opc = -1;
		int cont = 0;
		while(opc != 9) {
			if (cont != 1 ) {
			JOptionPane.showMessageDialog(null, "Você selecionou o candidato: " + aux.getNome().toUpperCase() + "!");
			cont = cont + 1;
			}
			opc = Integer.parseInt(JOptionPane.showInputDialog("== OPÇÕES PARA O CPS ==" + "\n" + "1 - Ver o curriculo Lattes do candidato" + "\n" + 
			"2 - Atribuir nota ao Lattes" + "\n" + "3 - Agendar entrevista com o candidato" + "\n" +  "4 - Atribuir nota à entrevista" + "\n" +  "5 - Divulgar nota final ao candidato" +  "\n" + "9 - Retornar"));
			
			switch(opc) {
				case 1: AcessoLattesController VerLattes = new AcessoLattesController();
				VerLattes.verificaLattes(aux);
				break;
					
				case 2: NotaCurriculoController NotaLattes = new NotaCurriculoController();
				NotaLattes.NotaLattes(aux);
				break;
				
				case 3: AgendaEntrevistaController AgendaEntrevista = new AgendaEntrevistaController();
				AgendaEntrevista.AgendaEntrevista(aux);
				break;
				
				case 4: NotaEntrevistaController NEntrevista = new NotaEntrevistaController();
				NEntrevista.NotaEntrevista(aux);
				break;
				
				case 5: RetornaNotaFinalController RetornaNotaFinal = new RetornaNotaFinalController();
				RetornaNotaFinal.RetornaNotaFinal(aux);
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