package core.admin.dao;

import core.admin.domain.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/3/17.
 */
@Repository
public interface GoodsMapper {
    public long save(Goods goods);

    public long update(Goods goods);

    public long delete(Long id);

    public List<Goods> selectList(Map<String, Object> params);

    public Integer selectListCount(Map<String, Object> params);
}
