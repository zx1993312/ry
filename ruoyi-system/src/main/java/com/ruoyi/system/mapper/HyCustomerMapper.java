package com.ruoyi.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ruoyi.system.domain.HouseAndCost;
import com.ruoyi.system.domain.HyCost;
import com.ruoyi.system.domain.HyCustomer;

public interface HyCustomerMapper {

	public List<HyCustomer> selectHyCustomerList();

	public List<HyCost> selectCost(Long id);

	public List<HyCost> selectCostList(Long id);

	public List<Long> selectCostId(@Param("houseId") String houseId, @Param("costId") String costId);
	
	public List<HouseAndCost> selectCostIds(HouseAndCost houseAndCost);

	public Integer insertHouseAndCost(@Param("houseId") String houseId, @Param("costId") String costId);
	
	public Integer insertHouseAndCostByHouseIdAndCostId(HouseAndCost houseAndCost);
	
	public Integer updateHouseAndCost(HouseAndCost houseAndCost);

	public Integer deleteHouseAndCost(@Param("costId") Long costId);

}
