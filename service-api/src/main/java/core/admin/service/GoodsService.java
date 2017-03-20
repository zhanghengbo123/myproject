package core.admin.service;

import core.admin.domain.Goods;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/3/20.
 */
public interface GoodsService {
    public long saveGoods(Goods goods);

    public List<Goods> queryList(Map<String,Object> search);

    public Goods queryById(Long id);

    public long deleteGoods(Long id );
}

