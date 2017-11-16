package com.dynamicnavbar.helper.impl;

import java.util.List;

import javax.faces.component.UIComponent;

import org.springframework.stereotype.Component;

import com.dynamicnavbar.helper.api.FacesUtils;
import com.dynamicnavbar.helper.api.IMenuBuilder;
import com.dynamicnavbar.service.dto.MenuDto;

import net.bootsfaces.component.dropMenu.DropMenu;
import net.bootsfaces.component.navBar.NavBar;
import net.bootsfaces.component.navBarLinks.NavBarLinks;
import net.bootsfaces.component.navLink.NavLink;

@Component
public class BootsFacesMenuBuilder implements IMenuBuilder{

	public UIComponent buildMenu(MenuDto menu) {
		NavBar menuBar = FacesUtils.createComponent(NavBar.COMPONENT_TYPE);
		menuBar.setId(menu.getId());
		menuBar.setBrand(menu.getValue());
		menuBar.setFixed("top");
		menuBar.setFluid(true);
		NavBarLinks navLink= FacesUtils.createComponent(NavBarLinks.COMPONENT_TYPE);
		
		buildMenuLevels(navLink, menu.getSubMenus());
		menuBar.getChildren().add(navLink);
		return menuBar;
	}

	private void buildMenuLevels(UIComponent parent, List<MenuDto> menulist) {
		menulist.stream().filter(menu -> menu.getActif()).forEach(menu -> buildMenuLevel(parent, menu));
		
	}
	
	private void buildMenuLevel(UIComponent parent, MenuDto menu) {
		if(menu.getLeaf())
			buildMenuLeaf(parent, menu);
		else
			buildMenuGroup(parent, menu);
	}
	

	private void buildMenuLeaf(final UIComponent parent, MenuDto menu) {
		NavLink menuLeaf = FacesUtils.createComponent(NavLink.COMPONENT_TYPE);
		menuLeaf.setId(menu.getId());
		menuLeaf.setValue(menu.getValue());
		menuLeaf.setHref(menu.getLink());
		if(menu.getIcon() !=null)
			menuLeaf.setIconAwesome(menu.getIcon());
		parent.getChildren().add(menuLeaf);
	}

	private void buildMenuGroup(final UIComponent parent, MenuDto menu) {
		DropMenu dropMenu = FacesUtils.createComponent(DropMenu.COMPONENT_TYPE);
		dropMenu.setId(menu.getId());
		dropMenu.getAttributes().put("value", menu.getValue());
		if(menu.getIcon() !=null)
			dropMenu.setIconAwesome(menu.getIcon());
		buildMenuLevels(dropMenu, menu.getSubMenus());
		
		parent.getChildren().add(dropMenu);
	}
	}
