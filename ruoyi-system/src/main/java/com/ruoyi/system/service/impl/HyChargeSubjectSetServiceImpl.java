package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HyChargeSubjectSetMapper;
import com.ruoyi.system.domain.HyChargeSubjectSet;
import com.ruoyi.system.service.IHyChargeSubjectSetService;
import com.ruoyi.common.core.text.Convert;

/**
 * 收费科目设置Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-06
 */
@Service
public class HyChargeSubjectSetServiceImpl implements IHyChargeSubjectSetService 
{
    @Autowired
    private HyChargeSubjectSetMapper hyChargeSubjectSetMapper;

    /**
     * 查询收费科目设置
     * 
     * @param id 收费科目设置ID
     * @return 收费科目设置
     */
    @Override
    public HyChargeSubjectSet selectHyChargeSubjectSetById(Long id)
    {
        return hyChargeSubjectSetMapper.selectHyChargeSubjectSetById(id);
    }

    /**
     * 查询收费科目设置列表
     * 
     * @param hyChargeSubjectSet 收费科目设置
     * @return 收费科目设置
     */
    @Override
    public List<HyChargeSubjectSet> selectHyChargeSubjectSetList(HyChargeSubjectSet hyChargeSubjectSet)
    {
        return hyChargeSubjectSetMapper.selectHyChargeSubjectSetList(hyChargeSubjectSet);
    }

    /**
     * 新增收费科目设置
     * 
     * @param hyChargeSubjectSet 收费科目设置
     * @return 结果
     */
    @Override
    public int insertHyChargeSubjectSet(HyChargeSubjectSet hyChargeSubjectSet)
    {
        return hyChargeSubjectSetMapper.insertHyChargeSubjectSet(hyChargeSubjectSet);
    }

    /**
     * 修改收费科目设置
     * 
     * @param hyChargeSubjectSet 收费科目设置
     * @return 结果
     */
    @Override
    public int updateHyChargeSubjectSet(HyChargeSubjectSet hyChargeSubjectSet)
    {
        return hyChargeSubjectSetMapper.updateHyChargeSubjectSet(hyChargeSubjectSet);
    }

    /**
     * 删除收费科目设置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHyChargeSubjectSetByIds(String ids)
    {
        return hyChargeSubjectSetMapper.deleteHyChargeSubjectSetByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除收费科目设置信息
     * 
     * @param id 收费科目设置ID
     * @return 结果
     */
    @Override
    public int deleteHyChargeSubjectSetById(Long id)
    {
        return hyChargeSubjectSetMapper.deleteHyChargeSubjectSetById(id);
    }
}
