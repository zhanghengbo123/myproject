package core.admin.domain;

import java.util.Date;

/**
 * 线路需求实体
 * @table  needs
 */
public class Needs  {
	private static final long serialVersionUID = 1L;

	
    private Long id;//主键
    
    private String fromCity;//发货城市
    
    private String toCity;//收货城市
    
    private String fromTime;//发货时间
    
    private String toTime;//到货时间
    
    private String goodsName;//货物名称
    
    private String description;//描述
    
    private Long createTime;//添加时间
    
    private Long userId;//添加人id
    
    private Integer status;//状态1已处理，0未处理
    

	
	public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	public String getFromCity() {
        return this.fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }
	public String getToCity() {
        return this.toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }
	public String getFromTime() {
        return this.fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }
	public String getToTime() {
        return this.toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }
	public String getGoodsName() {
        return this.goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
	public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
	public Long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
	public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
	public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}