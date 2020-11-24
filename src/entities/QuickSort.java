package entities;

public class QuickSort {
	
	public Candidato[] quickSort(Candidato[] vet, int l, int r, int decisao) {
		if (decisao == 1) {
			quickSortPorNome(vet, l, r);
			return vet;
		}
		if (decisao == 2) {
			quickSortPorNotaFinal(vet, l, r);
			return vet;
		}
		return null;
	}
	
//	ORDENAÇÃO POR NOME
//	---------------------------------------------------------------------------
	private Candidato[] quickSortPorNome(Candidato[] vet, int l, int r) {
		int p;
		if (l<r) {
			p = particaoPorNome(vet, l, r);
			quickSortPorNome(vet, l, p-1);
			quickSortPorNome(vet, p+1, r);
		}
		return vet;
	}
	
	
	
	private int particaoPorNome(Candidato[] vet, int l, int r) {
		String pivo = vet[r].getNome();
		Candidato aux;
		int i = l-1;
		for (int j = l; j<r; j++) {
			if(vet[j].getNome().toUpperCase().compareTo(pivo.toUpperCase()) < 0) {
				i++;
				aux = vet[j];
				vet[j] = vet[i];
				vet[i]=aux;
			}
		}
		aux = vet[i+1];
		vet[i+1] = vet[r];
		vet[r] = aux;	
		
		return i+1;
	}
	
	
//	ORDENAÇÃO POR NOTA FINAL
//	------------------------------------------------------------------------------------------
	private Candidato[] quickSortPorNotaFinal(Candidato[] vet, int l, int r) {
		int p;
		if (l<r) {
			p = particaoPorNotaFinal(vet, l, r);
			quickSortPorNotaFinal(vet, l, p-1);
			quickSortPorNotaFinal(vet, p+1, r);
		}
		return vet;
	}
	
	
	
	private int particaoPorNotaFinal(Candidato[] vet, int l, int r) {
		double pivo = Double.parseDouble(vet[r].getNotaFinal());
		Candidato aux;
		int i = l-1;
		for (int j = l; j<r; j++) {
			double vetj = Double.parseDouble(vet[j].getNotaFinal());
			if(vetj > pivo) {
				i++;
				aux = vet[j];
				vet[j] = vet[i];
				vet[i]=aux;
			}
		}
		aux = vet[i+1];
		vet[i+1] = vet[r];
		vet[r] = aux;	
		
		return i+1;
	}

}
