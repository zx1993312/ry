package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HyRevokeMapper;
import com.ruoyi.system.domain.HyRevoke;
import com.ruoyi.system.service.IHyRevokeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 撤销操作Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-26
 */
@Service
public class HyRevokeServiceImpl implements IHyRevokeService 
{
    @Autowired
    private HyRevokeMapper hyRevokeMapper;

    /**
     * 查询撤销操作
     * 
     * @param id 撤销操作ID
     * @return 撤销操作
     */
    @Override
    public HyRevoke selectHyRevokeById(Long id)
    {
        return hyRevokeMapper.selectHyRevokeById(id);
    }

    /**
     * 查询撤销操作列表
     * 
     * @param hyRevoke 撤销操作
     * @return 撤销操作
     */
    @Override
    public List<HyRevoke> selectHyRevokeList(HyRevoke hyRevoke)
    {
        return hyRevokeMapper.selectHyRevokeList(hyRevoke);
    }

    /**
     * 新增撤销操作
     * 
     * @param hyRevoke 撤销操作
     * @return 结果
     */
    @Override
    public int insertHyRevoke(HyRevoke hyRevoke)
    {
        return hyRevokeMapper.insertHyRevoke(hyRevoke);
    }

    /**
     * 修改撤销操作
     * 
     * @param hyRevoke 撤销操作
     * @return 结果
     */
    @Override
    public int updateHyRevoke(HyRevoke hyRevoke)
    {
        return hyRevokeMapper.updateHyRevoke(hyRevoke);
    }

    /**
     * 删除撤销操作对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHyRevokeByIds(String ids)
    {
        return hyRevokeMapper.deleteHyRevokeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除撤销操作信息
     * 
     * @param id 撤销操作ID
     * @return 结果
     */
    @Override
    public int deleteHyRevokeById(Long id)
    {
        return hyRevokeMapper.deleteHyRevokeById(id);
    }
}
