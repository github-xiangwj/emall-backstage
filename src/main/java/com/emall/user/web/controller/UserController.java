package com.emall.user.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emall.user.bean.User;
import com.emall.user.bean.User.BaseView;
import com.emall.user.bean.User.DetailView;
import com.emall.user.bean.UserQueryCondition;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/user")
public class UserController {

	@PutMapping
	public User update(@Valid @RequestBody User user){
		
		//记录错误信
		System.out.println("-------");
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getBirthday());
		
		return user;
	}
	
	/**
	 * 
	 * @param user
	 * @param errors 当valid校验不通过时，记录错误信息
	 * @return
	 */
	@PostMapping
	public User create(@Valid @RequestBody User user){
		
		System.out.println("-------");
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getBirthday());
		
		user.setId("1");
		
		return user;
	}
	
	@GetMapping
	@JsonView(BaseView.class)
	@ApiOperation(value="查询服务")
	public List<User> query(UserQueryCondition condition, @PageableDefault(page=1, size=10, sort="age,desc") Pageable pageable){
		System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(pageable.getPageNumber());
		System.out.println(pageable.getPageSize());
		System.out.println(pageable.getSort());
		
		User u1 = new User();
		u1.setUsername("u1");
		User u2 = new User();
		u2.setUsername("u2");
		User u3 = new User();
		u3.setUsername("u3");
		List<User> users = new ArrayList<User>();
		users.add(u1);
		users.add(u2);
		users.add(u3);
		return users;
	}
	
	@GetMapping("/{id:\\d+}")
	@JsonView(DetailView.class)
	public User getInfo(@ApiParam(value="用户id") @PathVariable String id){
		System.out.println("id:"+id);
		User u1 = new User();
		u1.setUsername("u1");
		return u1;
	}

}
