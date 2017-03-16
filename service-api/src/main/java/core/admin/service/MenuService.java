package core.admin.service;

import core.admin.common.page.Page;
import core.admin.domain.Menu;

import java.util.List;
import java.util.Map;

public interface MenuService {

    Long saveMenu(Menu menu);

    Long deleteMenu(Long id);

    Menu queryMenuById(Long id);

    List<Menu> queryMenu(Map<String, Object> params);

    List<Menu> queryMenuByIds(List<Long> menuIds);

    Page<Menu> queryMenuPage(Integer currentPage, Integer pageSize, Map<String, Object> search);

}
