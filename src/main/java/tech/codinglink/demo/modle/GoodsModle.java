package tech.codinglink.demo.modle;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.codinglink.demo.entity.GoodsInfo;

import java.util.List;

/**
 * goods json 封装类
 */
public class GoodsModle extends BaseModle{
    @JsonProperty("data")
    List<GoodsInfo> data;

    public GoodsModle(int code,String msg,List<GoodsInfo> goodsInfos){
        this.code=code;
        this.msg=msg;
        this.count=goodsInfos.size();
        this.data=goodsInfos;
    }
}
