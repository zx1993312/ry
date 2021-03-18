package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyBusinessMapper;
import com.ruoyi.system.domain.HyBusiness;
import com.ruoyi.system.service.IHyBusinessService;
import com.ruoyi.common.core.text.Convert;

/**
 * 商家Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-05
 */
@Service
public class HyBusinessServiceImpl implements IHyBusinessService 
{
    @Autowired
    private HyBusinessMapper hyBusinessMapper;

    /**
     * 查询商家
     * 
     * @param id 商家ID
     * @return 商家
     */
    @Override
    public HyBusiness selectHyBusinessById(Long id)
    {
        return hyBusinessMapper.selectHyBusinessById(id);
    }

    /**
     * 查询商家列表
     * 
     * @param hyBusiness 商家
     * @return 商家
     */
    @Override
    public List<HyBusiness> selectHyBusinessList(HyBusiness hyBusiness)
    {
        return hyBusinessMapper.selectHyBusinessList(hyBusiness);
    }

    /**
     * 新增商家
     * 
     * @param hyBusiness 商家
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyBusiness(HyBusiness hyBusiness)
    {
        return hyBusinessMapper.insertHyBusiness(hyBusiness);
    }

    /**
     * 修改商家
     * 
     * @param hyBusiness 商家
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyBusiness(HyBusiness hyBusiness)
    {
        return hyBusinessMapper.updateHyBusiness(hyBusiness);
    }

    /**
     * 删除商家对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyBusinessByIds(String ids)
    {
        return hyBusinessMapper.deleteHyBusinessByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商家信息
     * 
     * @param id 商家ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyBusinessById(Long id)
    {
        return hyBusinessMapper.deleteHyBusinessById(id);
    }

	@Override
	public List<HyBusiness> selectHyselectHyBusinessDistinct(HyBusiness hyBusiness) {
		return hyBusinessMapper.selectHyselectHyBusinessDistinct(hyBusiness);
	}
}
