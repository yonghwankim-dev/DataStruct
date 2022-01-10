package sort.merge_sort.implement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class MergeSortTest {

	@Test
	void test() {
		int[] arr = {32,27,43,3,9,82,10};
		System.out.println(Arrays.toString(arr));
		MergeSort.sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

}
