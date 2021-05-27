package com.ruoyi.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ruoyi.system.domain.BatchHouseInf;

public interface BatchMapper {

	List<BatchHouseInf> selectHouseInf(@Param("groupName") String groupName, @Param("buildingId") String buildingId);

}
