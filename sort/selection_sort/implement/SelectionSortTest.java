package sort.selection_sort.implement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SelectionSortTest {

	@Test
	void selectionSortTest() {
		int[] arr = {5,3,2,4,1};
		
		System.out.println(Arrays.toString(arr));
		SelectionSort.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
