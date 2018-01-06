package com.luciano.hackerranktest.java.advanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.Permission;

/**
 * Solution for:
 * https://www.hackerrank.com/challenges/can-you-access/problem
 * Can You Access
 *
 * @author lucianomda
 *
 */
public class CanYouAccess {

	public static void main(String[] args) throws Exception {
		DoNotTerminate.forbidExit();

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(br.readLine().trim());
			Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private

			/** Begin of my code. **/
			Class<Inner.Private> privateClass = Inner.Private.class;
			Constructor<Inner.Private> constructor = privateClass.getDeclaredConstructor(Inner.class);
			constructor.setAccessible(true);
			o = constructor.newInstance(new Inner());
			Method powerof2Method = privateClass.getDeclaredMethod("powerof2", int.class);
			powerof2Method.setAccessible(true);

			System.out.printf("%d is %s\n", num, powerof2Method.invoke(o, num));
			/** End of my code. **/
			System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

		}//end of try

		catch (DoNotTerminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}//end of main

	static class Inner {
		private class Private {
			private String powerof2(int num) {
				return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
			}
		}
	}//end of Inner

}//end of Solution

class DoNotTerminate { //This class prevents exit(0)

	public static class ExitTrappedException extends SecurityException {

		private static final long serialVersionUID = 1L;
	}

	public static void forbidExit() {
		final SecurityManager securityManager = new SecurityManager() {
			@Override
			public void checkPermission(Permission permission) {
				if (permission.getName().contains("exitVM")) {
					throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);
	}
}
