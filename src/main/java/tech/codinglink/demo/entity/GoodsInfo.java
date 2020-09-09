package tech.codinglink.demo.entity;

/**
 * 仓库物品实体类
 */
public class GoodsInfo {
    private Integer gid;
    private String gname;
    private double price;
    private String description;
    private Integer num;

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", num=" + num +
                '}';
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
