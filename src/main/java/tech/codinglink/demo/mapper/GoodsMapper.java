package tech.codinglink.demo.mapper;

/**
 * goods操作类
 */

import org.apache.ibatis.annotations.Select;
import tech.codinglink.demo.entity.GoodsInfo;

import java.util.List;

public interface GoodsMapper {
    //获取所有商品
    @Select("select * from goods")
    public List<GoodsInfo> getAllGoods();
}
