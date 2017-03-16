package core.admin.domain;

public class PersonNetWork {
    private static final long serialVersionUID = 1L;

        private Integer pid;        //  编号

        private Integer indentNum  ;            //  订单总数

        private Double    BackMoney;             //  回款

        private Double    costMoney;                   //  成本


    public PersonNetWork(Integer pid, Integer indentNum, Double backMoney, Double costMoney) {
        this.pid = pid;
        this.indentNum = indentNum;
        BackMoney = backMoney;
        this.costMoney = costMoney;
    }

    public PersonNetWork() {

    }

    @Override
    public String toString() {
        return "PersonNetWork{" +
                "pid=" + pid +
                ", indentNum=" + indentNum +
                ", BackMoney=" + BackMoney +
                ", costMoney=" + costMoney +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getIndentNum() {
        return indentNum;
    }

    public void setIndentNum(Integer indentNum) {
        this.indentNum = indentNum;
    }

    public Double getBackMoney() {
        return BackMoney;
    }

    public void setBackMoney(Double backMoney) {
        BackMoney = backMoney;
    }

    public Double getCostMoney() {
        return costMoney;
    }

    public void setCostMoney(Double costMoney) {
        this.costMoney = costMoney;
    }
}
