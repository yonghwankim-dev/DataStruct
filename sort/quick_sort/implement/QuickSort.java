package sort.quick_sort.implement;

import java.util.Arrays;

public class QuickSort<E> {
	private static int partition(int[] arr, int left, int right)
	{
		int pivot;
		int low, high;
		
		low = left+1;
		high = right;
		pivot = arr[left];	// 정렬할 리스트의 가장 왼쪽 데이터를 pivot으로 선택 (임으의 값을 pivot으로 선택함)
	
		while(low<high)
		{
			// pivot보다 큰 값을 찾을때까지 low를 증가
			while(low<=right && arr[low]<pivot)
			{
				low++;
			}
			
			// pivot보다 작은 값을 찾을때까지 high를 감소
			while(high>=left && arr[high]>pivot)
			{
				high--;
			}
			
			// 위의 두 low와 high를 이동하였음에도 low가 high보다 작은 경우
			// arr[low]와 arr[high] 값 교환 수행
			if(low<high)
			{
				swap(arr, low, high);
			}
		}
		
		// low가 high와 겹치거나 오른쪽(큰 경우)에 있는 경우
		// arr[left]와 arr[high]를 값 교환
		swap(arr, left, high);
		
		// pivot의 위치인 high를 반환 (high의 위치는 정렬이 완료됨)
		return high;
	}
	
	private static void swap(int[] arr, int low, int high) 
	{
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}

	public static void sort(int[] arr, int left, int right)
	{
		// 정렬할 범위가 2개 이상인 경우
		if(left<right)
		{
			// pivot을 설정하여 정렬할 배열을 분할
			int pivot = partition(arr, left, right);
			
			// pivot은 제외한 2개의 부분 리스트를 대상으로 순환 호출
			sort(arr, left, pivot-1);	// pivot의 왼쪽을 정렬 (정복)
			sort(arr, pivot+1, right);	// pivot의 오른쪽을 정렬 (정복)
		}
	}
	
	public static void main(String[] args)
	{
		int[] arr = {5,1,3,8,9,4,2,7,10,6};
		System.out.println(Arrays.toString(arr));
		sort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
