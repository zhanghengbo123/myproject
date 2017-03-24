package core.admin.service.impl;

import core.admin.common.constants.exception.AppException;
import core.admin.dao.GoodsPicMapper;
import core.admin.domain.GoodsPic;
import core.admin.service.GoodsPicService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/3/21.
 */
@Service("GoodsPicService")
public class GoodsPicServiceImpl implements GoodsPicService {

    private final Logger logger = Logger.getLogger(GoodsPicServiceImpl.class);

    @Autowired
    private GoodsPicMapper goodsPicMapper;

    @Override
    public long savePic(GoodsPic goodsPic) {
        long id = 0;
        try {
            if(goodsPic == null){
                throw new AppException("goodsPic save error!");
            }
            if(goodsPic != null){
                if(goodsPic.getId() != null && goodsPic.getId() > 0){
                    id = goodsPicMapper.update(goodsPic);
                } else {
                    id = goodsPicMapper.save(goodsPic);
                }

            }
        } catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw new AppException(e);
        }

        return id;
    }

    @Override
    public List<GoodsPic> queryPicList(Map<String, Object> search) {

        try {
            return goodsPicMapper.selectList(search);
        } catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw new AppException(e);
        }
    }

    @Override
    public long deletePic(Long id) {
        long rows = 0;
        try {
            if(id == null || id <= 0){
                throw new AppException("goodsPic delete error!");
            } else {
                rows = goodsPicMapper.delete(id);
            }
        } catch(Exception e) {
            logger.error(e.getMessage(),e);
            throw new AppException(e);
        }

        return rows;
    }
}
