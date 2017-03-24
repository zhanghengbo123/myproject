package core.admin.service.impl;

import core.admin.common.constants.exception.AppException;
import core.admin.dao.GoodsMessageMapper;
import core.admin.domain.GoodsMessage;
import core.admin.service.GoodsMessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/3/21.
 */
@Service("GoodsMessageService")
public class GoodsMessageServiceImpl implements GoodsMessageService {

    private final Logger logger = Logger.getLogger(GoodsMessageServiceImpl.class);

    @Autowired
    private GoodsMessageMapper goodsMessageMapper;

    @Override
    public long saveGoodsMessage(GoodsMessage goodsMessage) {
        long id = 0;
        try{
            if(goodsMessage == null){
                throw new AppException("goodsMessage save error!");
            } else {
                if(goodsMessage.getId() != null && goodsMessage.getId() > 0){
                    id = goodsMessageMapper.save(goodsMessage);
                } else {
                    id = goodsMessageMapper.update(goodsMessage);
                }
            }
        } catch (Exception e){

        }

        return id;
    }

    @Override
    public List<GoodsMessage> queryList(Map<String, Object> search) {

        try{
            return goodsMessageMapper.selectList(search);

        } catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new AppException(e);
        }
    }

    @Override
    public long delete(Long id) {
        long rows = 0;
        try{
            if(id == null && id <= 0){
                throw new AppException("delete goodsMessage error!");
            }
            rows = goodsMessageMapper.delete(id);
        } catch (Exception e){

        }
        return rows;
    }
}
