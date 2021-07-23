package com.ruoyi.quartz.task;

import org.springframework.stereotype.Component;

@Component("hangYuTask")
public class HangYuTask {

	public void update() {
		System.out.println("执行无参方法");
	}

}
