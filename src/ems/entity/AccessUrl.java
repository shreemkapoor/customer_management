package ems.entity;

import java.util.List;

public class AccessUrl {

	private int urlId;
	private String url;
	private String urlDesc;
	private Integer roleIdList[];
	private Integer roleId;
	
	private List<SubUrl> subList;
	public int getUrlId() {
		return urlId;
	}
	public void setUrlId(int urlId) {
		this.urlId = urlId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer[] getRoleIdList() {
		return roleIdList;
	}
	public void setRoleIdList(Integer[] roleIdList) {
		this.roleIdList = roleIdList;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getUrlDesc() {
		return urlDesc;
	}
	public void setUrlDesc(String urlDesc) {
		this.urlDesc = urlDesc;
	}
	public List<SubUrl> getSubList() {
		return subList;
	}
	public void setSubList(List<SubUrl> subList) {
		this.subList = subList;
	}
	
	
	
}
