package tech.codinglink.demo.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import tech.codinglink.demo.entity.CustomsInfo;


import java.util.List;

/**
 * Customs表操作类
 */
@Component
public interface CustomsMapper {

    //查询所有用户
    @Select("select * from customs")
    List<CustomsInfo> getAllCustoms();

    //通过uid查找用户
    @Select("select * from customs where uid=#{uid}")
    List<CustomsInfo> getCustomsByUid(@Param("uid") Integer uid);

    @Select("select * from customs where name=#{name}")
    List<CustomsInfo> getCustomsByName(@Param("name") String name);

    @Select("select * from customs where phone=#{phone}")
    List<CustomsInfo> getCustomsByPhone(@Param("phone") String phone);

    //新增用户信息
    @Insert("insert into customs values(#{uid},#{name},#{phone})")
    int addCustom(CustomsInfo customsInfo);

    //通过uid删除用户信息
    @Delete("delete from customs where uid=#{uid}")
    int deleteCustomByUid(Integer uid);

    //修改用户信息
    @Update("update customs set name=#{name} ,phone=#{phone} where uid=#{uid};")
    int updateCustom(String name,String phone,Integer uid);
}
