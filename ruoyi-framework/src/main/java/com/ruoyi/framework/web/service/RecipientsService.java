package com.ruoyi.framework.web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.domain.HyRecipients;
import com.ruoyi.system.mapper.HyRecipientsMapper;

@Service("recipients")
public class RecipientsService {

	@Autowired
	HyRecipientsMapper hyRecipientsMapper;
	
	/**
	 * 根据字典类型查询字典数据信息
	 * 
	 * @param dictType 字典类型
	 * @return  参数键值
	 */
	public List<HyRecipients> getRecipients(){
		return hyRecipientsMapper.selectHyRecipientsList(new HyRecipients());
		
	}
}
