package tech.codinglink.demo.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tech.codinglink.demo.entity.OrdersInfo;

import java.util.List;

@Component
public interface OrderMapper {
    /**
     * 获取所有订单
     */
    @Select("select t1.id,t1.uid,t3.name,t1.gid,t2.gname,t2.price,t1.num,t2.price*t1.num total,t1.date from orders t1,goods t2,customs t3 where t1.gid=t2.gid and t1.uid=t3.uid;")
    public List<OrdersInfo> getAllOrders();

    /**
     * 获取当日总营业额
     */
    @Select("select sum(t2.price*t1.num) total from orders t1,goods t2 where t1.gid=t2.gid and now()")
    public List<OrdersInfo> getToday();

}
