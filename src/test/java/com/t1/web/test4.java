package com.t1.web;

import java.util.Scanner;

public class test4 {

	public static void main(String[] args) {
		
		int sum = 0;
		for(int i = 0; i <=10; i++) {
			if(i == 10) {
				System.out.print(i+"=");
			}else {
				System.out.print(i+"+");
			}
			sum += i;
		}
		
		System.out.print(sum);
		

}
}