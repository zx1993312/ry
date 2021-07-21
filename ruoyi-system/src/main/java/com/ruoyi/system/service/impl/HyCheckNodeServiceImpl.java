package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.domain.HyCheckNode;
import com.ruoyi.system.mapper.HyCheckNodeMapper;
import com.ruoyi.system.service.IHyCheckNodeService;
import com.ruoyi.system.utils.GoogleCodeUtil;
import com.ruoyi.common.core.text.Convert;

/**
 * 巡检节点Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-25
 */
@Service
public class HyCheckNodeServiceImpl implements IHyCheckNodeService {
	@Autowired
	private HyCheckNodeMapper hyCheckNodeMapper;

	/**
	 * 查询巡检节点
	 * 
	 * @param id 巡检节点ID
	 * @return 巡检节点
	 */
	@Override
	public HyCheckNode selectHyCheckNodeById(Long id) {
		return hyCheckNodeMapper.selectHyCheckNodeById(id);
	}

	/**
	 * 查询巡检节点列表
	 * 
	 * @param hyCheckNode 巡检节点
	 * @return 巡检节点
	 */
	@Override
	public List<HyCheckNode> selectHyCheckNodeList(HyCheckNode hyCheckNode) {
		return hyCheckNodeMapper.selectHyCheckNodeList(hyCheckNode);
	}

	/**
	 * 新增巡检节点
	 * 
	 * @param hyCheckNode 巡检节点
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertHyCheckNode(HyCheckNode hyCheckNode) {
		int row = 0;
		List<HyCheckNode> list = hyCheckNodeMapper.selectHyCheckNodeList(hyCheckNode);
		if(list.size()!=0) {
			return row;
		}
		row = hyCheckNodeMapper.insertHyCheckNode(hyCheckNode);
		if (row > 0) {
			hyCheckNode = hyCheckNodeMapper.selectHyCheckNodeList(hyCheckNode).get(0);
			Long nodeId = hyCheckNode.getId();
			String content = "http://192.168.0.111:8081/#/qualityInspection?uuu="+nodeId;
			String outFilePath = "E://";
			String fileName = hyCheckNode.getName()+".png";
			GoogleCodeUtil.creatCode(content, outFilePath, fileName);
		}

		return row;
	}

	/**
	 * 修改巡检节点
	 * 
	 * @param hyCheckNode 巡检节点
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int updateHyCheckNode(HyCheckNode hyCheckNode) {
		return hyCheckNodeMapper.updateHyCheckNode(hyCheckNode);
	}

	/**
	 * 删除巡检节点对象
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteHyCheckNodeByIds(String ids) {
		return hyCheckNodeMapper.deleteHyCheckNodeByIds(Convert.toStrArray(ids));
	}

	/**
	 * 删除巡检节点信息
	 * 
	 * @param id 巡检节点ID
	 * @return 结果
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteHyCheckNodeById(Long id) {
		return hyCheckNodeMapper.deleteHyCheckNodeById(id);
	}
}
