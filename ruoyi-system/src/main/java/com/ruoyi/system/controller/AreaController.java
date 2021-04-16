package com.ruoyi.system.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.system.domain.HyArea;
import com.ruoyi.system.service.IAreaService;

@Controller
@RequestMapping("/area")
public class AreaController {

	@Autowired
	private IAreaService areaService;

	/**
	 * 模拟数据
	 */
	@RequestMapping("/getCity")
	@ResponseBody
	public List<HyArea> cityData(@Param("parentid") Long parentid) {
		return areaService.selectChinaCityData(parentid);
	}

}
