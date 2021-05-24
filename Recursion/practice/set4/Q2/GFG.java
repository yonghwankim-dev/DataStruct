package Recursion.practice.set4.Q2;

public class GFG {
	
	// Question2
	// 결과 예상하시오.
	
	// Answer
	// 100, a 배열에서 가장 최고값을 반환한다.
	static int fun(int a[], int n)
	{
		int x;
		if(n==1){
			return a[0];
		}else {
			x = fun(a, n-1);
		}
		// x와 a[n-1]값 비교, 더 큰값을 반환
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
