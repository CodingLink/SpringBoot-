package tech.codinglink.demo.entity;

import java.sql.Date;

/**
 * Order订单实体类
 */
public class OrdersInfo {
    private Integer id;
    private Integer uid;
    private String name;
    private Integer gid;
    private String gname;
    private Double price;
    private Integer num;
    private Double total;
    private Date date;

    @Override
    public String toString() {
        return "OrdersInfo{" +
                "id=" + id +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", gid=" + gid +
                ", gname='" + gname + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", total=" + total +
                ", date=" + date +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}