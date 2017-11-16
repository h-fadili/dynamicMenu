package com.dynamicnavbar.helper.api;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class FacesUtils {

	public static FacesContext getCurrentFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	public static Application getApplication() {
		return getCurrentFacesContext().getApplication();
	}
	
	@SuppressWarnings("unchecked")
	public static <CMP extends UIComponent> CMP createComponent(String componentType) {
		return (CMP) getApplication().createComponent(componentType);
	}
}
