package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.HyCollection;

/**
 * 入账处理Service接口
 * 
 * @author Administrator
 * @date 2021-01-23
 */
public interface IHyEntryService 
{
	/**
     * 查询收款管理 Collection management
     * 
     * @param id 收款管理 Collection managementID
     * @return 收款管理 Collection management
     */
    public HyCollection selectHyCollectionById(Long id);
	
	/**
     * 查询收款管理 Collection management列表
     * 
     * @param hyCollection 收款管理 Collection management
     * @return 收款管理 Collection management集合
     */
    public List<HyCollection> selectHyCollectionList(HyCollection hyCollection);

    /**
     * 修改收款管理 Collection management
     * 
     * @param hyCollection 收款管理 Collection management
     * @return 结果
     */
    public int updateHyCollection(HyCollection hyCollection);
}
