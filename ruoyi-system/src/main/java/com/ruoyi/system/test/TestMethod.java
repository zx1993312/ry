package com.ruoyi.system.test;

import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.Random;
import com.ruoyi.system.test.AClasss;
public class TestMethod {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
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
	
		for(int i=0;i<list.size();i++) {
			if(list.get(i) instanceof AClasss) {
				listA.add((AClasss)list.get(i));
			}
			if(list.get(i) instanceof BClasss) {
				listB.add((BClasss) list.get(i));
			}
			
		}
		System.out.println(list);
		System.out.println(listA);
		System.out.println(listB);
		
		
		
		
	}
}
