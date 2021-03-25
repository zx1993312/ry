package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.HyOwnerRegistration;
import com.ruoyi.system.domain.HyParkingInf;

/**
 * 车位资料
Service接口
 * 
 * @author Administrator
 * @date 2021-01-06
 */
public interface IHyParkingInfService 
{
    /**
     * 查询车位资料

     * 
     * @param id 车位资料
ID
     * @return 车位资料

     */
    public HyParkingInf selectHyParkingInfById(Long id);

    /**
     * 查询车位资料
列表
     * 
     * @param hyParkingInf 车位资料

     * @return 车位资料
集合
     */
    public List<HyParkingInf> selectHyParkingInfList(HyParkingInf hyParkingInf);

    /**
     * 新增车位资料

     * 
     * @param hyParkingInf 车位资料

     * @return 结果
     */
    public int insertHyParkingInf(HyParkingInf hyParkingInf);

    /**
     * 修改车位资料

     * 
     * @param hyParkingInf 车位资料

     * @return 结果
     */
    public int updateHyParkingInf(HyParkingInf hyParkingInf);

    /**
     * 批量删除车位资料

     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyParkingInfByIds(String ids);

    /**
     * 删除车位资料
信息
     * 
     * @param id 车位资料
ID
     * @return 结果
     */
    public int deleteHyParkingInfById(Long id);

	public String importOwnerRegistration(List<HyParkingInf> userList, boolean updateSupport, String operName);


}
