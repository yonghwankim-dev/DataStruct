package sort.shell_sort.implement;

public class ShellSort {
	public static void sort(int[] arr)
	{
		int n = arr.length;
		
		// 큰 간격(배열의 절반 길이)에서 시작하여 간격이 1이 될때까지 절반씩 줄임
		for(int gap = n/2; gap>0; gap/=2)
		{
			if(gap%2==0)
			{
				gap++;	// gap을 홀수로 만듬
			}
			
			// 간격(gap)에 따른 여러개의 부분 리스트들을 생성함
			for(int i=gap;i<n;i++)
			{
				// 한개의 부분리스트에서 삽입 정렬을 수행하기 위한 기준값
				int temp = arr[i];
				
				// 한개의 부분리스트에서 삽입 정렬을 수행
				int j;
				for(j=i; j>=gap && arr[j-gap] > temp; j-=gap)
				{
					arr[j] = arr[j-gap];
				}
				arr[j] = temp;
			}
		}
	}
}
