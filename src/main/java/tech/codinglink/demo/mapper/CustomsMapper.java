package tech.codinglink.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
    public List<CustomsInfo> getAllCustoms();

    //通过uid查找用户
    @Select("select * from customs where uid=#{uid}")
    public List<CustomsInfo> getCustomsByUid(@Param("uid") Integer uid);

    @Select("select * from customs where name=#{name}")
    public List<CustomsInfo> getCustomsByName(@Param("name") String name);

    @Select("select * from customs where phone=#{phone}")
    public List<CustomsInfo> getCustomsByPhone(@Param("phone") String phone);

    @Insert("insert into customs value(#{uid},#{name},#{phone},#{bir}")
    int addCustoms(CustomsInfo customsInfo);

    @Delete("delete from customs where uid=#{uid}")
    public int deleteCustomsByUid(Integer uid);
}
