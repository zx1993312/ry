package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.system.mapper.HyUserMapper;
import com.ruoyi.system.domain.HyUser;
import com.ruoyi.system.service.IHyUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-09
 */
@Service
public class HyUserServiceImpl implements IHyUserService 
{
    @Autowired
    private HyUserMapper hyUserMapper;

    /**
     * 查询用户
     * 
     * @param id 用户ID
     * @return 用户
     */
    @Override
    public HyUser selectHyUserById(Long id)
    {
        return hyUserMapper.selectHyUserById(id);
    }

    /**
     * 查询用户列表
     * 
     * @param hyUser 用户
     * @return 用户
     */
    @Override
    public List<HyUser> selectHyUserList(HyUser hyUser)
    {
        return hyUserMapper.selectHyUserList(hyUser);
    }

    /**
     * 新增用户
     * 
     * @param hyUser 用户
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyUser(HyUser hyUser)
    {
        return hyUserMapper.insertHyUser(hyUser);
    }
    
    /**
     * 新增用户(测试方法)
     * 
     * @param hyUser 用户
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyUserTest(HyUser hyUser)
    {
        return hyUserMapper.insertHyUserTest(hyUser);
    }

    /**
     * 修改用户
     * 
     * @param hyUser 用户
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyUser(HyUser hyUser)
    {
        return hyUserMapper.updateHyUser(hyUser);
    }

    /**
     * 删除用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyUserByIds(String ids)
    {
        return hyUserMapper.deleteHyUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户信息
     * 
     * @param id 用户ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyUserById(Long id)
    {
        return hyUserMapper.deleteHyUserById(id);
    }
}
