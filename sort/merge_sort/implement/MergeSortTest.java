package sort.merge_sort.implement;



import org.junit.Test;

import java.util.Arrays;



class MergeSortTest {

	@Test
	void test() {
		int[] arr = {8,7,6,5,4,3,2,1};
		System.out.println(Arrays.toString(arr));
		MergeSort.sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

}
