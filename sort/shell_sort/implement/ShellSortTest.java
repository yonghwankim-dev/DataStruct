package sort.shell_sort.implement;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ShellSortTest {

	@Test
	void test() {
		int[] arr = {7,10,5,3,6,4,1,8,9,2};
		System.out.println(Arrays.toString(arr));
		ShellSort.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
