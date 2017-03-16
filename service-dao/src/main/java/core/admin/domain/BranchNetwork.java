package core.admin.domain;

/**
 * 网点实体
 * @table  branchNetwork
 */
public class BranchNetwork {
	private static final long serialVersionUID = 1L;

	
    private Integer id;//主键
    
    private String name;//网点名称
    
    private String provCode;//所在省
    
    private String cityCode;//所在市
    
    private String areaCode;//所在地区
    
    private String contactUser;//联系人名称
    
    private String mobile;//联系电话
    
    private Integer level;//服务等级

    private Integer status;//是否启用 1.启用 2.未启用
    
    private Integer parentId;//上级网点

    private String address;//地址

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
	public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
	public String getProvCode() {
        return this.provCode;
    }

    public void setProvCode(String provCode) {
        this.provCode = provCode;
    }
	public String getCityCode() {
        return this.cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
	public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
	public String getContactUser() {
        return this.contactUser;
    }

    public void setContactUser(String contactUser) {
        this.contactUser = contactUser;
    }
	public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
	public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
	public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

}