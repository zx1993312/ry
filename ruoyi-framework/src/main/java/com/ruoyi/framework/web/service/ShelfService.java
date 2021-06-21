package com.ruoyi.framework.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.system.domain.HyGoodsShelf;
import com.ruoyi.system.mapper.HyGoodsShelfMapper;

@Service("shelf")
public class ShelfService {
	
	@Autowired
	HyGoodsShelfMapper hyGoodsShelfMapper;
	
	public List<HyGoodsShelf> getShelf(){
		return hyGoodsShelfMapper.selectHyGoodsShelfList(new HyGoodsShelf());
		
	}
}
