package com.dynamicnavbar.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dynamicnavbar.controller.api.IMenuController;

@ManagedBean(name="menuViewBean")
@Component(value="menuViewBean")
@SessionScoped
public class MenuViewBean {

	@Autowired
	private IMenuController menuController;
	
	public UIComponent getMenu() {
		return menuController.getMenu();
	}
}
