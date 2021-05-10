package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyOperatingParameterMapper;
import com.ruoyi.system.domain.HyOperatingParameter;
import com.ruoyi.system.service.IHyOperatingParameterService;
import com.ruoyi.common.core.text.Convert;

/**
 * 运行参数Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-10
 */
@Service
public class HyOperatingParameterServiceImpl implements IHyOperatingParameterService 
{
    @Autowired
    private HyOperatingParameterMapper hyOperatingParameterMapper;

    /**
     * 查询运行参数
     * 
     * @param id 运行参数ID
     * @return 运行参数
     */
    @Override
    public HyOperatingParameter selectHyOperatingParameterById(Long id)
    {
        return hyOperatingParameterMapper.selectHyOperatingParameterById(id);
    }

    /**
     * 查询运行参数列表
     * 
     * @param hyOperatingParameter 运行参数
     * @return 运行参数
     */
    @Override
    public List<HyOperatingParameter> selectHyOperatingParameterList(HyOperatingParameter hyOperatingParameter)
    {
        return hyOperatingParameterMapper.selectHyOperatingParameterList(hyOperatingParameter);
    }

    /**
     * 新增运行参数
     * 
     * @param hyOperatingParameter 运行参数
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyOperatingParameter(HyOperatingParameter hyOperatingParameter)
    {
        return hyOperatingParameterMapper.insertHyOperatingParameter(hyOperatingParameter);
    }

    /**
     * 修改运行参数
     * 
     * @param hyOperatingParameter 运行参数
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyOperatingParameter(HyOperatingParameter hyOperatingParameter)
    {
        return hyOperatingParameterMapper.updateHyOperatingParameter(hyOperatingParameter);
    }

    /**
     * 删除运行参数对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyOperatingParameterByIds(String ids)
    {
        return hyOperatingParameterMapper.deleteHyOperatingParameterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除运行参数信息
     * 
     * @param id 运行参数ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyOperatingParameterById(Long id)
    {
        return hyOperatingParameterMapper.deleteHyOperatingParameterById(id);
    }
}
