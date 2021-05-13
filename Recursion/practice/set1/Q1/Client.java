package Recursion.practice.set1.Q1;

public class Client {

	// Question1
	// 다음 메서드를 설명하시오.
	
	// Answer
	// 1~x의 합 + y의 결과를 반환하는 재귀 함수
	// 1~x의 합은 등차수열을 의미한다. => (x*(x+1))/2
	// 따라서 func1 = (x*(x+1))/2 + y 이다.
	public static int func1(int x, int y)
	{
		if(x==0){
			return y;
		}
		else{
			return func1(x-1,x+y);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(func1(5,0));	// 15
		System.out.println(func1(5,1));	// 16
	}

}
