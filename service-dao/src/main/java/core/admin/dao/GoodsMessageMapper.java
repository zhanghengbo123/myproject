package core.admin.dao;

import core.admin.domain.GoodsMessage;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/3/17.
 */
@Repository
public interface GoodsMessageMapper {

    public long save(GoodsMessage goodsMessage);

    public long update(GoodsMessage goodsMessage);

    public long delete(Long id);

    public List<GoodsMessage> selectList(Map<String, Object> params);

    public Integer selectListCount(Map<String, Object> params);
}
