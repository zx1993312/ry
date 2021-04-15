package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyDeptMapper;
import com.ruoyi.system.domain.HyDept;
import com.ruoyi.system.service.IHyDeptService;
import com.ruoyi.common.core.text.Convert;

/**
 * 部门Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-14
 */
@Service
public class HyDeptServiceImpl implements IHyDeptService 
{
    @Autowired
    private HyDeptMapper hyDeptMapper;

    /**
     * 查询部门
     * 
     * @param id 部门ID
     * @return 部门
     */
    @Override
    public HyDept selectHyDeptById(Long id)
    {
        return hyDeptMapper.selectHyDeptById(id);
    }

    /**
     * 查询部门列表
     * 
     * @param hyDept 部门
     * @return 部门
     */
    @Override
    public List<HyDept> selectHyDeptList(HyDept hyDept)
    {
        return hyDeptMapper.selectHyDeptList(hyDept);
    }

    /**
     * 新增部门
     * 
     * @param hyDept 部门
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyDept(HyDept hyDept)
    {
        hyDept.setCreateTime(DateUtils.getNowDate());
        return hyDeptMapper.insertHyDept(hyDept);
    }

    /**
     * 修改部门
     * 
     * @param hyDept 部门
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyDept(HyDept hyDept)
    {
        return hyDeptMapper.updateHyDept(hyDept);
    }

    /**
     * 删除部门对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyDeptByIds(String ids)
    {
        return hyDeptMapper.deleteHyDeptByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除部门信息
     * 
     * @param id 部门ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyDeptById(Long id)
    {
        return hyDeptMapper.deleteHyDeptById(id);
    }
}
