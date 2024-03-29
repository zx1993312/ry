package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.HyCommunityActivity;
import com.ruoyi.system.domain.OwnerAndActivity;
import com.ruoyi.system.mapper.HyCommunityActivityMapper;
import com.ruoyi.system.service.IHyCommunityActivityService;

/**
 * 社区活动Service业务层处理
 * 
 * @author Administrator
 * @date 2021-07-14
 */
@Service
public class HyCommunityActivityServiceImpl implements IHyCommunityActivityService 
{
    @Autowired
    private HyCommunityActivityMapper hyCommunityActivityMapper;

    /**
     * 查询社区活动
     * 
     * @param id 社区活动ID
     * @return 社区活动
     */
    @Override
    public HyCommunityActivity selectHyCommunityActivityById(Long id)
    {
        return hyCommunityActivityMapper.selectHyCommunityActivityById(id);
    }

    /**
     * 查询社区活动列表
     * 
     * @param hyCommunityActivity 社区活动
     * @return 社区活动
     */
    @Override
    public List<HyCommunityActivity> selectHyCommunityActivityList(HyCommunityActivity hyCommunityActivity)
    {
        return hyCommunityActivityMapper.selectHyCommunityActivityList(hyCommunityActivity);
    }

    /**
     * 新增社区活动
     * 
     * @param hyCommunityActivity 社区活动
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyCommunityActivity(HyCommunityActivity hyCommunityActivity)
    {
        hyCommunityActivity.setCreateTime(DateUtils.getNowDate());
        return hyCommunityActivityMapper.insertHyCommunityActivity(hyCommunityActivity);
    }
    
    /**
     * 报名
     * 
     * @param ownerAndActivity 报名
     * @return 报名
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
	public int insertOwnerAndActivity(OwnerAndActivity ownerAndActivity) {

    	HyCommunityActivity hyCommunityActivity = hyCommunityActivityMapper.selectHyCommunityActivityById(ownerAndActivity.getActivityId());
    	int activityPopulation = hyCommunityActivity.getActivityPopulation();
    	OwnerAndActivity ownerAndActivity2 = new OwnerAndActivity();
    	ownerAndActivity2.setActivityId(ownerAndActivity.getActivityId());
    	ownerAndActivity2 = hyCommunityActivityMapper.selectOwnerAndActivityListCount(ownerAndActivity2);
    	int singular = ownerAndActivity2.getSingular();
    	if(activityPopulation>=singular) {
    		return hyCommunityActivityMapper.insertOwnerAndActivity(ownerAndActivity);
    	}else {
    		return 0;
    	}
	}
    
    /**
     * 取消报名
     * 
     * @param ownerAndActivity 取消报名
     * @return 报名
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteOwnerAndActivity(OwnerAndActivity ownerAndActivity) {
    	
    		return hyCommunityActivityMapper.deleteOwnerAndActivity(ownerAndActivity);
    }

    /**
     * 修改社区活动
     * 
     * @param hyCommunityActivity 社区活动
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyCommunityActivity(HyCommunityActivity hyCommunityActivity)
    {
        return hyCommunityActivityMapper.updateHyCommunityActivity(hyCommunityActivity);
    }

    /**
     * 删除社区活动对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommunityActivityByIds(String ids)
    {
        return hyCommunityActivityMapper.deleteHyCommunityActivityByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除社区活动信息
     * 
     * @param id 社区活动ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyCommunityActivityById(Long id)
    {
        return hyCommunityActivityMapper.deleteHyCommunityActivityById(id);
    }

}