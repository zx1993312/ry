package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HyProportionSetMapper;
import com.ruoyi.system.domain.HyProportionSet;
import com.ruoyi.system.service.IHyProportionSetService;
import com.ruoyi.common.core.text.Convert;

/**
 * 收费比例设置Service业务层处理
 * 
 * @author Administrator
 * @date 2021-01-23
 */
@Service
public class HyProportionSetServiceImpl implements IHyProportionSetService 
{
    @Autowired
    private HyProportionSetMapper hyProportionSetMapper;

    /**
     * 查询收费比例设置
     * 
     * @param id 收费比例设置ID
     * @return 收费比例设置
     */
    @Override
    public HyProportionSet selectHyProportionSetById(Long id)
    {
        return hyProportionSetMapper.selectHyProportionSetById(id);
    }

    /**
     * 查询收费比例设置列表
     * 
     * @param hyProportionSet 收费比例设置
     * @return 收费比例设置
     */
    @Override
    public List<HyProportionSet> selectHyProportionSetList(HyProportionSet hyProportionSet)
    {
        return hyProportionSetMapper.selectHyProportionSetList(hyProportionSet);
    }

    /**
     * 新增收费比例设置
     * 
     * @param hyProportionSet 收费比例设置
     * @return 结果
     */
    @Override
    public int insertHyProportionSet(HyProportionSet hyProportionSet)
    {
        return hyProportionSetMapper.insertHyProportionSet(hyProportionSet);
    }

    /**
     * 修改收费比例设置
     * 
     * @param hyProportionSet 收费比例设置
     * @return 结果
     */
    @Override
    public int updateHyProportionSet(HyProportionSet hyProportionSet)
    {
        return hyProportionSetMapper.updateHyProportionSet(hyProportionSet);
    }

    /**
     * 删除收费比例设置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHyProportionSetByIds(String ids)
    {
        return hyProportionSetMapper.deleteHyProportionSetByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除收费比例设置信息
     * 
     * @param id 收费比例设置ID
     * @return 结果
     */
    @Override
    public int deleteHyProportionSetById(Long id)
    {
        return hyProportionSetMapper.deleteHyProportionSetById(id);
    }
}
