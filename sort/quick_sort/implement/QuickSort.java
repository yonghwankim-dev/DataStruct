package sort.quick_sort.implement;

import java.util.Arrays;

public class QuickSort<E> {
	private static int partition(int[] arr, int left, int right)
	{
		int pivot;
		int low, high;
		
		low = left+1;
		high = right;
		pivot = arr[left];	// ������ ����Ʈ�� ���� ���� �����͸� pivot���� ���� (������ ���� pivot���� ������)
	
		while(low<high)
		{
			// pivot���� ū ���� ã�������� low�� ����
			while(low<=right && arr[low]<pivot)
			{
				low++;
			}
			
			// pivot���� ���� ���� ã�������� high�� ����
			while(high>=left && arr[high]>pivot)
			{
				high--;
			}
			
			// ���� �� low�� high�� �̵��Ͽ������� low�� high���� ���� ���
			// arr[low]�� arr[high] �� ��ȯ ����
			if(low<high)
			{
				swap(arr, low, high);
			}
		}
		
		// low�� high�� ��ġ�ų� ������(ū ���)�� �ִ� ���
		// arr[left]�� arr[high]�� �� ��ȯ
		swap(arr, left, high);
		
		// pivot�� ��ġ�� high�� ��ȯ (high�� ��ġ�� ������ �Ϸ��)
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
		// ������ ������ 2�� �̻��� ���
		if(left<right)
		{
			// pivot�� �����Ͽ� ������ �迭�� ����
			int pivot = partition(arr, left, right);
			
			// pivot�� ������ 2���� �κ� ����Ʈ�� ������� ��ȯ ȣ��
			sort(arr, left, pivot-1);	// pivot�� ������ ���� (����)
			sort(arr, pivot+1, right);	// pivot�� �������� ���� (����)
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
