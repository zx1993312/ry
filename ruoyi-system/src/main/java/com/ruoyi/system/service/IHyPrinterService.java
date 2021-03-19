package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HyPrinter;

/**
 * 打印机配置Service接口
 * 
 * @author Administrator
 * @date 2021-03-18
 */
public interface IHyPrinterService 
{
    /**
     * 查询打印机配置
     * 
     * @param id 打印机配置ID
     * @return 打印机配置
     */
    public HyPrinter selectHyPrinterById(Long id);

    /**
     * 查询打印机配置列表
     * 
     * @param hyPrinter 打印机配置
     * @return 打印机配置集合
     */
    public List<HyPrinter> selectHyPrinterList(HyPrinter hyPrinter);

    /**
     * 新增打印机配置
     * 
     * @param hyPrinter 打印机配置
     * @return 结果
     */
    public int insertHyPrinter(HyPrinter hyPrinter);

    /**
     * 修改打印机配置
     * 
     * @param hyPrinter 打印机配置
     * @return 结果
     */
    public int updateHyPrinter(HyPrinter hyPrinter);

    /**
     * 批量删除打印机配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHyPrinterByIds(String ids);

    /**
     * 删除打印机配置信息
     * 
     * @param id 打印机配置ID
     * @return 结果
     */
    public int deleteHyPrinterById(Long id);
}
