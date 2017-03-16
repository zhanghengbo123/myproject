package core.admin.service;

import core.admin.common.page.Page;
import core.admin.domain.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {

    Long saveRole(Role role);

    Long deleteRole(Long id);

    Role queryRoleById(Long id);

    List<Role> queryRole(Map<String, Object> params);

    Page<Role> queryRolePage(Integer currentPage, Integer pageSize, Map<String, Object> search);
}
