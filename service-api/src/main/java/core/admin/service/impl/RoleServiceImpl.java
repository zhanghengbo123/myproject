package core.admin.service.impl;

import core.admin.common.constants.exception.AppException;
import core.admin.common.page.Page;
import core.admin.dao.RoleMapper;
import core.admin.domain.Role;
import core.admin.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pop on 16/1/24.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    private static final Logger logger = Logger.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Long saveRole(Role Role) {
        long rows = 0;
        try {
            if (Role != null) {
                if (Role.getId() != null && Role.getId() != 0) {
                    //更新
                    rows = roleMapper.update(Role);
                } else {
                    //插入
                    rows = roleMapper.save(Role);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppException(e);
        }
        return rows;
    }

    @Override
    public Long deleteRole(Long id) {
        long rows = 0;
        try {
            rows = roleMapper.delete(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppException(e);
        }
        return rows;
    }

    @Override
    public Role queryRoleById(Long id) {
        Role role = null;
        try {
            role = roleMapper.selectById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppException(e);
        }
        return role;
    }

    @Override
    public List<Role> queryRole(Map<String, Object> params) {
        List<Role> list = null;
        try {
            list = roleMapper.selectList(params);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppException(e);
        }
        return list;
    }

    @Override
    public Page<Role> queryRolePage(Integer currentPage, Integer pageSize, Map<String, Object> search) {
        Page<Role> page = null;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderField", "id");
        params.put("orderFieldType", "desc");

        if(search!=null && search.size()>0){
            params.putAll(search);
        }

        try {
            //设置页数。
            page = new Page<Role>(currentPage, pageSize);
            Integer size = roleMapper.selectListCount(params);
            if (size == null || size <= 0) {
                return page;
            }
            page.setTotalCount(size);
            params.put("startIndex", page.getStartIndex());
            params.put("pageSize", page.getPageSize());
            page.setResult(roleMapper.selectList(params));

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppException(e);
        }
        return page;
    }
}
