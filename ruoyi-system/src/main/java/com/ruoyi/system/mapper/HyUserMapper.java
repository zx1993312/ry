package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HyUser;

/**
 * 用户Mapper接口
 * 
 * @author Administrator
 * @date 2021-03-09
 */
public interface HyUserMapper 
{
    /**
     * 查询用户
     * 
     * @param id 用户ID
     * @return 用户
     */
    public HyUser selectHyUserById(Long id);

    /**
     * 查询用户列表
     * 
     * @param hyUser 用户
     * @return 用户集合
     */
    public List<HyUser> selectHyUserList(HyUser hyUser);

    /**
     * 新增用户
     * 
     * @param hyUser 用户
     * @return 结果
     */
    public int insertHyUser(HyUser hyUser);

    /**
     * 修改用户
     * 
     * @param hyUser 用户
     * @return 结果
     */
    public int updateHyUser(HyUser hyUser);

    /**
     * 删除用户
     * 
     * @param id 用户ID
     * @return 结果
     */
    public int deleteHyUserById(Long id);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyUserByIds(String[] ids);
}
