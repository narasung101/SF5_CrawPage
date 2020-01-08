package com.t1.web;

public class plusSequence {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		evenSequence();
		evenSequence2();
		oddSequence();

	}
	
	public static void test1() {
		
		int sum = 0;
		int sumEven = 0;
		int sumOdd = 0 ;
		for(int i = 1; i<= 10 ; i++) {
			
			if(i==10) {
				System.out.print(i+"=");
			}else {
				System.out.print(i+"+");
			}
					
			sum += i;
			
		}
		System.out.print(sum + "\n");
		
	}
	
	public static void test2() {
		
		int sum = 0;
		int sumEven = 0;
		int sumOdd = 0 ;
		for(int i = 1; i<= 10 ; i++) {
			
			
			
//			if(i==10) {
//				System.out.print(i +"=");
//			} else {
//				System.out.print(i +"+");
//			}
						
			
			sum += i;
			
		}
		System.out.printf("%d \n", sumEven);
		
	}
	
public static void test3() {
		
		int sum = 0;
		int sumEven = 0;
		int sumOdd = 0 ;
		for(int i = 1; i<= 10 ; i++) {
			
			if(i==10 ) {
				System.out.print(i+"=");
			}else if (i % 2 ==1){
				sumOdd += i;
			} else{
				System.out.print(i+"+");
			}
			
			if(i % 2 ==0) {
				sumEven += i;
			}else {
				sumOdd += i;
			}
			
			sum += i;
			
		}
		System.out.printf("%d \n", sumEven);
		
	}

	public static void test4() {
		int result = 0;
		
		for(int i = 1; i <=10 ; i++) {
			System.out.print(i);
			
		}
		System.out.print(result+"\n");
	

}
	
	public static void evenSequence() {
	
				// 2 + 4 + 6 + 8 + 10 =
				// 1 % 2 = 0 이면 짝수 1이면 홀수
				String evenSequence = "";
				int result = 0;
				for(int i = 1; i <= 10; i++) {
					if(i % 2 == 0) {
					if(i != 10) {
						evenSequence += i + " + ";
					}else{
						evenSequence += i + " = ";
					}
					result += i;
				}	
			}
				System.out.print(evenSequence+result + "\n \n");
		}
	
	
	
	public static void evenSequence2() {
		 
			String evenSequence = "";
			int sum = 0;
			
			for(int i = 1; i <= 10 ; i++) {
				if(i % 2 == 0) {
				if(i == 10) {
					evenSequence += i + "=";
				}else {
					evenSequence += i + "+";
				}
				sum += i;
				}	
				
			}
			System.out.println(evenSequence+sum +"\n");
					
		}
	
	public static void oddSequence() {
				String oddSequence = "";
				int sum = 0;
				for(int i = 1; i<=10; i++) {
					
					if(i %2 == 1) {
						if(i == 9) {
							oddSequence += i +"=";
						}else {
							oddSequence += i +"+";
						}
						sum += i;
					}
										
				}
				System.out.println("홀수를 더한 값: "+oddSequence+sum);
		}


//public static void test5() {
//	
//	int even = 0; // 초기값 설정(짝수)
//	int odd = 0; // 초기값 설정(홀수)
//	for (int i = 1; i <= 100; i++) {
//		if (i % 2 == 0) { // 짝수 조건식
//			even += i; // even = even + i;
//		} else { // 홀수 조건식 : i%2==1 또는 i%2!=0;
//			odd += i; // odd = odd + i;
//		}
//	}
//	System.out.println("짝수 합 : " + even); // 결과 : 2550
//	System.out.println("홀수 합 : " + odd); // 결과 : 2500
//}
			
	

}
