package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyEquipmentMapper;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.domain.HyEquipment;
import com.ruoyi.system.service.IHyEquipmentService;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;

/**
 * 设备类别Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-08
 */
@Service
public class HyEquipmentServiceImpl implements IHyEquipmentService 
{
    @Autowired
    private HyEquipmentMapper hyEquipmentMapper;

    /**
     * 查询设备类别
     * 
     * @param id 设备类别ID
     * @return 设备类别
     */
    @Override
    public HyEquipment selectHyEquipmentById(Long id)
    {
        return hyEquipmentMapper.selectHyEquipmentById(id);
    }

    /**
     * 查询设备类别列表
     * 
     * @param hyEquipment 设备类别
     * @return 设备类别
     */
    @Override
    public List<HyEquipment> selectHyEquipmentList(HyEquipment hyEquipment)
    {
        return hyEquipmentMapper.selectHyEquipmentList(hyEquipment);
    }
    
    /**
	 * 查询设备类别列表树
	 * 
	 * @param hyEquipment 设备类别
	 * @return 设备类别
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<Ztree> selectHyEquipmentListTree(HyEquipment hyEquipment) {
		List<Ztree> ztrees = initZtree(hyEquipmentMapper.selectHyEquipmentList(hyEquipment));
		return ztrees;
	}

    /**
     * 新增设备类别
     * 
     * @param hyEquipment 设备类别
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyEquipment(HyEquipment hyEquipment)
    {
        return hyEquipmentMapper.insertHyEquipment(hyEquipment);
    }

    /**
     * 修改设备类别
     * 
     * @param hyEquipment 设备类别
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyEquipment(HyEquipment hyEquipment)
    {
        return hyEquipmentMapper.updateHyEquipment(hyEquipment);
    }

    /**
     * 删除设备类别对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyEquipmentByIds(String ids)
    {
        return hyEquipmentMapper.deleteHyEquipmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备类别信息
     * 
     * @param id 设备类别ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyEquipmentById(Long id)
    {
        return hyEquipmentMapper.deleteHyEquipmentById(id);
    }
    
	/**
	 * 对象转设备类别列表树
	 *
	 * @param deptList 部门列表
	 * @return 树结构列表
	 */
	public List<Ztree> initZtree(List<HyEquipment> hyEquipmentList) {
		return initZtree(hyEquipmentList, null);
	}

	/**
	 * 对象转设备类别列表树
	 *
	 * @param deptList     部门列表
	 * @param roleDeptList 角色已存在菜单列表
	 * @return 树结构列表
	 */
	public List<Ztree> initZtree(List<HyEquipment> hyEquipmentList, List<String> roleDeptList) {

		List<Ztree> ztrees = new ArrayList<Ztree>();
		boolean isCheck = StringUtils.isNotNull(roleDeptList);
		for (HyEquipment hyEquipment : hyEquipmentList) {
			if (UserConstants.DEPT_NORMAL.equals("0")) {
				Ztree ztree = new Ztree();
				ztree.setId(hyEquipment.getId());
				ztree.setpId(Long.valueOf(null == hyEquipment.getParentId() ? -1l : hyEquipment.getParentId()));
				ztree.setName(hyEquipment.getEquipmentName());
				ztree.setTitle(hyEquipment.getEquipmentName());
				if (isCheck) {
					ztree.setChecked(roleDeptList.contains(hyEquipment.getId() + hyEquipment.getEquipmentName()));
				}
				ztrees.add(ztree);
			}
		}
		return ztrees;
	}
}
