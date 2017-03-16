package core.admin.domain;

/**
 * Created by xianglong on 16/3/5.
 */
public class City {

    private String name;
    private Integer id;
    private Integer parentId;
    private Integer level;

    private String zip;

    private String areaCode;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", parentId=" + parentId +
                ", level=" + level +
                '}';
    }
}
