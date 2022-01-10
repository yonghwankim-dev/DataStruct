package sort.shell_sort.implement;

public class ShellSort {
	public static void sort(int[] arr)
	{
		int n = arr.length;
		
		// ū ����(�迭�� ���� ����)���� �����Ͽ� ������ 1�� �ɶ����� ���ݾ� ����
		for(int gap = n/2; gap>0; gap/=2)
		{
			if(gap%2==0)
			{
				gap++;	// gap�� Ȧ���� ����
			}
			
			// ����(gap)�� ���� �������� �κ� ����Ʈ���� ������
			for(int i=gap;i<n;i++)
			{
				// �Ѱ��� �κи���Ʈ���� ���� ������ �����ϱ� ���� ���ذ�
				int temp = arr[i];
				
				// �Ѱ��� �κи���Ʈ���� ���� ������ ����
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
