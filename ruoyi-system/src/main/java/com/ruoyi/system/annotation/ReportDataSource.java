package com.ruoyi.system.annotation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class ReportDataSource implements JRDataSource{
	

    private Iterator iter;
    
    //创建一个，map对象用与数据对应
    Map map = new HashMap();
    
    //无参的构造函数
    public ReportDataSource(){
        
    }
    
    //以sex为参数的有参构造函数，用于数据初始化
    public ReportDataSource(String sex){
        //通过性别获取相应用户的数据
        List datas=DateSourceBaseFactory.createBeanCollection(sex);
        //要将List中的数据迭代，需要使用Iterator迭代对象
        iter=datas.iterator();
    }


	@Override
	public boolean next() throws JRException {
		if(iter.hasNext()){
            map=(Map)iter.next();
            return true;
        }
        return false;

	}

	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		 return map.get(arg0.getName());

	}

}
