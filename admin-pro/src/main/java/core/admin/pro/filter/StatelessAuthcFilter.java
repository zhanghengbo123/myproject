package core.admin.pro.filter;

import core.admin.pro.service.login.LoginService;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class StatelessAuthcFilter extends AccessControlFilter {
	private static final Logger logger = LoggerFactory.getLogger(StatelessAuthcFilter.class);

	@Resource
	private LoginService loginService;

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		return false;
	}
	@Override
	protected boolean onAccessDenied(ServletRequest req, ServletResponse res) throws Exception {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String uri = request.getRequestURI();
		System.out.print("拦截路径" + uri);
			String header = request.getHeader("User-Token");
        String client_type = request.getHeader("Client-Type");

        //判断请求中token是否空
		if (header!= null){
            //判断token是否有对应用户信息
            //String[] tokenInfo = loginCacheService.getTokenInfo(header, client_type);
			String[] tokenInfo = loginService.getTokenInfo(header, client_type);
            if(tokenInfo!=null){

               //获取用户信息中的token
             //   String token = inspectTokenService.getUserLoginInfo(tokenInfo[0],client_type)[0];

               //获取用户信息中的token

               String token = loginService.getUserLoginInfo(tokenInfo[0],client_type)[0];
				//String token = ManagerLogin.getManagerUserInfo().getNewToken();
                //判断是否和前台一致
                if(token.equals(header)){
                    return true;
                }else{
                    //不一致为异地登录
                    response.setHeader("Login-State","statu-error");
                    return false;
                }
				//return true;
            }else{
				//异地登录或者token已过期
				response.setHeader("Login-State","statu-error");
                return false;
            }
        }else{
            return false;
		}
		//return true;
	}
		//登录失败时默认返回 401 状态码
	private void onLoginFail(ServletResponse response) throws IOException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		if(((HttpServletResponse) response).getHeader("User-Token")==null){
			httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}else{
			httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		httpResponse.getWriter().write("login error");
	}

}

