package core.admin.pro.service.shiro.impl;

import core.admin.dao.ShiroUserMapper;
import core.admin.dao.UserMapper;
import core.admin.domain.NetworkUser;
import core.admin.pro.service.shiro.ShiroUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;


@Service("shiroUserService")
public class ShiroUserServiceImpl implements ShiroUserService {
	@Resource
	//
	private ShiroUserMapper shiroUserMapper;

	@Resource
	private UserMapper userMapper;


	public NetworkUser getByUserName(String username) {
		NetworkUser networkUser = shiroUserMapper.getByUserName(username);
        return networkUser;
	}

	public Set<String> getRoles(String username) {
		
		return shiroUserMapper.getRoles(username);
	}

	public Set<String> getPermissions(String username) {
		
		return shiroUserMapper.getPermissions(username);
	}

/*	public ShiroResult getByUserToken(String tokens) {
	String json = jedisClient.get(REDIS_USER_SESSION_KEY + ":" + tokens);
		
		 if(SecurityUtils.getSubject().isAuthenticated()) {
			 System.out.println();
	            return ShiroResult.build(400, "token过期,重写登陆拉");
	      } 
		 
		 jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + tokens, SSO_SESSION_EXPIRE);
		 
		return ShiroResult.ok(JsonUtils.jsonToPojo(json, AdminUser.class));
	}*/

	@Override
	public NetworkUser getByUserID(Long id) {
		return userMapper.selectById(id);
	}

}
