package tech.codinglink.demo.modle;

/**
 * 用户表Json封装类
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.codinglink.demo.entity.CustomsInfo;

import java.util.List;


public class CustomsModle extends BaseModle{
    @JsonProperty("data")
    List<CustomsInfo> data;

    public CustomsModle(int code,String msg,List<CustomsInfo> customsInfos){
        this.code=code;
        this.msg=msg;
        this.count=customsInfos.size();
        this.data=customsInfos;
    }
}
