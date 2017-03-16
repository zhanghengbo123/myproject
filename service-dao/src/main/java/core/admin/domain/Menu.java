package core.admin.domain;

import java.util.List;

/**
 * 后台菜单实体
 * Created by pop on 16/1/18.
 */
public class Menu {

    private Integer id;
    private String name;
    private String url;
    private String pid;
    private List<Menu> pidlist;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<Menu> getPidlist() {
        return pidlist;
    }

    public void setPidlist(List<Menu> pidlist) {
        this.pidlist = pidlist;
    }
}
