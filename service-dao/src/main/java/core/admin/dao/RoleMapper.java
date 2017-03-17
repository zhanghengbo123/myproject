package core.admin.dao;

import core.admin.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleMapper {
    public Long save(Role role);

    public Long update(Role role);

    public Long delete(Long id);

    public List<Role> selectList(Map<String, Object> params);

    public Integer selectListCount(Map<String, Object> params);

    public Role selectById(Long id);
}
