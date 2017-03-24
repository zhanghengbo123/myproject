package core.admin.service;

import core.admin.domain.GoodsMessage;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/3/21.
 */
public interface GoodsMessageService {

    public long saveGoodsMessage(GoodsMessage goodsMessage);

    public List<GoodsMessage> queryList(Map<String,Object> search);

    public long delete(Long id);
}
