package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyRecipientsMapper;
import com.ruoyi.system.domain.HyRecipients;
import com.ruoyi.system.service.IHyRecipientsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 接收员Service业务层处理
 * 
 * @author Administrator
 * @date 2021-04-13
 */
@Service
public class HyRecipientsServiceImpl implements IHyRecipientsService 
{
    @Autowired
    private HyRecipientsMapper hyRecipientsMapper;

    /**
     * 查询接收员
     * 
     * @param id 接收员ID
     * @return 接收员
     */
    @Override
    public HyRecipients selectHyRecipientsById(Long id)
    {
        return hyRecipientsMapper.selectHyRecipientsById(id);
    }

    /**
     * 查询接收员列表
     * 
     * @param hyRecipients 接收员
     * @return 接收员
     */
    @Override
    public List<HyRecipients> selectHyRecipientsList(HyRecipients hyRecipients)
    {
        return hyRecipientsMapper.selectHyRecipientsList(hyRecipients);
    }

    /**
     * 新增接收员
     * 
     * @param hyRecipients 接收员
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyRecipients(HyRecipients hyRecipients)
    {
        return hyRecipientsMapper.insertHyRecipients(hyRecipients);
    }

    /**
     * 修改接收员
     * 
     * @param hyRecipients 接收员
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyRecipients(HyRecipients hyRecipients)
    {
        return hyRecipientsMapper.updateHyRecipients(hyRecipients);
    }

    /**
     * 删除接收员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyRecipientsByIds(String ids)
    {
        return hyRecipientsMapper.deleteHyRecipientsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除接收员信息
     * 
     * @param id 接收员ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyRecipientsById(Long id)
    {
        return hyRecipientsMapper.deleteHyRecipientsById(id);
    }
}
