package boot.entity;

import java.util.Map;

/**
 * 
  * 类名：DeviceInfo.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2015
  * Company: HT
  * @author     zhouxf
  * @date       2015年5月19日
  * @version    1.0
 */
public class DeviceInfo {
	
	private static final long serialVersionUID = 5454155825314635342L;
	
	
	/**
	 * 
	 */
	private java.lang.Integer id;
	
	/**
	 * 外键引用账户表ACCOUNT
	 */
	private java.lang.String fkAccount;
	
	/**
	 * 设备号
	 */
	private java.lang.String deviceid;
	
	/**
	 * 设备渠道
	 */
	private Integer channel;
	
	/**
	 * 
	 */
	private java.lang.String requestedversion;
	
	/**
	 * 
	 */
	private java.lang.String resolvedversion;
	
	/**
	 * 
	 */
	private java.lang.String lastreportedversion;
	
	/**
	 * 0:正常,1:停机,2:销户
	 */
	private String status;
	
	/**
	 * 用户编号
	 */
	private String fkUserId;
	
	/**
	 * 设备类型,0：机顶盒,1：智能终端
	 */
	private String type;
	
	private String businesskey;
	
	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setFkAccount(java.lang.String value) {
		this.fkAccount = value;
	}
	
	public java.lang.String getFkAccount() {
		return this.fkAccount;
	}
	public void setDeviceid(java.lang.String value) {
		this.deviceid = value;
	}
	
	public java.lang.String getDeviceid() {
		return this.deviceid;
	}
	public void setRequestedversion(java.lang.String value) {
		this.requestedversion = value;
	}
	
	public java.lang.String getRequestedversion() {
		return this.requestedversion;
	}
	public void setResolvedversion(java.lang.String value) {
		this.resolvedversion = value;
	}
	
	public java.lang.String getResolvedversion() {
		return this.resolvedversion;
	}
	public void setLastreportedversion(java.lang.String value) {
		this.lastreportedversion = value;
	}
	
	public java.lang.String getLastreportedversion() {
		return this.lastreportedversion;
	}

    /**
     * @return the fkUserId
     */
    public String getFkUserId() {
        return fkUserId;
    }

    /**
     * @param fkUserId the fkUserId to set
     */
    public void setFkUserId(String fkUserId) {
        this.fkUserId = fkUserId;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the channel
     */
    public Integer getChannel() {
        return channel;
    }

    /**
     * @param channel the channel to set
     */
    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    

    /**
     * @return the businesskey
     */
    public String getBusinesskey() {
        return businesskey;
    }

    /**
     * @param businesskey the businesskey to set
     */
    public void setBusinesskey(String businesskey) {
        this.businesskey = businesskey;
    }

    /** 
      * 方法：toString 
      * @see java.lang.Object#toString()
      * 方法说明： 
      * @author     zhouxf
      * @date       2015年8月10日
     */
    @Override
    public String toString() {
        if(fkUserId==null||"".equals(fkUserId)){
            return "DeviceInfo [ deviceid=" + deviceid+ ",businesskey=" + businesskey+ "]";
        }
        return "DeviceInfo [ deviceid=" + deviceid + ",fkUserId=" + fkUserId+",businesskey=" + businesskey+  "]";
    }
}

