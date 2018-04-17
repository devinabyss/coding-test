package algorithm.sort.impl;


import algorithm.sort.Sort;

public class InsertionSort extends Sort {

	@Override
	public void sort(int[] array) {

		
		for (int i = 1; i < array.length; i++) {
			
			int min = array[i];
			int pos = i;
			
			for (int j = i ; j > 0; j--) {
				
				if (array[j-1] > min) {
					array[j] = array[j-1];
					pos = j-1;
				} else {
					break;
					
				}
				
			}
			
			array[pos] = min;
		}
		
	}

}
