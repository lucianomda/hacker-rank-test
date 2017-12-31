package com.luciano.hackerranktest.java.advanced;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.function.Predicate;
import java.util.regex.*;
import java.lang.reflect.*;
import static java.lang.System.in;

class Prime {
	public void checkPrime(int... numbers) {
		// Test only supports Java 7.
		for (int i : numbers) {
			BigInteger bi = BigInteger.valueOf(i);
			if (bi.isProbablePrime(100)) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}

/**
 * Solution for
 * https://www.hackerrank.com/challenges/prime-checker/problem
 * Prime Checker
 *
 * @author lucianomda
 *
 */
public class PrimeChecker {
	public static void main(String[] args) {
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(in));
			int n1=Integer.parseInt(br.readLine());
			int n2=Integer.parseInt(br.readLine());
			int n3=Integer.parseInt(br.readLine());
			int n4=Integer.parseInt(br.readLine());
			int n5=Integer.parseInt(br.readLine());
			Prime ob=new Prime();
			ob.checkPrime(n1);
			ob.checkPrime(n1,n2);
			ob.checkPrime(n1,n2,n3);
			ob.checkPrime(n1,n2,n3,n4,n5);
			Method[] methods=Prime.class.getDeclaredMethods();
			Set<String> set=new HashSet<>();
			boolean overload=false;
			for(int i=0;i<methods.length;i++)
			{
				if(set.contains(methods[i].getName()))
				{
					overload=true;
					break;
				}
				set.add(methods[i].getName());

			}
			if(overload)
			{
				throw new Exception("Overloading not allowed");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}


