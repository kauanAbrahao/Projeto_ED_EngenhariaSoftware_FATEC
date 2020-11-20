package entities;

public class QuickSort {
	public Candidato[] quickSort(Candidato[] vet, int l, int r) {
		int p;
		if (l<r) {
			p = particao(vet, l, r);
			quickSort(vet, l, p-1);
			quickSort(vet, p+1, r);
		}
		return vet;
	}
	
	
	
	private int particao(Candidato[] vet, int l, int r) {
		String pivo = vet[r].getNome();
		Candidato aux;
		int i = l-1;
		for (int j = l; j<r; j++) {
			if(vet[j].getNome().compareTo(pivo) > 0) {
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
