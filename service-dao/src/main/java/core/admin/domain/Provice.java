package core.admin.domain;

public class Provice {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer pid;
    private String name;
    private Integer display;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "Provice{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", display=" + display +
                '}';
    }
}
