package core.admin.domain;

/**
 * 商品图片
 * Created by zhang on 2017/3/17.
 */
public class GoodsPic {
    private static final long serialVersionUID = 1L;

    private Long id;//图片id
    private String picURL;//图片路径
    private Long goodsId;//商品id
    private String picDesc;//图片描述

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getPicDesc() {
        return picDesc;
    }

    public void setPicDesc(String picDesc) {
        this.picDesc = picDesc;
    }
}
