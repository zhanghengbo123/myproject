package core.admin.dao;

import core.admin.domain.GoodsPic;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/3/17.
 */
@Repository
public interface GoodsPicMapper {


    public long save(GoodsPic goodsPic);

    public long update(GoodsPic goodsPic);

    public long delete(Long id);

    public List<GoodsPic> selectList(Map<String, Object> params);

    public Integer selectListCount(Map<String, Object> params);

}
