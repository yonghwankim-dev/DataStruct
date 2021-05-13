package Recursion.practice.set1.Q2;

public class Client {

	// minimum index finder
	public static int minIndex(int arr[], int s, int e)
	{
		int sml = Integer.MAX_VALUE;
		int mindex = -1;
		
		for(int i=s;i<e;i++){
			if(sml > arr[i]) {
				sml = arr[i];
				mindex = i;
			}
		}
		return mindex;
	}
	
	// Question2
	// fun2 �޼ҵ忡 ���ؼ� �����Ͻÿ�.
	
	// Answer
	// ���� ������ ����� ���� �Լ�
	public static void fun2(int arr[], int start_index, int end_index)
	{
		if(start_index>= end_index){
			return;
		}
		int min_index;
		int temp;
		
		// minIndex() returns index of minimum value in array arr[start_index...end_index]
		min_index = minIndex(arr, start_index, end_index);
		
		// start_index �ڸ��� min_index �ڸ��� ���Ҹ� ��ȯ�Ѵ�.
		temp = arr[start_index];
		arr[start_index] = arr[min_index];
		arr[min_index] = temp;
		
		fun2(arr, start_index+1, end_index);
	}
	
	public static void main(String[] args) {
		int[] arr = {4,2,1,3,5};
		fun2(arr, 0, arr.length-1);
		for(int n : arr) {	// 1 2 3 4 5
			System.out.print(n + " ");
		}
		
	}

}
