package Recursion.practice.set4.Q2;

public class GFG {
	
	// Question2
	// ��� �����Ͻÿ�.
	
	// Answer
	// 100, a �迭���� ���� �ְ��� ��ȯ�Ѵ�.
	static int fun(int a[], int n)
	{
		int x;
		if(n==1){
			return a[0];
		}else {
			x = fun(a, n-1);
		}
		// x�� a[n-1]�� ��, �� ū���� ��ȯ
		if(x > a[n-1]) {
			return x;
		}else {
			return a[n-1];
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {12,10,30,50,100};
		System.out.println(" " + fun(arr,5) + " ");
	}
}
