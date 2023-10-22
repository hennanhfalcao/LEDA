package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int left = leftIndex;
		int right = rightIndex;
		int position = 0;
		while (left < right) {
			for (position = left; position < right; ++position){
				if (array[position].compareTo(array[position+1])> 0) {
					Util.swap(array, position, position+1);
				}
			}
			right--;
			for  (position = right; position > left; --position){
				if (array[position].compareTo(array[position-1]) < 0){
					Util.swap(array, position, position-1);
				}
			}
			left++;
		}
	}
}
