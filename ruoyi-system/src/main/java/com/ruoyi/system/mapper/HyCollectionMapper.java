package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyCollection;

/**
 * 收款管理 Collection managementMapper接口
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
public interface HyCollectionMapper 
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
     * 查询收款管理 Collection management列表
     * 
     * @param hyCollection 收款管理 Collection management
     * @return 收款管理 Collection management集合
     */
    public List<HyCollection> selectHyPaymoneyList(HyCollection hyCollection);

    /**
     * 新增收款管理 Collection management
     * 
     * @param hyCollection 收款管理 Collection management
     * @return 结果
     */
    public int insertHyCollection(HyCollection hyCollection);

    /**
     * 修改收款管理 Collection management
     * 
     * @param hyCollection 收款管理 Collection management
     * @return 结果
     */
    public int updateHyCollection(HyCollection hyCollection);

    /**
     * 删除收款管理 Collection management
     * 
     * @param id 收款管理 Collection managementID
     * @return 结果
     */
    public int deleteHyCollectionById(Long id);

    /**
     * 批量删除收款管理 Collection management
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyCollectionByIds(String[] ids);
}
