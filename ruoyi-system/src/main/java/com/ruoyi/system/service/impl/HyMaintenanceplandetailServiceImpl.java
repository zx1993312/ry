package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyMaintenanceplandetailMapper;
import com.ruoyi.system.domain.HyMaintenanceplandetail;
import com.ruoyi.system.service.IHyMaintenanceplandetailService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备保养计划执行安排Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-11
 */
@Service
public class HyMaintenanceplandetailServiceImpl implements IHyMaintenanceplandetailService 
{
    @Autowired
    private HyMaintenanceplandetailMapper hyMaintenanceplandetailMapper;

    /**
     * 查询设备保养计划执行安排
     * 
     * @param id 设备保养计划执行安排ID
     * @return 设备保养计划执行安排
     */
    @Override
    public HyMaintenanceplandetail selectHyMaintenanceplandetailById(Long id)
    {
        return hyMaintenanceplandetailMapper.selectHyMaintenanceplandetailById(id);
    }

    /**
     * 查询设备保养计划执行安排列表
     * 
     * @param hyMaintenanceplandetail 设备保养计划执行安排
     * @return 设备保养计划执行安排
     */
    @Override
    public List<HyMaintenanceplandetail> selectHyMaintenanceplandetailList(HyMaintenanceplandetail hyMaintenanceplandetail)
    {
        return hyMaintenanceplandetailMapper.selectHyMaintenanceplandetailList(hyMaintenanceplandetail);
    }

    /**
     * 新增设备保养计划执行安排
     * 
     * @param hyMaintenanceplandetail 设备保养计划执行安排
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyMaintenanceplandetail(HyMaintenanceplandetail hyMaintenanceplandetail)
    {
        return hyMaintenanceplandetailMapper.insertHyMaintenanceplandetail(hyMaintenanceplandetail);
    }

    /**
     * 修改设备保养计划执行安排
     * 
     * @param hyMaintenanceplandetail 设备保养计划执行安排
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyMaintenanceplandetail(HyMaintenanceplandetail hyMaintenanceplandetail)
    {
        return hyMaintenanceplandetailMapper.updateHyMaintenanceplandetail(hyMaintenanceplandetail);
    }

    /**
     * 删除设备保养计划执行安排对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaintenanceplandetailByIds(String ids)
    {
        return hyMaintenanceplandetailMapper.deleteHyMaintenanceplandetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备保养计划执行安排信息
     * 
     * @param id 设备保养计划执行安排ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMaintenanceplandetailById(Long id)
    {
        return hyMaintenanceplandetailMapper.deleteHyMaintenanceplandetailById(id);
    }
}
