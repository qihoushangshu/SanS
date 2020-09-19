package com.sixdog.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.sixdog.dto.User;

@Mapper
public interface UserMapper {

	@Insert("insert into tb_user(name) values	(#{name});")  
	int saveUser(User user);
}
