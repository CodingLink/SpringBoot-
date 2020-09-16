package tech.codinglink.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.codinglink.demo.entity.OrdersInfo;
import tech.codinglink.demo.modle.BaseModle;
import tech.codinglink.demo.modle.OrdersModle;
import tech.codinglink.demo.modle.TodayModle;
import tech.codinglink.demo.service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/Orders")
public class OrdersController {
    @Autowired
    private OrderService orderService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession httpSession;

    public OrdersModle returnOrders(List<OrdersInfo> ordersInfos){
        if(ordersInfos!=null){
            return new OrdersModle(0,"orders success",ordersInfos);
        }
        return new OrdersModle(1,"orders error",null);
    }

    public TodayModle returnToday(List<OrdersInfo> ordersInfos){
        if(ordersInfos!=null){
            return new TodayModle(0,"getToday success",ordersInfos);
        }
        return new TodayModle(1,"getToday error",null);
    }

    /**
     * 返回所有订单信息
     */
    @RequestMapping("/getAllOrders")
    @ResponseBody
    public OrdersModle getAllOrders(){
        return returnOrders(orderService.getAllOrders());
    }

    /**
     * 显示今日总营业额
     */
    @RequestMapping("/getToday")
    @ResponseBody
    public TodayModle getToday() {
        return returnToday(orderService.getToday());
    }

    /**
     * 新增订单
     */
    @RequestMapping("/addOrder")
    @ResponseBody
    public BaseModle addOrder() {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Integer uid = Integer.valueOf(request.getParameter("uid"));
        Integer gid = Integer.valueOf(request.getParameter("gid"));
        Integer num = Integer.valueOf(request.getParameter("num"));

        if (orderService.addOrder(id, uid, gid, num)){
            return new BaseModle(0,"订单添加成功",1);
        }
        return new BaseModle(1,"订单添加失败",0);
    }

    /**
     * 修改订单
     */
    @RequestMapping("/updateOrder")
    @ResponseBody
    public BaseModle updateOrder(){
        Integer id = Integer.valueOf(request.getParameter("id"));
        Integer uid = Integer.valueOf(request.getParameter("uid"));
        Integer gid = Integer.valueOf(request.getParameter("gid"));
        Integer num = Integer.valueOf(request.getParameter("num"));

        if(orderService.updateGood(uid,gid,num,id)){
            return new BaseModle(0,"订单修改成功",1);
        }
        return new BaseModle(1,"订单修改失败",0);
    }

    /**
     * 通过id删除订单
     */
    @RequestMapping("/deleteOrderById")
    @ResponseBody
    public BaseModle deleteOrderById(){
        Integer id = Integer.valueOf(request.getParameter("id"));
        if(orderService.deleteOrderById(id)){
            return new BaseModle(0,"订单删除成功",1);
        }
        return new BaseModle(1,"订单删除失败",0);
    }
}
