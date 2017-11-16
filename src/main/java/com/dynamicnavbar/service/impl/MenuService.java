package com.dynamicnavbar.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dynamicnavbar.service.api.IMenuService;
import com.dynamicnavbar.service.dto.MenuDto;

@Service
public class MenuService implements IMenuService{

	public MenuDto getMenu() {
		MenuDto menu =new MenuDto();
		menu.setValue("Dynamic Menu");
		menu.setId("menuId");
		List<MenuDto> subMenus = new ArrayList<>();
		subMenus.add(createLeafMenu("Home", "homeId", "home.xhtml", "home"));
		subMenus.add(createGroupMenu("Drop Menu", "dropId", "#", "edit"));
		
		menu.setSubMenus(subMenus);
		return menu;
	}

	private MenuDto createLeafMenu(String val, String id ,String link, String icon) {
		MenuDto menu =new MenuDto();
		menu.setValue(val);
		menu.setId(id);
		menu.setLeaf(Boolean.TRUE);
		menu.setActif(Boolean.TRUE);
		menu.setLink(link);
		menu.setIcon(icon);
		return menu;
	}
	
	private MenuDto createGroupMenu(String val, String id ,String link, String icon) {
		MenuDto menu =new MenuDto();
		menu.setValue(val);
		menu.setId(id);
		menu.setLeaf(Boolean.FALSE);
		menu.setActif(Boolean.TRUE);
		menu.setIcon(icon);
		List<MenuDto> subMenus = new ArrayList<>();
		subMenus.add(createLeafMenu("Menu 1", "menu1Id", "page1.xhtml", null));
		menu.setSubMenus(subMenus);
		return menu;
	}
}
