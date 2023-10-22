package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		sort(array, 0, array.length - 1);
		Integer resultado = floor2(array, x, 0, array.length - 1);
		return resultado;
	}

	public Integer floor2(Integer[] array, Integer x, int leftIndex, int rightIndex) {
		Integer resultado = null;

		if (x < array[leftIndex]) {
			return null;
		}
		if (x > array[rightIndex]) {
			return resultado = array[rightIndex];
		}
		if (leftIndex <= rightIndex) {
			int middle = (leftIndex + rightIndex) / 2;
			if (x == array[middle]) {
				resultado = x;
			} else if (x < array[middle + 1]) {
				if (array[middle] < x) {
					resultado = array[middle];
				} else {
					resultado = floor2(array, x, leftIndex, middle - 1);
				}
			} else {
				resultado = floor2(array, x, middle + 1, rightIndex);
			}
		}
		return resultado;
	}

	private Integer ceil(Integer[] array, int leftIndex, int rightIndex, Integer x) {
		Integer resultado = null;

		if (x > array[rightIndex]) {
			return null;
		}
		if (x < array[leftIndex]) {
			return array[leftIndex];
		}
		if (leftIndex <= rightIndex) {
			int middle = (leftIndex + rightIndex) / 2;
			if (x == array[middle]) {
				return resultado = x;
			} else if (x > array[middle - 1]) {
				if (x < array[middle]) {
					return resultado = array[middle];
				}

				else {
					return resultado = ceil(array, middle + 1, rightIndex, x);
				}
			} else {
				return resultado = ceil(array, leftIndex, middle - 1, x);
			}
		}
		return resultado;
	}

	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex >= 0 && leftIndex <= rightIndex && rightIndex < array.length) {
			int index_pivot = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, index_pivot - 1);
			sort(array, index_pivot + 1, rightIndex);
		}
	}

	private int partition(Integer[] array, int leftIndex, int rightIndex) {
		int pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) < 0) {
				i++;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, leftIndex, i);
		return i;
	}

	public static void main(String[] args) {
		Integer[] teste = new Integer[] { -30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
		FloorBinarySearchImpl busca = new FloorBinarySearchImpl();
		System.out.println(busca.floor(teste, 10));
	}
}
