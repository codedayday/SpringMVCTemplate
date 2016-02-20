package com.dayday.action;

public class StringTest {
	final int a;
	
	{
		a = 1;
	}
	
	public static String getA(String a){
		return a;
	}
	
	public static void main(String[] args) {
		String a = "a" + "b" + 1;
		String b = "ab1";
		System.out.println(a == b);
		System.out.println(null == null);
		System.identityHashCode("");
		Object o;
		int c = (int)Math.pow(2.0, 64.0);
		System.out.println(c);
		c = (int)Math.pow(2.0, 86.0);
		System.out.println(c);
		
		final String t = getA(b);
		System.out.println(t == b);
	}

}
