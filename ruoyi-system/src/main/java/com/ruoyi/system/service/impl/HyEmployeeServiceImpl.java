package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyEmployeeMapper;
import com.ruoyi.system.domain.HyEmployee;
import com.ruoyi.system.service.IHyEmployeeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 员工Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-14
 */
@Service
public class HyEmployeeServiceImpl implements IHyEmployeeService 
{
    @Autowired
    private HyEmployeeMapper hyEmployeeMapper;

    /**
     * 查询员工
     * 
     * @param id 员工ID
     * @return 员工
     */
    @Override
    public HyEmployee selectHyEmployeeById(Long id)
    {
        return hyEmployeeMapper.selectHyEmployeeById(id);
    }

    /**
     * 查询员工列表
     * 
     * @param hyEmployee 员工
     * @return 员工
     */
    @Override
    public List<HyEmployee> selectHyEmployeeList(HyEmployee hyEmployee)
    {
        return hyEmployeeMapper.selectHyEmployeeList(hyEmployee);
    }

    /**
     * 新增员工
     * 
     * @param hyEmployee 员工
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyEmployee(HyEmployee hyEmployee)
    {
        return hyEmployeeMapper.insertHyEmployee(hyEmployee);
    }

    /**
     * 修改员工
     * 
     * @param hyEmployee 员工
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyEmployee(HyEmployee hyEmployee)
    {
        return hyEmployeeMapper.updateHyEmployee(hyEmployee);
    }

    /**
     * 删除员工对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyEmployeeByIds(String ids)
    {
        return hyEmployeeMapper.deleteHyEmployeeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除员工信息
     * 
     * @param id 员工ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyEmployeeById(Long id)
    {
        return hyEmployeeMapper.deleteHyEmployeeById(id);
    }
}
