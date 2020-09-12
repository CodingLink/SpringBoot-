package tech.codinglink.demo.modle;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.codinglink.demo.entity.OrdersInfo;

import java.util.List;

public class OrdersModle extends BaseModle{
    @JsonProperty("data")
    List<OrdersInfo> data;

    public OrdersModle(int code,String msg,List<OrdersInfo> ordersInfos){
        this.code=code;
        this.msg=msg;
        this.count=ordersInfos.size();
        this.data=ordersInfos;
    }
}
