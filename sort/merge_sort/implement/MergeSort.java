package sort.merge_sort.implement;

public class MergeSort {
	public static void merge(int[] arr, int left, int middle, int right)
	{
		int n1 = middle-left+1;
		int n2= right-middle;
		
		int[] left_arr = new int[n1];
		int[] right_arr = new int[n2];
		
		for(int i=0; i<n1;i++)
		{
			left_arr[i] = arr[left+i];
		}
		for(int j=0; j<n2; j++)
		{
			right_arr[j] = arr[middle+1+j];
		}
		
		int i=0, j=0;
		
		int k=left;

		// ��Ҹ� ���Ͽ� arr�� ���ĵ� ��Ҹ� �����մϴ�.
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
		
		// ���� �迭�� ���� ��ҵ��� �����մϴ�.
		while(i<n1)
		{
			arr[k] = left_arr[i];
			i++;
			k++;
		}
		// ������ �迭�� ���� ��Ҹ� �����մϴ�.
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
