package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyFitmentManageMapper;
import com.ruoyi.system.domain.HyFitmentManage;
import com.ruoyi.system.service.IHyFitmentManageService;
import com.ruoyi.common.core.text.Convert;

/**
 * 装修管理Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-13
 */
@Service
public class HyFitmentManageServiceImpl implements IHyFitmentManageService 
{
    @Autowired
    private HyFitmentManageMapper hyFitmentManageMapper;

    /**
     * 查询装修管理
     * 
     * @param id 装修管理ID
     * @return 装修管理
     */
    @Override
    public HyFitmentManage selectHyFitmentManageById(Long id)
    {
        return hyFitmentManageMapper.selectHyFitmentManageById(id);
    }

    /**
     * 查询装修管理列表
     * 
     * @param hyFitmentManage 装修管理
     * @return 装修管理
     */
    @Override
    public List<HyFitmentManage> selectHyFitmentManageList(HyFitmentManage hyFitmentManage)
    {
        return hyFitmentManageMapper.selectHyFitmentManageList(hyFitmentManage);
    }

    /**
     * 新增装修管理
     * 
     * @param hyFitmentManage 装修管理
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyFitmentManage(HyFitmentManage hyFitmentManage)
    {
        return hyFitmentManageMapper.insertHyFitmentManage(hyFitmentManage);
    }

    /**
     * 修改装修管理
     * 
     * @param hyFitmentManage 装修管理
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyFitmentManage(HyFitmentManage hyFitmentManage)
    {
        return hyFitmentManageMapper.updateHyFitmentManage(hyFitmentManage);
    }

    /**
     * 删除装修管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyFitmentManageByIds(String ids)
    {
        return hyFitmentManageMapper.deleteHyFitmentManageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除装修管理信息
     * 
     * @param id 装修管理ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyFitmentManageById(Long id)
    {
        return hyFitmentManageMapper.deleteHyFitmentManageById(id);
    }
}
