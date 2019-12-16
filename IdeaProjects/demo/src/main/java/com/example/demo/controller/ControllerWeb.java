package com.example.demo.controller;


import com.example.demo.MapperP.map;
import com.example.demo.pojo.Bill;
import com.example.demo.pojo.student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ControllerWeb{
    @Autowired
    public map map;
    BeanFactory
    @RequestMapping(value = "/")
    public String maininterface() {
        return "login";
    }
    @RequestMapping(value = "loginuser",method = RequestMethod.POST)
    @ResponseBody
    public int retruned(@RequestParam("username") String username,@RequestParam("password")String password) {
        return map.select(username,password) ;
    }
    @RequestMapping("left")
    public String left(){
        return "left";
    }
    @RequestMapping("users")
    public String users(){
        return "users";
    }
    @RequestMapping("select")
    @ResponseBody
    public student select(@RequestParam("name")String name){

        return map.selectstudent(name);

    }
    @RequestMapping("bill")
    public String bill(){
        return "bill";
    }
    @RequestMapping("selectbill")
    @ResponseBody
    public List<Bill> selectbill(@RequestParam("name") String name){
        System.out.println(name);
return map.selectbill(name);

    }
    @RequestMapping("delectbill")
    @ResponseBody
    public Boolean delectbill(@RequestParam("id") int id){

        return map.delectbill(id);
    }








}
