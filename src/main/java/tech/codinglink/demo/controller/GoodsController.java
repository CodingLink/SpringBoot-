package tech.codinglink.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.codinglink.demo.entity.GoodsInfo;
import tech.codinglink.demo.modle.BaseModle;
import tech.codinglink.demo.modle.GoodsModle;
import tech.codinglink.demo.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/Goods")
public class GoodsController extends HttpServlet {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession httpSession;

    public GoodsModle returnGoods(List<GoodsInfo> goodsInfos){
        if(goodsInfos!=null){
            return new GoodsModle(0,"goods success",goodsInfos);
        }
        return new GoodsModle(1,"goods error",null);
    }

    /**
     * 返回所有商品信息
     */
    @RequestMapping("/getAllGoods")
    @ResponseBody
    public GoodsModle getAllGoods(){
        return returnGoods(goodsService.getAllGoods());
    }

    /**
     * 添加商品
     */
    @RequestMapping("/addGood")
    @ResponseBody
    public BaseModle addGood(){
        Integer gid= Integer.valueOf(request.getParameter("gid"));
        String gname=request.getParameter("gname");
        Double price= Double.valueOf(request.getParameter("price"));
        String description=request.getParameter("description");
        Integer num= Integer.valueOf(request.getParameter("num"));

        if(goodsService.addGood(gid,gname,price,description,num)){
            return new BaseModle(0,"商品添加成功",1);
        }
        return new BaseModle(1,"商品添加失败",0);
    }

    /**
     * 修改商品
     */
    @RequestMapping("/updateGood")
    @ResponseBody
    public BaseModle updateGood(){
        Integer gid= Integer.valueOf(request.getParameter("gid"));
        String gname = request.getParameter("gname");
        Double price = Double.valueOf(request.getParameter("price"));
        String description = request.getParameter("description");
        Integer num = Integer.valueOf(request.getParameter("num"));

        if(goodsService.updateGood(gname,price,description,num,gid)){
            return new BaseModle(0,"商品修改成功",1);
        }
        return new BaseModle(1,"商品修改失败",0);
    }

    /**
     * 通过Gid删除商品
     */
    @RequestMapping("/deleteGoodByGid")
    @ResponseBody
    public BaseModle deleteGoodByGid(){
        Integer gid = Integer.valueOf(request.getParameter("gid"));
        if(goodsService.deleteGoodByGid(gid)){
            return new BaseModle(0,"商品删除成功",1);
        }
        return new BaseModle(1,"商品删除失败",0);
    }
}
