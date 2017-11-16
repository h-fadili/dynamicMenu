package com.dynamicnavbar.controller.impl;

import javax.faces.component.UIComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dynamicnavbar.controller.api.IMenuController;
import com.dynamicnavbar.helper.api.IMenuBuilder;
import com.dynamicnavbar.service.api.IMenuService;

@Component
public class MenuController implements IMenuController{

	@Autowired
	private IMenuBuilder menuBuilder;
	
	@Autowired
	private IMenuService menuService;
	
	public UIComponent getMenu() {
		return menuBuilder.buildMenu(menuService.getMenu());
	}

}
