import core.admin.dao.GoodsMapper;
import core.admin.dao.GoodsMessageMapper;
import core.admin.dao.GoodsPicMapper;
import core.admin.domain.Goods;
import core.admin.domain.GoodsMessage;
import core.admin.domain.GoodsPic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by zhang on 2017/3/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-config.xml")
public class goodsTest {
    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private GoodsPicMapper goodsPicMapper;

    @Resource
    private GoodsMessageMapper goodsMessageMapper;

    @Test
    public void insertGoods(){
        Goods goods = new Goods();
        goods.setGoodsName("name");
        goods.setGoodsUnit(1);
        goods.setGoodsPrice(1.12F);
        goods.setGoodsCount(0);
        goods.setGoodsDesc("ceshi");
        goods.setGoodsPic("/test/test.png");
        goods.setTypeId(0L);
        goods.setUserId(0L);
        goodsMapper.save(goods);
    }

    @Test
    public void insertGoodsPic(){
        GoodsPic goodsPic = new GoodsPic();
        goodsPic.setGoodsId(0L);
        goodsPic.setPicURL("/test/test.png");
        goodsPic.setPicDesc("测试图片描述");
        goodsPicMapper.save(goodsPic);
    }

    @Test
    public void insertGoodsMessage(){
        GoodsMessage goodsMessage = new GoodsMessage();
        goodsMessage.setContent("测试评论内容");
        goodsMessage.setGoodsId(0L);
        goodsMessage.setUserId(0L);
        goodsMessageMapper.save(goodsMessage);
    }
}
