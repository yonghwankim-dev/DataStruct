package sort.insertion_sort.implment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class InsertionSortTest {

	@Test
	void test1() {
		int[] arr = {5,3,2,1,4};
		
		System.out.println(Arrays.toString(arr));
		InsertionSort.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	@Test
	void test2() {
		int[] arr = {1,2,3,4,5};
		
		System.out.println(Arrays.toString(arr));
		InsertionSort.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
