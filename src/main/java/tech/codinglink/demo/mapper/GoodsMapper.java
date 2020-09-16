package tech.codinglink.demo.mapper;

/**
 * goods操作类
 */

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;


import org.apache.ibatis.annotations.Select;
import tech.codinglink.demo.entity.GoodsInfo;

import java.util.List;

@Component
public interface GoodsMapper {
    //获取所有商品
    @Select("select * from goods")
    List<GoodsInfo> getAllGoods();

    //新增商品
    @Insert("insert into goods values(#{gid},#{gname},#{price},#{description},#{num})")
    int addGood(Integer gid,String gname,Double price,String description,Integer num);

    //修改商品
    @Update("update goods set gname=#{gname},price=#{price},description=#{description},num=#{num} where gid=#{gid}")
    int updateGood(String gname,Double price,String description,Integer num,Integer gid);

    //删除商品
    @Delete("delete from goods where gid=#{gid}")
    int deleteGoodByGId(Integer gid);

}
