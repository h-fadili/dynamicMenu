package com.dynamicnavbar.service.dto;

import java.io.Serializable;
import java.util.List;

public class MenuDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7668110428836919837L;
	private String id;
	private String value;
	private String link;
	private Boolean leaf;
	private Integer order;
	private Boolean actif;
	private String icon;
	private List<MenuDto> subMenus;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Boolean getLeaf() {
		return leaf;
	}
	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public List<MenuDto> getSubMenus() {
		return subMenus;
	}
	public void setSubMenus(List<MenuDto> subMenus) {
		this.subMenus = subMenus;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getActif() {
		return actif;
	}
	public void setActif(Boolean actif) {
		this.actif = actif;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
	
}
