package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.mapper.HyPrinterMapper;
import com.ruoyi.system.domain.HyPrinter;
import com.ruoyi.system.service.IHyPrinterService;
import com.ruoyi.common.core.text.Convert;

/**
 * 打印机配置Service业务层处理
 * 
 * @author Administrator
 * @date 2021-03-18
 */
@Service
public class HyPrinterServiceImpl implements IHyPrinterService 
{
    @Autowired
    private HyPrinterMapper hyPrinterMapper;

    /**
     * 查询打印机配置
     * 
     * @param id 打印机配置ID
     * @return 打印机配置
     */
    @Override
    public HyPrinter selectHyPrinterById(Long id)
    {
        return hyPrinterMapper.selectHyPrinterById(id);
    }

    /**
     * 查询打印机配置列表
     * 
     * @param hyPrinter 打印机配置
     * @return 打印机配置
     */
    @Override
    public List<HyPrinter> selectHyPrinterList(HyPrinter hyPrinter)
    {
        return hyPrinterMapper.selectHyPrinterList(hyPrinter);
    }

    /**
     * 新增打印机配置
     * 
     * @param hyPrinter 打印机配置
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertHyPrinter(HyPrinter hyPrinter)
    {
        return hyPrinterMapper.insertHyPrinter(hyPrinter);
    }

    /**
     * 修改打印机配置
     * 
     * @param hyPrinter 打印机配置
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateHyPrinter(HyPrinter hyPrinter)
    {
        return hyPrinterMapper.updateHyPrinter(hyPrinter);
    }

    /**
     * 删除打印机配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyPrinterByIds(String ids)
    {
        return hyPrinterMapper.deleteHyPrinterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除打印机配置信息
     * 
     * @param id 打印机配置ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteHyPrinterById(Long id)
    {
        return hyPrinterMapper.deleteHyPrinterById(id);
    }
}
