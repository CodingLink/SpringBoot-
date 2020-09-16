package tech.codinglink.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import tech.codinglink.demo.entity.OrdersInfo;

import java.util.Date;
import java.util.List;

@Component
public interface OrderMapper {
    /**
     * 获取所有订单
     */
    @Select("select t1.id,t1.uid,t3.name,t1.gid,t2.gname,t2.price,t1.num,t2.price*t1.num total,t1.date from orders t1,goods t2,customs t3 where t1.gid=t2.gid and t1.uid=t3.uid;")
    List<OrdersInfo> getAllOrders();

    /**
     * 获取当日总营业额
     */
    @Select("select sum(t2.price*t1.num) total from orders t1,goods t2 where t1.gid=t2.gid and now()")
    List<OrdersInfo> getToday();

    /**
     *添加订单
     */
    @Insert("insert into orders values(#{id},#{uid},#{gid},#{num},#{date})")
    int addOrder(Integer id, Integer uid, Integer gid, Integer num, Date date);

    /**
     * 修改订单
     */
    @Update("update goods set uid=#{uid},gid=#{gid},num=#{num},date=now() where id=#{id}")
    int updateOrder(Integer uid,Integer gid,Integer num,Integer id);

    /**
     * 删除订单
     */
    @Delete("delete from orders where id=#{id}")
    int deleteOrderById(Integer id);
}
