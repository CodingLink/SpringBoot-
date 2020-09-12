package tech.codinglink.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.codinglink.demo.entity.OrdersInfo;
import tech.codinglink.demo.mapper.OrderMapper;

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
}
