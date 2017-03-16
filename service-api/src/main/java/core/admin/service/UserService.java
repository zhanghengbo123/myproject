package core.admin.service;

import core.admin.common.page.Page;
import core.admin.domain.NetworkUser;
import core.admin.page.PaginatedPage;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface UserService {
    NetworkUser login(HttpServletRequest request, String mobile, String password);

    Integer findUserByMobile(String mobile);

    Page<NetworkUser> findNetworkUserList(int currentPage, Integer pageSize, Map<String, Object> search);

    Integer resetPassword(Long id, String newPassword);

    Integer updateStatus(Integer id, Integer status);

    NetworkUser createUser(NetworkUser user);

    Integer removeNetworkUser(Long id);

    public NetworkUser queryAdminUserById(Long id);

    String login(String mobile, String smsCode);
    String getTokenByUid(Integer uId);
    String loginBySmsCode(String mobile, String smsCode);
    String getVerifyCode(String mobile);

    public boolean modfiyPwd(String mobile, String newPwd, String smsCode, Long uId);

}
