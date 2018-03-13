package com.yim.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yim.entity.User;

public interface IUserMapper {
	
	@Select("select * from tb_user where id = #{id}")
	User findUserById(@Param("id") String id);
	
	@Insert("insert into tb_user(id, name, gender, birthday, address) values(#{id}, #{name}, #{gender}, #{birthday}, #{address})")
	int insertUser(User user);
	
	@Update("update tb_user set name = #{name}, gender = #{gender}, birthday = #{birthday}, address = #{address}, where id = #{id}")
	int updateUser(User user);
	
	@Delete("delete from tb_user where id = #{id}")
	int deleteUser(@Param("id") String id);
}
