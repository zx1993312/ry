package com.ruoyi.system.test;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class TestMethod {

	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		
		List<AClasss> listA = new ArrayList<>();
		List<BClasss> listB = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Random ran = new Random();
			if (ran.nextInt() % 2 == 0) {
				list.add(new AClasss());
			} else {
				list.add(new BClasss());
			}
		}
		
		
	}
}
