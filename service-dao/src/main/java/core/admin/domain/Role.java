package core.admin.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 角色实体
 */
public class Role {

    private Integer id;
    private String name;
    private String menus;

    private List<Long> menuIdList;

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

    public String getMenus() {
        return menus;
    }

    public void setMenus(String menus) {
        this.menus = menus;
    }

    public List<Long> getMenuList() {
        if(menus!=null && !"".equals(menus)){
            menuIdList = new ArrayList<Long>();
            for(String id : menus.split(",")){
                menuIdList.add(Long.valueOf(id));
            }
        }
        return menuIdList;
    }
}
