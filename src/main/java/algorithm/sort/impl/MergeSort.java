package algorithm.sort.impl;


import algorithm.sort.Sort;

public class MergeSort extends Sort {

	@Override
	public void sort(int[] array) {

		if (array.length > 1) {

			sort(array, 0, array.length - 1);

		}
	}

	private void sort(int[] array, int low, int high) {

		if (low < high) {

			int mid = low + ((high - low) / 2);

			sort(array, low, mid);
			sort(array, mid + 1, high);

			merge(array, low, high, mid);
		}

	}

	private void merge(int[] array, int low, int high, int mid) {

		//logger.debug("Array : {}, EACH SIZE : {}, LOW : {}, HIGH : {}, MID : {}", array, mid - low + 1, low, high, mid);

		int leftSize = mid - low + 1;
		int rightSize = high - mid;

		int newSize = leftSize + rightSize;

		int leftPos = low;
		int rightPos = mid + 1;

		int[] temp = new int[newSize];
		int tempPos = 0;

		//logger.debug("TEMP SIZE : {}, LEFT POS : {}, RIGHT POS : {}", newSize, leftPos, rightPos);

		
		while (tempPos < newSize) {

			if (leftPos <= mid && rightPos <= high) {
				if (array[leftPos] < array[rightPos]) {

					temp[tempPos] = array[leftPos];
					leftPos++;
				} else {
					temp[tempPos] = array[rightPos];
					rightPos++;
				}
			} else if (leftPos <= mid) {
				temp[tempPos] = array[leftPos];
				leftPos++;

			} else {
				temp[tempPos] = array[rightPos];
				rightPos++;
			}

			tempPos++;
		}

		tempPos = 0;

		for (int i = low; i <= high; i++) {
			array[i] = temp[tempPos];
			tempPos++;
		}

	}

}
