package tech.codinglink.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.codinglink.demo.entity.OrdersInfo;
import tech.codinglink.demo.mapper.OrderMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    private OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderMapper orderMapper){
        this.orderMapper=orderMapper;
    }

    /**
     * 显示所有订单的集合
     */
    public List<OrdersInfo> getAllOrders(){
        List<OrdersInfo> ordersInfos=orderMapper.getAllOrders();
        if(ordersInfos!=null){
            System.out.println(ordersInfos);
            return ordersInfos;
        }
        return null;
    }
    /**
     * 显示今日总营业额
     */
    public List<OrdersInfo> getToday() {
        List<OrdersInfo> ordersInfos = orderMapper.getToday();
        if (ordersInfos != null) {
            System.out.println(ordersInfos);
            return ordersInfos;
        }
        return null;
    }

    /**
     * 新增订单
     */
    public boolean addOrder(Integer id, Integer uid, Integer gid, Integer num){
        Date date= new java.sql.Date(new java.util.Date().getTime());
        if(orderMapper.addOrder(id, uid, gid, num,date)>0){
            return true;
        }
        return false;
    }

    /**
     * 修改订单
     */
    public boolean updateGood(Integer uid, Integer gid, Integer num, Integer id){
        if(orderMapper.updateOrder(uid, gid, num, id)>0) {
            return true;
        }
        return false;
    }

    /**
     * 删除订单
     */
    public boolean deleteOrderById(Integer id){
        if(orderMapper.deleteOrderById(id)>0){
            return true;
        }
        return false;
    }
}
