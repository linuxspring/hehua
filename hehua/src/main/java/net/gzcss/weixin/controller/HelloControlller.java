package net.gzcss.weixin.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/16.
 */

@Controller
@RequestMapping(value = "/test")
public class HelloControlller {

    @ResponseBody
    @RequestMapping(value = "list.data",method = RequestMethod.GET)
    public String getList(String name,int id){
        System.out.printf("name:"+name);
        return "xiao"+name;
    }

    @ResponseBody
    @RequestMapping(value = "save.data",method = RequestMethod.GET)
    public String getListTo(String name,int id){
        Gson gson = new GsonBuilder().create();
        List<String> list =new ArrayList<String>();
        list.add("love");
        return gson.toJson(list);

    }

    @ResponseBody
    @RequestMapping(value = "saves.data",method = RequestMethod.GET)
    public String getListTos(String names,int id){
        Gson gson = new GsonBuilder().create();
        List<String> list =new ArrayList<String>();
        list.add("love");
        return gson.toJson(list);

    }

    @ResponseBody
    @RequestMapping(value = "add.data",method = RequestMethod.GET)
    public String getListsTo(String name,int id){
        Gson gson = new GsonBuilder().create();
        List<String> list =new ArrayList<String>();
        list.add("love");
        return gson.toJson(list);

    }

    @ResponseBody
    @RequestMapping(value = "new.data",method = RequestMethod.GET)
    public String getListTods(String name,int id){
        Gson gson = new GsonBuilder().create();
        List<String> list =new ArrayList<String>();
        list.add("love to china sss");
        return gson.toJson(list);

    }

    @ResponseBody
    @RequestMapping(value = "news.data",method = RequestMethod.GET)
    public String getupdateO(String name,int id){
        Gson gson = new GsonBuilder().create();
        List<String> list =new ArrayList<String>();
        list.add("love to china ssss");
        return gson.toJson(list);

    }

    @ResponseBody
    @RequestMapping(value = "ne.data",method = RequestMethod.GET)
    public String getUpdate(String name,int id){
        Gson gson = new GsonBuilder().create();
        List<String> list =new ArrayList<String>();
        list.add("love to china JRebel test");
        return gson.toJson(list);

    }

    @ResponseBody
    @RequestMapping(value = "nt.data",method = RequestMethod.GET)
    public String getUpdateAd(String name,int id){
        Gson gson = new GsonBuilder().create();
        List<String> list =new ArrayList<String>();
        list.add("love to china JRebel do it");
        for (int i = 0; i < 3; i++) {
            System.out.println("i");
            System.out.println("xixi");
        }
        return gson.toJson(list);

    }



    @ResponseBody
    @RequestMapping(value = "ads.data",method = RequestMethod.GET)
    public String getAds(String name,int id){
        Gson gson = new GsonBuilder().create();
        List<String> list =new ArrayList<String>();
        System.out.printf("all is good");
        System.out.printf("china is ood");
        for (int i = 0; i < 20; i++) {
            list.add(i+"xiao");
        }
        list.add("username");
        list.add("password");
        list.add("love to china JRebel do it");
        return gson.toJson(list);

    }


    @ResponseBody
    @RequestMapping(value = "/tel.do",method = RequestMethod.GET)
    public String getTelLinkman(String name,int id){
        Gson gson = new GsonBuilder().create();
        List<String> list =new ArrayList<String>();
        System.out.printf("all is good");
        System.out.printf("china is ood");
        for (int i = 0; i < 20; i++) {
            list.add(i+"xiao");
        }
        list.add("username");
        list.add("password");
        list.add("love to china JRebel do it");
        return gson.toJson(list);
    }
}
