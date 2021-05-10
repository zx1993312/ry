package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyTestparameterMapper;
import com.ruoyi.system.domain.HyTestparameter;
import com.ruoyi.system.service.IHyTestparameterService;
import com.ruoyi.common.core.text.Convert;

/**
 * 检测参数Service业务层处理
 * 
 * @author Administrator
 * @date 2021-05-10
 */
@Service
public class HyTestparameterServiceImpl implements IHyTestparameterService 
{
    @Autowired
    private HyTestparameterMapper hyTestparameterMapper;

    /**
     * 查询检测参数
     * 
     * @param id 检测参数ID
     * @return 检测参数
     */
    @Override
    public HyTestparameter selectHyTestparameterById(Long id)
    {
        return hyTestparameterMapper.selectHyTestparameterById(id);
    }

    /**
     * 查询检测参数列表
     * 
     * @param hyTestparameter 检测参数
     * @return 检测参数
     */
    @Override
    public List<HyTestparameter> selectHyTestparameterList(HyTestparameter hyTestparameter)
    {
        return hyTestparameterMapper.selectHyTestparameterList(hyTestparameter);
    }

    /**
     * 新增检测参数
     * 
     * @param hyTestparameter 检测参数
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyTestparameter(HyTestparameter hyTestparameter)
    {
        return hyTestparameterMapper.insertHyTestparameter(hyTestparameter);
    }

    /**
     * 修改检测参数
     * 
     * @param hyTestparameter 检测参数
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyTestparameter(HyTestparameter hyTestparameter)
    {
        return hyTestparameterMapper.updateHyTestparameter(hyTestparameter);
    }

    /**
     * 删除检测参数对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyTestparameterByIds(String ids)
    {
        return hyTestparameterMapper.deleteHyTestparameterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除检测参数信息
     * 
     * @param id 检测参数ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyTestparameterById(Long id)
    {
        return hyTestparameterMapper.deleteHyTestparameterById(id);
    }
}
