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
		int powed=1;	// 자리수, 1,10,100,... 10^n
		int index=0;
		
		// 버킷 생성
		for(int i=0;i<10;i++)
		{
			bucket.add(new LinkedList<Integer>());
		}
		
		// 자리수가 가장 큰 만큼 전체 반복문을 반복함
		for(int i=1;i<=maxSize;i++)
		{
			for(int j=0;j<n;j++)
			{
				// 각 자리수의 맞는 index의 bucket에 넣음
				bucket.get((arr[j]/powed)%10).add(arr[j]);
			}
			
			// 버킷에서 데이터를 가지고 옴
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
