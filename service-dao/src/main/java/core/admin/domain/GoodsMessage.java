package core.admin.domain;

/**
 * 商品评论
 * Created by zhang on 2017/3/17.
 */
public class GoodsMessage {
    private static final long serialVersionUID = 1L;
    private Long id;//评论id
    private String content;//评论内容
    private Long userId;//评论人id
    private Long goodsId;//商品id
    private NetworkUser networkUser;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NetworkUser getNetworkUser() {
        return networkUser;
    }

    public void setNetworkUser(NetworkUser networkUser) {
        this.networkUser = networkUser;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
