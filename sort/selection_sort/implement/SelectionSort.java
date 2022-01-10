package sort.selection_sort.implement;

public class SelectionSort {
	public static void sort(int[] arr)
	{
		int n = arr.length;
		for(int i=0; i<n-1; i++)
		{
			int min_val = i;
			for(int j=i+1;j<n;j++)
			{
				if(arr[min_val]>arr[j])
				{
					min_val = j;
				}
			}
			int temp = arr[min_val];
			arr[min_val] = arr[i];
			arr[i] = temp;
		}
	}
}
