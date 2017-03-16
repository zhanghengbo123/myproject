package core.admin.dao;

import core.admin.domain.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MenuMapper {

    public Long save(Menu menu);

    public Long update(Menu menu);

    public Long delete(Long id);

    public List<Menu> selectList(Map<String, Object> params);

    public List<Menu> selectListByIds(@Param("menuIds") List<Long> menuIds);

    public Integer selectListCount(Map<String, Object> params);

    public Menu selectById(Long id);

}
