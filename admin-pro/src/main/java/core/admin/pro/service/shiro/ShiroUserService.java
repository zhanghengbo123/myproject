package core.admin.pro.service.shiro;


import core.admin.domain.NetworkUser;

import java.util.Set;

public interface ShiroUserService {

	public NetworkUser getByUserName(String username);

	public Set<String> getRoles(String username);

	public Set<String> getPermissions(String username);

	public NetworkUser getByUserID(Long id);
	//根据token查询 用户信息
	/*public ShiroResult getByUserToken(String tokens);*/
	
	
}
