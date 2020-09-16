package tech.codinglink.demo.entity;

/**
 * 用户表实体类
 */


public class CustomsInfo {
    private Integer uid;
    private String name;
    private String phone;

    public CustomsInfo(Integer uid,String name, String phone) {
        this.uid=uid;
        this.name=name;
        this.phone=phone;
    }
    public CustomsInfo(){}

    @Override
    public String toString() {
        return "CustomsInfo{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
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
}
