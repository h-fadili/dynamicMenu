package com.dynamicnavbar.helper.api;

import javax.faces.component.UIComponent;

import com.dynamicnavbar.service.dto.MenuDto;

public interface IMenuBuilder {
	
	UIComponent buildMenu(MenuDto menu);

}
