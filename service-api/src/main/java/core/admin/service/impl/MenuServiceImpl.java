package core.admin.service.impl;

import core.admin.common.AdminConstants;
import core.admin.common.constants.exception.AppException;
import core.admin.common.page.Page;
import core.admin.dao.MenuMapper;
import core.admin.domain.Menu;
import core.admin.service.MenuService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pop on 16/1/24.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    private static final Logger logger = Logger.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Long saveMenu(Menu menu) {
        long rows = 0;
        try {
            if (menu != null) {
                if (menu.getId() != null && menu.getId() != 0) {
                    //更新
                    rows = menuMapper.update(menu);
                } else {
                    //插入
                    rows = menuMapper.save(menu);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppException(e);
        }
        return rows;
    }

    @Override
    public Long deleteMenu(Long id) {
        long rows = 0;
        try {
            rows = menuMapper.delete(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppException(e);
        }
        return rows;
    }

    @Override
    public Menu queryMenuById(Long id) {
        Menu menu = null;
        try {
            menu = menuMapper.selectById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppException(e);
        }
        return menu;
    }

    @Override
    public List<Menu> queryMenu(Map<String, Object> params) {
        List<Menu> list = null;
        try {
            list = menuMapper.selectList(params);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppException(e);
        }
        return list;
    }

    @Override
    public List<Menu> queryMenuByIds(List<Long> menuIds) {
        List<Menu> list = null;
        try {
            list = menuMapper.selectListByIds(menuIds);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppException(e);
        }
        return list;
    }

    @Override
    public Page<Menu> queryMenuPage(Integer currentPage, Integer pageSize, Map<String, Object> search) {
        Page<Menu> page = null;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderField", "id");
        params.put("orderFieldType", "desc");

        if(search!=null && search.size()>0){
            params.putAll(search);
        }

        try {
            //设置页数。
            page = new Page<Menu>(currentPage, pageSize);
            Integer size = menuMapper.selectListCount(params);
            if (size == null || size <= 0) {
                return page;
            }
            page.setTotalCount(size);
            params.put("startIndex", page.getStartIndex());
            params.put("pageSize", page.getPageSize());
            page.setResult(menuMapper.selectList(params));

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppException(e);
        }
        return page;
    }
}
