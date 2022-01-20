package sort.radix_sort.implement;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RadixSort {
	
	private static int getMaxLength(int[] arr)
	{
		int maxSize = 0;
		for(int i=0;i<arr.length;i++)
		{
			int length = (int)Math.log10((double)arr[i])+1;
			if(maxSize<length)
			{
				maxSize = length;
			}
		}
		return maxSize;
	}
	public static void sort(int[] arr)
	{
		List<Queue<Integer>> bucket = new LinkedList<Queue<Integer>>();
		int n = arr.length;
		int maxSize = getMaxLength(arr);
		int powed=1;	// �ڸ���, 1,10,100,... 10^n
		int index=0;
		
		// ��Ŷ ����
		for(int i=0;i<10;i++)
		{
			bucket.add(new LinkedList<Integer>());
		}
		
		// �ڸ����� ���� ū ��ŭ ��ü �ݺ����� �ݺ���
		for(int i=1;i<=maxSize;i++)
		{
			for(int j=0;j<n;j++)
			{
				// �� �ڸ����� �´� index�� bucket�� ����
				bucket.get((arr[j]/powed)%10).add(arr[j]);
			}
			
			// ��Ŷ���� �����͸� ������ ��
			for(int k=0;k<10;k++)
			{
				int bucket_num = bucket.get(k).size();
				
				for(int s=0;s<bucket_num;s++)
				{
					arr[index] = bucket.get(k).poll();
					index++;
				}
			}
			index = 0;
			powed *= 10;
		}
	}
	
	public static void main(String args[])
	{
		int[] arr = {99,88,77,66,55,44,33,22,11,0};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
}
