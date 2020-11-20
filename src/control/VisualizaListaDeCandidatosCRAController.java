package control;

import java.io.IOException;

import entities.ListaCandidatos;

public class VisualizaListaDeCandidatosCRAController {
	
	public void visualizaCandidatos() throws IOException {
		ListaCandidatos lista = new ListaCandidatos();
		lista.buscaCandidatosPersistidos();
		lista.mostraListaOrdanadaPorNome();
		
		
	}

}
