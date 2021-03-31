package com.ruoyi.system.annotation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateSourceBaseFactory {
	 public static List createBeanCollection(String sex) {
	        
	        int num=0;
	        if(sex.equals("男")){
	            num=1;
	        }else{
	            num=2;
	        }
	        
	        ResultSet rs=null;
	        Statement st=null;
	        Connection con=null;
	        List datas=new ArrayList();
	        
	        try {
	            con=JDBCConnection.getConnection();
	            st=con.createStatement();
	            rs=st.executeQuery("select name,brithday,province,Email from user where sex="+num);
	            while(rs.next()){
	                Map attris=new HashMap();
	                attris.put("name", rs.getString("name"));
	                attris.put("brithday", rs.getString("brithday"));
	                attris.put("province", rs.getString("province"));
	                attris.put("Email", rs.getString("Email"));
	                datas.add(attris);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	                try {
	                    if(rs!=null) rs.close();
	                    if(st!=null) st.close();
	                    if(con!=null) con.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	        }
	        
	        return datas;
	    }


}
