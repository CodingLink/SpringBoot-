package tech.codinglink.demo.entity;

/**
 * 用户表实体类
 */

import java.util.Date;

public class CustomsInfo {
    private Integer uid;
    private String name;
    private String phone;
    private Date bir;

    @Override
    public String toString() {
        return "CustomsInfo{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", bir=" + bir +
                '}';
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }
}
