package com.luciano.hackerranktest.java.bignumber;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-bigdecimal/problem
 * Java BigDecimal
 *
 * @author lucianomda
 *
 */
public class JavaBigDecimal {

	public static void main(String []args){
		//Input
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		String []s=new String[n+2];
		for(int i=0;i<n;i++){
			s[i]=sc.next();
		}
		sc.close();
		//Write your code here
		Comparator<String> comparator = Comparator.comparing(BigDecimal::new);
		Arrays.sort(s, 0, n, comparator.reversed());

		//Output
		for(int i=0;i<n;i++)
		{
			System.out.println(s[i]);
		}
	}
}
