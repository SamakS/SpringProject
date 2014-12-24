package com.krungsri.kbs.model.elasticsearch;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "lmcampaign", type = "campaign", indexStoreType = "memory", shards = 5, replicas = 0, refreshInterval = "-1")
public class Campaign implements Serializable{

	private static final long serialVersionUID = -2815272721169071738L;

	/*
	  CAMPCODE                VARCHAR2(50 BYTE)     NOT NULL,
	  OFFER_DESCRIPTION       VARCHAR2(200 BYTE),
	  OFFER_OWNER             VARCHAR2(50 BYTE),
	  OFFER_START_DT          DATE,
	  OFFER_END_DT            DATE,
	  OFFER_PRIORITY          VARCHAR2(2 BYTE),
	  SOLICITED_PRODUCT       VARCHAR2(50 BYTE)     NOT NULL,
	  SOLICITED_PRODUCT_DESC  VARCHAR2(200 BYTE),
	  OFFER_SHADOW            NUMBER,
	  MAX_SOLICITATION        NUMBER,
	  MAX_SILENT_DAYS         NUMBER,
	  OFFER_SCRIPT            VARCHAR2(600 BYTE),
	  CAMP_IMAGE_PATH         VARCHAR2(200 BYTE),
	  BAY_PRODUCT_CODE        VARCHAR2(15 BYTE),
	  BAY_PROJECT_CODE        VARCHAR2(15 BYTE),
	  UPDATE_DATE             DATE,
	  UPDATE_BY               VARCHAR2(30 BYTE),
	  CM_ID                   VARCHAR2(10 BYTE),
	  CAMP_TEXT_PATH          VARCHAR2(200 BYTE),
	  INBOUND_FLAG            VARCHAR2(1 BYTE),
	  EXCEL_FILE_NAME         VARCHAR2(50 BYTE),
	  TEMPLATE_NUM            NUMBER,
	  TEMPLATE_NAME           VARCHAR2(20 BYTE),
	  LEAD_FLAG               VARCHAR2(1 BYTE),
	  CAMPAIGN_TYPE           VARCHAR2(1 BYTE)
	 * */
	@Id
	private String _id;
	private String campcode;
	private String offerDescription;
	private String offerOwner;	
	private Date offerStartDt;
	private Date offerEndDt;
	private String offerPriority;
	private String solicitedProduct;
	private String solicitedProductDesc;
	private Integer offerShadow;
	private Integer maxSolicitation;
	private Integer maxSilentDays;
	private String offerScript;
	private String campImagePath;
	private String bayProductCode;
	private String bayProjectCode;
	private Date updateDate;	
	private String updateBy;
	private String cmId;
	private String campTxtPath;
	private String inboundFlag;
	private String excelFileName;		
	private Integer templateNum;
	private String templateName;	
	private String leadFlag;	
	private String campaignType;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getCampcode() {
		return campcode;
	}
	public void setCampcode(String campcode) {
		this.campcode = campcode;
	}
	public String getOfferDescription() {
		return offerDescription;
	}
	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}
	public String getOfferOwner() {
		return offerOwner;
	}
	public void setOfferOwner(String offerOwner) {
		this.offerOwner = offerOwner;
	}
	public Date getOfferStartDt() {
		return offerStartDt;
	}
	public void setOfferStartDt(Date offerStartDt) {
		this.offerStartDt = offerStartDt;
	}
	public Date getOfferEndDt() {
		return offerEndDt;
	}
	public void setOfferEndDt(Date offerEndDt) {
		this.offerEndDt = offerEndDt;
	}
	public String getOfferPriority() {
		return offerPriority;
	}
	public void setOfferPriority(String offerPriority) {
		this.offerPriority = offerPriority;
	}
	public String getSolicitedProduct() {
		return solicitedProduct;
	}
	public void setSolicitedProduct(String solicitedProduct) {
		this.solicitedProduct = solicitedProduct;
	}
	public String getSolicitedProductDesc() {
		return solicitedProductDesc;
	}
	public void setSolicitedProductDesc(String solicitedProductDesc) {
		this.solicitedProductDesc = solicitedProductDesc;
	}
	public Integer getOfferShadow() {
		return offerShadow;
	}
	public void setOfferShadow(Integer offerShadow) {
		this.offerShadow = offerShadow;
	}
	public Integer getMaxSolicitation() {
		return maxSolicitation;
	}
	public void setMaxSolicitation(Integer maxSolicitation) {
		this.maxSolicitation = maxSolicitation;
	}
	public Integer getMaxSilentDays() {
		return maxSilentDays;
	}
	public void setMaxSilentDays(Integer maxSilentDays) {
		this.maxSilentDays = maxSilentDays;
	}
	public String getOfferScript() {
		return offerScript;
	}
	public void setOfferScript(String offerScript) {
		this.offerScript = offerScript;
	}
	public String getCampImagePath() {
		return campImagePath;
	}
	public void setCampImagePath(String campImagePath) {
		this.campImagePath = campImagePath;
	}
	public String getBayProductCode() {
		return bayProductCode;
	}
	public void setBayProductCode(String bayProductCode) {
		this.bayProductCode = bayProductCode;
	}
	public String getBayProjectCode() {
		return bayProjectCode;
	}
	public void setBayProjectCode(String bayProjectCode) {
		this.bayProjectCode = bayProjectCode;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getCmId() {
		return cmId;
	}
	public void setCmId(String cmId) {
		this.cmId = cmId;
	}
	public String getCampTxtPath() {
		return campTxtPath;
	}
	public void setCampTxtPath(String campTxtPath) {
		this.campTxtPath = campTxtPath;
	}
	public String getInboundFlag() {
		return inboundFlag;
	}
	public void setInboundFlag(String inboundFlag) {
		this.inboundFlag = inboundFlag;
	}
	public String getExcelFileName() {
		return excelFileName;
	}
	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}
	public Integer getTemplateNum() {
		return templateNum;
	}
	public void setTemplateNum(Integer templateNum) {
		this.templateNum = templateNum;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getLeadFlag() {
		return leadFlag;
	}
	public void setLeadFlag(String leadFlag) {
		this.leadFlag = leadFlag;
	}
	public String getCampaignType() {
		return campaignType;
	}
	public void setCampaignType(String campaignType) {
		this.campaignType = campaignType;
	}
	@Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}