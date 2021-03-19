package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyUnionpayBusiness;

/**
 * 银联商务Service接口
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public interface IHyUnionpayBusinessService 
{
    /**
     * 查询银联商务
     * 
     * @param id 银联商务ID
     * @return 银联商务
     */
    public HyUnionpayBusiness selectHyUnionpayBusinessById(Long id);

    /**
     * 查询银联商务列表
     * 
     * @param hyUnionpayBusiness 银联商务
     * @return 银联商务集合
     */
    public List<HyUnionpayBusiness> selectHyUnionpayBusinessList(HyUnionpayBusiness hyUnionpayBusiness);

    /**
     * 新增银联商务
     * 
     * @param hyUnionpayBusiness 银联商务
     * @return 结果
     */
    public int insertHyUnionpayBusiness(HyUnionpayBusiness hyUnionpayBusiness);

    /**
     * 修改银联商务
     * 
     * @param hyUnionpayBusiness 银联商务
     * @return 结果
     */
    public int updateHyUnionpayBusiness(HyUnionpayBusiness hyUnionpayBusiness);

    /**
     * 批量删除银联商务
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyUnionpayBusinessByIds(String ids);

    /**
     * 删除银联商务信息
     * 
     * @param id 银联商务ID
     * @return 结果
     */
    public int deleteHyUnionpayBusinessById(Long id);
}
