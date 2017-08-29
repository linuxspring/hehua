package net.plugins.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import net.plugins.model.User;
import org.apache.ibatis.annotations.Select;



public interface UserMapper extends BaseMapper<User> {
	
	int countUser();

	@Select("getList")
	String getList(int index,int size);
	
	User findByAccount(String account);
	
	User findUserWithRoles(String account);
	
	
	void updateUser(User user);
	
	void delete(Object id);
	
	void insertUser(User user);
	
}
