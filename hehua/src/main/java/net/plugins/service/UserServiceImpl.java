package net.plugins.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import net.pagination.Pagination;
import net.plugins.mapper.UserMapper;
import net.plugins.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User>{
	
	@Resource
	@Autowired(required=true)
	private UserMapper mapper;
	
//	@Resource(name="sqlSessionFactory")
//	private SqlSessionFactory sqlSessionFactory;
	
//	@Resource
//	private SqlSessionFactory sqlSessionFactory2;
//
//	@Resource
//	private SqlSessionFactory sqlSessionFactory3;
//	@Autowired
//	protected BaseMapper baseMapper;
	
	public User findByAccount(String account){

		User user = this.baseMapper.findByAccount(account);
		
		return user;
	}
	
	public User findUserWithRoles(String account){
		
		User user = baseMapper.findUserWithRoles(account);
		
		return user;
	}
	
	public String getList(int page, int size){

		SqlSession sqlSession =this.sqlSessionBatch();// sqlSessionFactory.openSession();

		List<User> result = sqlSession.selectList("net.plugins.mapper.UserMapper.getList", User.class);

		int count;
		try {
			count = sqlSession.selectOne("net.plugins.mapper.UserMapper.countUser");
			System.out.println("count = " + count);
		} finally {
			//sqlSession.close();
		}

		Pagination<User> pagination = new Pagination<User>(page, size, count, result);
		

		
		return "OK";
		
	}
	
	public void updateUser(User user){
		this.baseMapper.updateUser(user);
	}
	
	public void insertUser(User user){
		this.baseMapper.insertUser(user);
	}
}
