package core.admin.domain;

/**
 * 商品实体
 * Created by zhang on 2017/3/17.
 */
public class Goods {

    private static final long serialVersionUID = 1L;

    private Long id;//商品id
    private String goodsName;//商品名称
    private String goodsDesc;//商品描述
    private String goodsPic;//商品的图片路径
    private Float goodsPrice;//商品单价
    private Integer goodsUnit;//数量单位 1:个 2:袋 3:盒 4:箱 5:桶6:件
    private Integer goodsCount;//商品数量
    private Long userId;//卖家的id

    private NetworkUser networkUser;//卖家实体

    private Long typeId;//商品所属的种类id

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public NetworkUser getNetworkUser() {
        return networkUser;
    }

    public void setNetworkUser(NetworkUser networkUser) {
        this.networkUser = networkUser;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    public Float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(Integer goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
