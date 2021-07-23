package com.ruoyi.quartz.task;

import org.springframework.stereotype.Component;

@Component("hangYuTask")
public class HangYuTask {

	public void updateTaskAndNode() {
		System.out.println("执行无参方法");
	}

}
