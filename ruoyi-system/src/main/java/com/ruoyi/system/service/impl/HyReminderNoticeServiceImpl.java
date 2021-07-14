package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyReminderNoticeMapper;
import com.ruoyi.system.domain.HyReminderNotice;
import com.ruoyi.system.service.IHyReminderNoticeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 催缴通知Service业务层处理
 * 
 * @author Administrator
 * @date 2021-07-14
 */
@Service
public class HyReminderNoticeServiceImpl implements IHyReminderNoticeService 
{
    @Autowired
    private HyReminderNoticeMapper hyReminderNoticeMapper;

    /**
     * 查询催缴通知
     * 
     * @param id 催缴通知ID
     * @return 催缴通知
     */
    @Override
    public HyReminderNotice selectHyReminderNoticeById(Long id)
    {
        return hyReminderNoticeMapper.selectHyReminderNoticeById(id);
    }

    /**
     * 查询催缴通知列表
     * 
     * @param hyReminderNotice 催缴通知
     * @return 催缴通知
     */
    @Override
    public List<HyReminderNotice> selectHyReminderNoticeList(HyReminderNotice hyReminderNotice)
    {
        return hyReminderNoticeMapper.selectHyReminderNoticeList(hyReminderNotice);
    }

    /**
     * 新增催缴通知
     * 
     * @param hyReminderNotice 催缴通知
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyReminderNotice(HyReminderNotice hyReminderNotice)
    {
        return hyReminderNoticeMapper.insertHyReminderNotice(hyReminderNotice);
    }

    /**
     * 修改催缴通知
     * 
     * @param hyReminderNotice 催缴通知
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyReminderNotice(HyReminderNotice hyReminderNotice)
    {
        return hyReminderNoticeMapper.updateHyReminderNotice(hyReminderNotice);
    }

    /**
     * 删除催缴通知对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyReminderNoticeByIds(String ids)
    {
        return hyReminderNoticeMapper.deleteHyReminderNoticeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除催缴通知信息
     * 
     * @param id 催缴通知ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyReminderNoticeById(Long id)
    {
        return hyReminderNoticeMapper.deleteHyReminderNoticeById(id);
    }
}
