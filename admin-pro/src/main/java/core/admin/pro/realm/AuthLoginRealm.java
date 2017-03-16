package core.admin.pro.realm;


import core.admin.domain.NetworkUser;
import core.admin.pro.service.shiro.ShiroUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class AuthLoginRealm extends AuthorizingRealm{

	@Resource
	private ShiroUserService shiroUserService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username=(String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(shiroUserService.getRoles(username));
		authorizationInfo.setStringPermissions(shiroUserService.getPermissions(username));
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		String username=(String)token.getPrincipal();

		NetworkUser user = shiroUserService.getByUserName(username);
		if(user!=null){
				AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getMobile(),user.getPassword(),"xx");
				return authcInfo;
			}else{
				return null;				
			}
	}

}
