package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyCheckMapper;
import com.ruoyi.system.domain.HyCheck;
import com.ruoyi.system.service.IHyCheckService;
import com.ruoyi.common.core.text.Convert;

/**
 * 盘点员Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-20
 */
@Service
public class HyCheckServiceImpl implements IHyCheckService 
{
    @Autowired
    private HyCheckMapper hyCheckMapper;

    /**
     * 查询盘点员
     * 
     * @param id 盘点员ID
     * @return 盘点员
     */
    @Override
    public HyCheck selectHyCheckById(Long id)
    {
        return hyCheckMapper.selectHyCheckById(id);
    }

    /**
     * 查询盘点员列表
     * 
     * @param hyCheck 盘点员
     * @return 盘点员
     */
    @Override
    public List<HyCheck> selectHyCheckList(HyCheck hyCheck)
    {
        return hyCheckMapper.selectHyCheckList(hyCheck);
    }

    /**
     * 新增盘点员
     * 
     * @param hyCheck 盘点员
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyCheck(HyCheck hyCheck)
    {
        return hyCheckMapper.insertHyCheck(hyCheck);
    }

    /**
     * 修改盘点员
     * 
     * @param hyCheck 盘点员
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyCheck(HyCheck hyCheck)
    {
        return hyCheckMapper.updateHyCheck(hyCheck);
    }

    /**
     * 删除盘点员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCheckByIds(String ids)
    {
        return hyCheckMapper.deleteHyCheckByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除盘点员信息
     * 
     * @param id 盘点员ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCheckById(Long id)
    {
        return hyCheckMapper.deleteHyCheckById(id);
    }
}
