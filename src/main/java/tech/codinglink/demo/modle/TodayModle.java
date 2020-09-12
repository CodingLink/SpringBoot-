package tech.codinglink.demo.modle;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.codinglink.demo.entity.OrdersInfo;

import java.util.List;


public class TodayModle extends BaseModle{
    @JsonProperty("data")
    public List<OrdersInfo> data;

    public TodayModle(int code,String msg,List<OrdersInfo> ordersInfos){
        this.code=code;
        this.msg=msg;
        this.count=ordersInfos.size();
        this.data=ordersInfos;
    }
}
