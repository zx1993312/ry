package com.ruoyi.quartz.task;

import org.springframework.stereotype.Component;

@Component("testTask")
public class TestTask {

	public void ryNoParams() {
		System.out.println("执行无参方法");
	}

}
