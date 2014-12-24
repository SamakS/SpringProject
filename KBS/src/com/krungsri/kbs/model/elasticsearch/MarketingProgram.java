package com.krungsri.kbs.model.elasticsearch;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "mkt-index", type = "mkt-type", indexStoreType = "memory", shards = 5, replicas = 0, refreshInterval = "-1")
public class MarketingProgram {
	@Id
	private String id;	
	@Field(type=FieldType.String)
	private String path;
	@Field(type=FieldType.String)
	private String name;
	@Field(type=FieldType.String)
	private String overview;
	@Field(type=FieldType.String)
	private String keyword;
//	private String iconPath;
//	private MultipartFile iconFile;
//	private String status;
//	private String[] group;
//	private String description;
//	private String startDate;
//	private String endDate;
//	private String attachmentPath1;
//	private MultipartFile attachmentFile1;
//	private String attachmentPath2;
//	private MultipartFile attachmentFile2;
//	private String attachmentPath3;
//	private MultipartFile attachmentFile3;
//	private String attachmentPath4;
//	private MultipartFile attachmentFile4;
//	private String attachmentPath5;
//	private MultipartFile attachmentFile5;
//	private String link;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
//	public String getIconPath() {
//		return iconPath;
//	}
//	public void setIconPath(String iconPath) {
//		this.iconPath = iconPath;
//	}
//	public MultipartFile getIconFile() {
//		return iconFile;
//	}
//	public void setIconFile(MultipartFile iconFile) {
//		this.iconFile = iconFile;
//	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
//	public String[] getGroup() {
//		return group;
//	}
//	public void setGroup(String[] group) {
//		this.group = group;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public String getStartDate() {
//		return startDate;
//	}
//	public void setStartDate(String startDate) {
//		this.startDate = startDate;
//	}
//	public String getEndDate() {
//		return endDate;
//	}
//	public void setEndDate(String endDate) {
//		this.endDate = endDate;
//	}
//	public String getAttachmentPath1() {
//		return attachmentPath1;
//	}
//	public void setAttachmentPath1(String attachmentPath1) {
//		this.attachmentPath1 = attachmentPath1;
//	}
//	public MultipartFile getAttachmentFile1() {
//		return attachmentFile1;
//	}
//	public void setAttachmentFile1(MultipartFile attachmentFile1) {
//		this.attachmentFile1 = attachmentFile1;
//	}
//	public String getAttachmentPath2() {
//		return attachmentPath2;
//	}
//	public void setAttachmentPath2(String attachmentPath2) {
//		this.attachmentPath2 = attachmentPath2;
//	}
//	public MultipartFile getAttachmentFile2() {
//		return attachmentFile2;
//	}
//	public void setAttachmentFile2(MultipartFile attachmentFile2) {
//		this.attachmentFile2 = attachmentFile2;
//	}
//	public String getAttachmentPath3() {
//		return attachmentPath3;
//	}
//	public void setAttachmentPath3(String attachmentPath3) {
//		this.attachmentPath3 = attachmentPath3;
//	}
//	public MultipartFile getAttachmentFile3() {
//		return attachmentFile3;
//	}
//	public void setAttachmentFile3(MultipartFile attachmentFile3) {
//		this.attachmentFile3 = attachmentFile3;
//	}
//	public String getAttachmentPath4() {
//		return attachmentPath4;
//	}
//	public void setAttachmentPath4(String attachmentPath4) {
//		this.attachmentPath4 = attachmentPath4;
//	}
//	public MultipartFile getAttachmentFile4() {
//		return attachmentFile4;
//	}
//	public void setAttachmentFile4(MultipartFile attachmentFile4) {
//		this.attachmentFile4 = attachmentFile4;
//	}
//	public String getAttachmentPath5() {
//		return attachmentPath5;
//	}
//	public void setAttachmentPath5(String attachmentPath5) {
//		this.attachmentPath5 = attachmentPath5;
//	}
//	public MultipartFile getAttachmentFile5() {
//		return attachmentFile5;
//	}
//	public void setAttachmentFile5(MultipartFile attachmentFile5) {
//		this.attachmentFile5 = attachmentFile5;
//	}
//	public String getLink() {
//		return link;
//	}
//	public void setLink(String link) {
//		this.link = link;
//	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
