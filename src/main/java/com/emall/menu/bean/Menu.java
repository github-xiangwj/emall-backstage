package com.emall.menu.bean;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	
	private String menuId;
	
	private String menuName;
	
	private String route;
	
	private List<Menu> subMenuList = new ArrayList<Menu>();

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public List<Menu> getSubMenuList() {
		return subMenuList;
	}

	public void setSubMenuList(List<Menu> subMenuList) {
		this.subMenuList = subMenuList;
	}
	
	

}
