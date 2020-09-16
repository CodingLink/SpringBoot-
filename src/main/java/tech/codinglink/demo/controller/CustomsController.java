package tech.codinglink.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.codinglink.demo.entity.CustomsInfo;
import tech.codinglink.demo.modle.BaseModle;
import tech.codinglink.demo.modle.CustomsModle;
import tech.codinglink.demo.service.CustomsService;

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
@RequestMapping("/Customs")
public class CustomsController extends HttpServlet{
    @Autowired
    private CustomsService customsService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession httpSession;

    public CustomsModle returnCustoms(List<CustomsInfo> customsInfos){
        if(customsInfos!=null){
            return new CustomsModle(0,"customs success",customsInfos);
        }
        return new CustomsModle(1,"customs error",null);
    }
    /**
     * 返回所有用户的信息
     */
    @RequestMapping("/getAllCustoms")
    @ResponseBody
    public CustomsModle getAllCustoms(){

        return returnCustoms(customsService.getAllCustoms());
    }

    /**
     * 新增用户信息
     */
    @RequestMapping("/addCustom")
    @ResponseBody
    public BaseModle addCustom(){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Integer uid=Integer.valueOf(request.getParameter("uid"));
        String name=request.getParameter("name");
        String phone=request.getParameter("phone");
        String bir=request.getParameter("bir");

        if(customsService.addCustom(new CustomsInfo(uid,name,phone))){
            return  new BaseModle(0,"添加用户成功",1);
        }
        return new BaseModle(1,"添加用户失败",0);
    }

    /**
     * 删除用户信息
     */
    @RequestMapping("/deleteCustomByUid")
    @ResponseBody
    public BaseModle deleteCustomByUid(){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Integer uid= Integer.valueOf(request.getParameter("uid"));
        if(customsService.deleteCustomByUid(uid)){
            return new BaseModle(0,"删除用户成功",1);
        }
        return new BaseModle(1,"删除用户失败",0);
    }

    /**
     * 修改用户信息
     */
    @RequestMapping("/updateCustom")
    @ResponseBody
    public BaseModle updateCustom(){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Integer uid= Integer.valueOf(request.getParameter("uid"));
        String name=request.getParameter("name");
        String phone=request.getParameter("phone");
        if(customsService.updateCustom(name,phone,uid)){
            return new BaseModle(0,"修改用户成功",1);
        }
        return new BaseModle(1,"修改用户失败",0);
    }

}
