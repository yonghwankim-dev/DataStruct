package sort.merge_sort.implement;

public class MergeSort {
	public static void merge(int[] arr, int left, int middle, int right)
	{
		int n1 = middle-left+1;
		int n2= right-middle;
		
		int[] left_arr = new int[n1];
		int[] right_arr = new int[n2];
		
		// n = n1 + n2
		
		// n1번
		for(int i=0; i<n1;i++)
		{
			left_arr[i] = arr[left+i];
		}
		// n2번
		for(int j=0; j<n2; j++)
		{
			right_arr[j] = arr[middle+1+j];
		}
		
		int i=0, j=0;
		
		int k=left;

		// 대소를 비교하여 arr에 정렬된 요소를 저장합니다.
		while(i<n1 && j<n2)
		{
			if(left_arr[i]<=right_arr[j])
			{
				arr[k] = left_arr[i];
				i++;
			}
			else
			{
				arr[k] = right_arr[j];
				j++;
			}
			k++;
		}
		
		// 왼쪽 배열의 남은 요소들을 저장합니다.
		while(i<n1)
		{
			arr[k] = left_arr[i];
			i++;
			k++;
		}
		// 오른쪽 배열의 남은 요소를 저장합니다.
		while(j<n2)
		{
			arr[k] = right_arr[j];
			j++;
			k++;
		}
	}
	
	public static void sort(int[] arr, int left, int right)
	{
		if(left<right)
		{
			int middle = (left + right)/2;
			
			sort(arr, left, middle);
			sort(arr, middle+1, right);
			
			merge(arr, left, middle, right);
		}
		
		
	}
}
