package com.krungsri.kbs.model.elasticsearch;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "kbs_exc_booth_index", type = "kbs_exc_booth_type", indexStoreType = "memory", shards = 5, replicas = 0, refreshInterval = "-1")
public class KbsExcBooth {

	@Id
	private String id;		
	private Integer kbsId;
	private String location;
	private String telephone;
	private Date updateTime;
	private String highlightedMessage;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getKbsId() {
		return kbsId;
	}

	public void setKbsId(Integer kbsId) {
		this.kbsId = kbsId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getHighlightedMessage() {
		return highlightedMessage;
	}

	public void setHighlightedMessage(String highlightedMessage) {
		this.highlightedMessage = highlightedMessage;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
