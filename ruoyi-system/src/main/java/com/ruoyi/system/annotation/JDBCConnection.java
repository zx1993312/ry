package com.ruoyi.system.annotation;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	 public static Connection getConnection(){
	        try {
	             String url = "jdbc:mysql://192.168.0.103:3306/hy_database?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";
	             Class.forName("com.mysql.cj.jdbc.Driver");
	             Connection con = DriverManager.getConnection(url, "root", "root");
	             return con;
	         }catch(Exception e){
	              e. printStackTrace();
	         }
	         return null;
	    }

}
