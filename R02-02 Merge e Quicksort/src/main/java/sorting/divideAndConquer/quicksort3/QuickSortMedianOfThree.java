package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do
 * intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até
 * A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do
 * pivô.

 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex < rightIndex) {
			int index_pivot = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, index_pivot - 1);
			sort(array, index_pivot + 1, rightIndex);
		}
	}

	private int mediana(T[] array, int leftIndex, int rightIndex) {
	
		int center = (leftIndex + rightIndex) / 2;
		
		if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
            Util.swap(array, rightIndex, leftIndex);
        }
        if (array[leftIndex].compareTo(array[center]) > 0) {
            Util.swap(array, center, leftIndex);
        }
        if (array[center].compareTo(array[rightIndex]) > 0) {
            Util.swap(array, rightIndex, center);
        }

        return center;
	}
	
	private int partition(T[] array, int leftIndex, int rightIndex) {
		int pivot_index = mediana(array, leftIndex, rightIndex);
		int i = rightIndex-1;
		Util.swap(array, pivot_index, rightIndex-1);
		for (int j = i-1; j >= leftIndex+1; j--) {
			if (array[j].compareTo(array[rightIndex-1]) >= 0) {
				i--;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, i, rightIndex-1);
		return i;
	}
}