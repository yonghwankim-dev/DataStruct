package sort.selection_sort.implement;



import org.junit.Test;

import java.util.Arrays;



class SelectionSortTest {

	@Test
	void selectionSortTest() {
		int[] arr = {5,3,2,4,1};
		
		System.out.println(Arrays.toString(arr));
		SelectionSort.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
