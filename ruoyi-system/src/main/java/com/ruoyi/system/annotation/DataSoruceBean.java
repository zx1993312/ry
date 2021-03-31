package com.ruoyi.system.annotation;

import java.io.Serializable;

public class DataSoruceBean implements Serializable{
	 private static final long serialVersionUID = 1L;
	    
	    private String name;
	    private String brithday;
	    private String province;
	    private String Email;
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getBrithday() {
	        return brithday;
	    }
	    public void setBrithday(String brithday) {
	        this.brithday = brithday;
	    }
	    public String getProvince() {
	        return province;
	    }
	    public void setProvince(String province) {
	        this.province = province;
	    }
	    public String getEmail() {
	        return this.Email;
	    }
	    public void setEmail(String email) {
	        this.Email = email;
	    }

}
