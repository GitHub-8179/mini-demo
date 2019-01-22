package com.reptile;

import java.util.Date;

public class TestD {

	public static void main(String[] args) {
		Date d = new Date();
		String ss = d.getTime()+"";
		System.out.println(ss.substring(0,10));
	}
}
