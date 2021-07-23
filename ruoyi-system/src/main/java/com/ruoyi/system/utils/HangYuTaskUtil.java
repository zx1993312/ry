package com.ruoyi.system.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ruoyi.system.domain.TaskAndNode;
import com.ruoyi.system.mapper.TaskAndNodeMapper;

import lombok.extern.slf4j.Slf4j;

@Component("hangYuTaskUtil")
@Slf4j
public class HangYuTaskUtil {

	@Autowired
	private TaskAndNodeMapper taskAndNodeMapper;

	public void updateTaskAndNode(Integer taskId) {
		try {
			TaskAndNode taskAndNode = new TaskAndNode();
			taskAndNode.setTaskId(Long.valueOf(taskId));
			taskAndNode.setIsInspection("0");
			int result = taskAndNodeMapper.updateTaskAndNode(taskAndNode);
			log.info("修改数据成功！修改了" + result + "条数据");
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

}
