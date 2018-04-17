package algorithm.sort.impl;


import algorithm.sort.Sort;

import java.security.SecureRandom;

public class QuickSort extends Sort {

	private final SecureRandom random = new SecureRandom();

	//private static final int PIVOT_CANDIDATE_SIZE = 3;

        
	@Override
	public void sort(int[] array) {

		if (array.length > 1) {
			sort(array, 0, array.length - 1);
		}

	}

	private void sort(int[] array, int low, int high) {

		int pivotPos = low + (high - low) / 2;
		// int pivotPos = decisionPivotPosition(low, high);
		int pivot = array[pivotPos];

		int originLow = low;
		int originHigh = high;

		// logger.debug("PIVOT : {}" , pivot);

		while (low <= high) {

			while (array[low] < pivot) {
				low++;
			}

			while (array[high] > pivot) {
				high--;
			}
			
			//logger.debug("LOW POS : {}, LOW VAL : {}", low, array[low]);
			//logger.debug("HIGH POS : {}, HIGH VAL : {}", high, array[high]);

			if (low <= high) {
				int temp = array[low];
				array[low] = array[high];
				array[high] = temp;
				low++;
				high--;
			}
			
			//logger.debug("PIBOT : {}, SWAP ARRAY : {}\n", pivot, array);
			
		}

		if (originLow < high) {
			sort(array, originLow, high);
		}

		if (originHigh > low) {
			sort(array, low, originHigh);
		}

	}

	private int decisionPivotPosition(int low, int high) {

		int[] candidates = { low, low + (high - low) / 2, high };

		int pos = random.nextInt(3);

		// int posRange = high - low;

		// int[] cadidates = new int[PIVOT_CANDIDATE_SIZE];
		//
		// for (int i = 0; i < PIVOT_CANDIDATE_SIZE; i++) {
		// cadidates[i] = random.nextInt(posRange);
		// }
		//
		// //logger.info("CANDIDATES : {}", cadidates);
		//
		// int winner = random.nextInt(PIVOT_CANDIDATE_SIZE);

		// return cadidates[winner] + low;
		// return random.nextInt(posRange) + low;
		return candidates[pos];
	}

}
