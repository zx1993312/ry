package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyServiceProviderAccountNumberMapper;
import com.ruoyi.system.domain.HyServiceProviderAccountNumber;
import com.ruoyi.system.service.IHyServiceProviderAccountNumberService;
import com.ruoyi.common.core.text.Convert;

/**
 * 服务商商户号Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Service
public class HyServiceProviderAccountNumberServiceImpl implements IHyServiceProviderAccountNumberService 
{
    @Autowired
    private HyServiceProviderAccountNumberMapper hyServiceProviderAccountNumberMapper;

    /**
     * 查询服务商商户号
     * 
     * @param id 服务商商户号ID
     * @return 服务商商户号
     */
    @Override
    public HyServiceProviderAccountNumber selectHyServiceProviderAccountNumberById(Long id)
    {
        return hyServiceProviderAccountNumberMapper.selectHyServiceProviderAccountNumberById(id);
    }

    /**
     * 查询服务商商户号列表
     * 
     * @param hyServiceProviderAccountNumber 服务商商户号
     * @return 服务商商户号
     */
    @Override
    public List<HyServiceProviderAccountNumber> selectHyServiceProviderAccountNumberList(HyServiceProviderAccountNumber hyServiceProviderAccountNumber)
    {
        return hyServiceProviderAccountNumberMapper.selectHyServiceProviderAccountNumberList(hyServiceProviderAccountNumber);
    }

    /**
     * 新增服务商商户号
     * 
     * @param hyServiceProviderAccountNumber 服务商商户号
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyServiceProviderAccountNumber(HyServiceProviderAccountNumber hyServiceProviderAccountNumber)
    {
        return hyServiceProviderAccountNumberMapper.insertHyServiceProviderAccountNumber(hyServiceProviderAccountNumber);
    }

    /**
     * 修改服务商商户号
     * 
     * @param hyServiceProviderAccountNumber 服务商商户号
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyServiceProviderAccountNumber(HyServiceProviderAccountNumber hyServiceProviderAccountNumber)
    {
        return hyServiceProviderAccountNumberMapper.updateHyServiceProviderAccountNumber(hyServiceProviderAccountNumber);
    }

    /**
     * 删除服务商商户号对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyServiceProviderAccountNumberByIds(String ids)
    {
        return hyServiceProviderAccountNumberMapper.deleteHyServiceProviderAccountNumberByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除服务商商户号信息
     * 
     * @param id 服务商商户号ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyServiceProviderAccountNumberById(Long id)
    {
        return hyServiceProviderAccountNumberMapper.deleteHyServiceProviderAccountNumberById(id);
    }
}
