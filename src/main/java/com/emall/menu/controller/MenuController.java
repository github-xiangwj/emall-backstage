package com.emall.menu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emall.menu.bean.Menu;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/menu")
public class MenuController {
	
	@GetMapping
	public List<Menu> query(){
		Menu home = new Menu();
		home.setMenuId("home");
		home.setMenuName("首页");
		home.setRoute("/");
		
		Menu aboutUs = new Menu();
		aboutUs.setMenuId("aboutUs");
		aboutUs.setMenuName("关于我们");
		aboutUs.setRoute("");
		
		Menu m1 = new Menu();
		m1.setMenuId("menu1");
		m1.setMenuName("商城介绍");
		m1.setRoute("/home");
		Menu m2 = new Menu();
		m2.setMenuId("menu2");
		m2.setMenuName("联系我们");
		m2.setRoute("/contactUs");
		
		aboutUs.getSubMenuList().add(m1);
		aboutUs.getSubMenuList().add(m2);
		
		List<Menu> users = new ArrayList<Menu>();
		users.add(home);
		users.add(aboutUs);
		return users;
	}
	

}
