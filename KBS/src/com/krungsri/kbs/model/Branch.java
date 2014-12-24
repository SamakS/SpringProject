package com.krungsri.kbs.model;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Branch implements Serializable{

	private static final long serialVersionUID = 4406003394502536607L;
	/*
	ID                         INTEGER            NOT NULL,
  	BRANCH_CODE                VARCHAR2(100 BYTE),
  	REGION                     VARCHAR2(100 BYTE),
  	BRANCH_NAME                VARCHAR2(1000 BYTE),
  	WORK_DAY_OPEN_PERIOD       VARCHAR2(1000 BYTE),
  	SAT_OPEN_PERIOD            VARCHAR2(1000 BYTE),
  	SUN_OPEN_PERIOD            VARCHAR2(1000 BYTE),
  	OPEN_SPECIAL_HOLIDAY_FLAG  VARCHAR2(50 BYTE),
  	CHECK_CLR_TIME             VARCHAR2(1000 BYTE),
  	HAS_ADM_FLAG               VARCHAR2(50 BYTE),
  	HAS_AUP_FLAG               VARCHAR2(50 BYTE),
  	PHONE_NO                   VARCHAR2(1000 BYTE),
  	FAX_NO                     VARCHAR2(1000 BYTE),
  	ADDRESS                    VARCHAR2(1000 BYTE),
  	LANDMARK                   VARCHAR2(1000 BYTE),
  	REMARK                     VARCHAR2(4000 BYTE),
  	UPDATE_TIME                TIMESTAMP(6)       NOT NULL
	*/
	
	private int id;
	private String branchCode;
	private String region;
	private String branchName;
	private String workDayOpenPeriod;
	private String satOpenPeriod;
	private String sunOpenPeriod;
	private String openSpecialHolidayFlag;
	private String checkClrTime;
	private String hasAdmFlag;
	private String hasAupFlag;
	private String phoneNo;
	private String faxNo;
	private String address;
	private String landmark;
	private String remark;
	private Timestamp updateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getWorkDayOpenPeriod() {
		return workDayOpenPeriod;
	}
	public void setWorkDayOpenPeriod(String workDayOpenPeriod) {
		this.workDayOpenPeriod = workDayOpenPeriod;
	}
	public String getSatOpenPeriod() {
		return satOpenPeriod;
	}
	public void setSatOpenPeriod(String satOpenPeriod) {
		this.satOpenPeriod = satOpenPeriod;
	}
	public String getSunOpenPeriod() {
		return sunOpenPeriod;
	}
	public void setSunOpenPeriod(String sunOpenPeriod) {
		this.sunOpenPeriod = sunOpenPeriod;
	}
	public String getOpenSpecialHolidayFlag() {
		return openSpecialHolidayFlag;
	}
	public void setOpenSpecialHolidayFlag(String openSpecialHolidayFlag) {
		this.openSpecialHolidayFlag = openSpecialHolidayFlag;
	}
	public String getCheckClrTime() {
		return checkClrTime;
	}
	public void setCheckClrTime(String checkClrTime) {
		this.checkClrTime = checkClrTime;
	}
	public String getHasAdmFlag() {
		return hasAdmFlag;
	}
	public void setHasAdmFlag(String hasAdmFlag) {
		this.hasAdmFlag = hasAdmFlag;
	}
	public String getHasAupFlag() {
		return hasAupFlag;
	}
	public void setHasAupFlag(String hasAupFlag) {
		this.hasAupFlag = hasAupFlag;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getFaxNo() {
		return faxNo;
	}
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	@Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}
