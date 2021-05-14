package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyMemoMapper;
import com.ruoyi.system.domain.HyMemo;
import com.ruoyi.system.service.IHyMemoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备维修保养备忘录Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-13
 */
@Service
public class HyMemoServiceImpl implements IHyMemoService 
{
    @Autowired
    private HyMemoMapper hyMemoMapper;

    /**
     * 查询设备维修保养备忘录
     * 
     * @param id 设备维修保养备忘录ID
     * @return 设备维修保养备忘录
     */
    @Override
    public HyMemo selectHyMemoById(Long id)
    {
        return hyMemoMapper.selectHyMemoById(id);
    }

    /**
     * 查询设备维修保养备忘录列表
     * 
     * @param hyMemo 设备维修保养备忘录
     * @return 设备维修保养备忘录
     */
    @Override
    public List<HyMemo> selectHyMemoList(HyMemo hyMemo)
    {
        return hyMemoMapper.selectHyMemoList(hyMemo);
    }

    /**
     * 新增设备维修保养备忘录
     * 
     * @param hyMemo 设备维修保养备忘录
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyMemo(HyMemo hyMemo)
    {
        return hyMemoMapper.insertHyMemo(hyMemo);
    }

    /**
     * 修改设备维修保养备忘录
     * 
     * @param hyMemo 设备维修保养备忘录
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyMemo(HyMemo hyMemo)
    {
        return hyMemoMapper.updateHyMemo(hyMemo);
    }

    /**
     * 删除设备维修保养备忘录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMemoByIds(String ids)
    {
        return hyMemoMapper.deleteHyMemoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备维修保养备忘录信息
     * 
     * @param id 设备维修保养备忘录ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyMemoById(Long id)
    {
        return hyMemoMapper.deleteHyMemoById(id);
    }
}
