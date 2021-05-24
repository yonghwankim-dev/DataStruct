package Recursion.practice.set4.Q3;

public class GFG {
	
	// Question2
	// 결과 예상하시오.

	// Answer
	// 만약 n이 홀수라면 n을 반환하고, 아니라면 n-1을 반환한다.
	// return i++은 i를 반환하고나서 증가시킨다.
	static int fun(int i)
	{
		if(i%2==1) {
			return i++;
		}
		else {
			return fun(fun(i-1));
		}
	}
	
	public static void main(String[] args) {
		System.out.println(" " + fun(200) + " ");
		System.out.println(" " + fun(3) + " ");
		
	}
}
