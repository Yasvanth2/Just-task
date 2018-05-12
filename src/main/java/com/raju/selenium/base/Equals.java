package com.raju.selenium.base;

public class Equals {
	public static void main(String[] args) {
		String s= new String("java");
		String s1= new String("java");
		System.out.println(s==s1);
		System.out.println(s.hashCode());
		System.out.println(s1.hashCode());
		System.out.println(s.equals(s1));
	}

}
