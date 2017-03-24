package core.admin.service.impl;

import core.admin.common.constants.exception.AppException;
import core.admin.dao.GoodsMapper;
import core.admin.domain.Goods;
import core.admin.service.GoodsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/3/20.
 */
@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {

    private final Logger logger = Logger.getLogger(GoodsServiceImpl.class);

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public long saveGoods(Goods goods) {
        long id = 0;
        try {
            if(goods != null){
                if(goods.getId() != null && goods.getId() > 0){
                    id = goodsMapper.update(goods);
                } else {
                    id = goodsMapper.save(goods);
                }
            }
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new AppException(e);
        }
        return id;
    }

    @Override
    public List<Goods> queryList(Map<String, Object> search) {

        try {
            return goodsMapper.selectList(search);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new AppException(e);
        }
    }

    @Override
    public Goods queryById(Long id) {

        try {
            return goodsMapper.selectOne(id);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new AppException(e);
        }
    }

    @Override
    public long deleteGoods(Long id) {
        long rows = 0;
        try {
            rows = goodsMapper.delete(id);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new AppException(e);
        }
        return rows;
    }
}
