import core.admin.dao.GoodsMapper;
import core.admin.domain.Goods;
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

}
