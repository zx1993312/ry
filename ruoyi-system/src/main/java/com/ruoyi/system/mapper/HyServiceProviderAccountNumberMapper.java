package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyServiceProviderAccountNumber;

/**
 * 服务商商户号Mapper接口
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public interface HyServiceProviderAccountNumberMapper 
{
    /**
     * 查询服务商商户号
     * 
     * @param id 服务商商户号ID
     * @return 服务商商户号
     */
    public HyServiceProviderAccountNumber selectHyServiceProviderAccountNumberById(Long id);

    /**
     * 查询服务商商户号列表
     * 
     * @param hyServiceProviderAccountNumber 服务商商户号
     * @return 服务商商户号集合
     */
    public List<HyServiceProviderAccountNumber> selectHyServiceProviderAccountNumberList(HyServiceProviderAccountNumber hyServiceProviderAccountNumber);

    /**
     * 新增服务商商户号
     * 
     * @param hyServiceProviderAccountNumber 服务商商户号
     * @return 结果
     */
    public int insertHyServiceProviderAccountNumber(HyServiceProviderAccountNumber hyServiceProviderAccountNumber);

    /**
     * 修改服务商商户号
     * 
     * @param hyServiceProviderAccountNumber 服务商商户号
     * @return 结果
     */
    public int updateHyServiceProviderAccountNumber(HyServiceProviderAccountNumber hyServiceProviderAccountNumber);

    /**
     * 删除服务商商户号
     * 
     * @param id 服务商商户号ID
     * @return 结果
     */
    public int deleteHyServiceProviderAccountNumberById(Long id);

    /**
     * 批量删除服务商商户号
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyServiceProviderAccountNumberByIds(String[] ids);
}
