package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de
 * contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de
 * entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a
 * ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros
 * negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex >= 0 && leftIndex <= rightIndex && rightIndex < array.length) {
			int maior = findK(array, leftIndex, rightIndex);
			int menor = menor(array, leftIndex, rightIndex);
			int range = maior - menor +1;
			int[] auxiliar = new int[range];
			Integer[] result = new Integer[rightIndex - leftIndex + 1];

			for (int i = leftIndex; i <= rightIndex; i++) {
				auxiliar[array[i] - menor]++;
			}

			for (int i = 1; i < range; i++) {
				auxiliar[i] += auxiliar[i - 1];
			}
			for (int i = rightIndex; i >= leftIndex; i--) {
				result[auxiliar[array[i] - menor] - 1] = array[i];
				auxiliar[array[i] - menor]--;
			}
			for (int i = 0; i < result.length; i++) {
				array[i] = result[i];
			}
		}
	}

	private int findK(Integer[] array, int leftIndex, int rightIndex) {
		int kindex = leftIndex;
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i].compareTo(array[kindex]) > 0) {
				kindex = i;
			}
		}
		return array[kindex];
	}

	private int menor(Integer[] array, int leftIndex, int rightIndex) {
		int menorindex = leftIndex;
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i].compareTo(array[menorindex]) < 0) {
				menorindex = i;
			}
		}
		return array[menorindex];
	}
}