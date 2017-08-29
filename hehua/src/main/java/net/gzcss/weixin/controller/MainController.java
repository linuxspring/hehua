package net.gzcss.weixin.controller;

import weixin.api.Constants;
import weixin.cert.AccessToken;
import weixin.utils.WeixinUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2016/6/17.
 */
@Controller
@RequestMapping("case")
public class MainController {

    @ResponseBody
    @RequestMapping(value = "wait.do",method = RequestMethod.GET)
    public String getWaitting(String name){
        return  "index";
    }


    @ResponseBody
    @RequestMapping(value = "done.do",method = RequestMethod.GET)
    public String getFinish(String name){
        System.out.printf("xixio done");
        return  "done";
    }

    /**
     * 拼接网页授权链接
     * 此处步骤也可以用页面链接代替
     * @return
     */
    @RequestMapping(value = { "/oauth2wx.do" })
    public String Oauth2API(HttpServletRequest request){
        //获取项目域名
        String reqUrl =request.getLocalAddr();
        //拼接微信回调地址
        String backUrl ="http://" + reqUrl + "/oauth2me.do";
        backUrl="http://wechat.020wy.cn/wx/case/oauth2me.do";
        String redirect_uri = "";
        try {
            redirect_uri = java.net.URLEncoder.encode(backUrl, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String CORPID="wx9712284c60e6fdc3";
        String oauth2Url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + CORPID + "&redirect_uri=" + redirect_uri
                + "&response_type=code&scope=snsapi_userinfo&state=sunlight#wechat_redirect";
        return "redirect:" + oauth2Url;
    }

    /**
     * 授权回调请求处理
     * @return
     */
    @RequestMapping(value = { "/oauth2me.do" })
    public String oAuth2Url(HttpServletRequest request, @RequestParam String code, HttpServletResponse response) throws UnsupportedEncodingException {
        AccessToken accessToken = WeixinUtil.getAccessToken(Constants.CORPID, Constants.SECRET);
        HttpSession session = request.getSession();
        if (accessToken != null && accessToken.getToken() != null) {
            String Userid = getMemberGuidByCode(accessToken.getToken(), code, Constants.AGENTID);
            //String  result = WeixinUtil.oAuth2GetUserByUserId(accessToken.getToken(), Userid, Constants.AGENTID);
            Userid = "huangxiaobo";
            if (Userid != null) {
                session.setAttribute("UserId", Userid);

                String currentlogincookie = "{'username':'" + Userid + "'}";
                System.out.println(currentlogincookie + "****************");
                Cookie cookie = new Cookie("currentlogincookie", URLEncoder.encode(currentlogincookie, "UTF-8"));
                response.addCookie(cookie);
            }
        }
        // 这里简单处理,存储到session中
        return "redirect:"+"http://172.16.1.18/wxtest/main.html?sid=esb4";
    }
    /**
     * 调用接口获取用户信息
     *
     * @param token
     * @param code
     * @param agentId
     * @return
     */
    public String getMemberGuidByCode(String token, String code, int agentId) {
        System.out.println("code==" + code + "\ntoken=" + token + "\nagentid=" + agentId);
        String  userid = WeixinUtil.oAuth2GetUserByCode(token, code, agentId);
        //userid="xiehongwei";

        //System.out.println("result=" + result);
        //if (result.getErrcode() == "0") {
        //    if (result.getObj() != null) {
        //        // 此处可以通过微信授权用code还钱的Userid查询自己本地服务器中的数据
        //        return result.getObj();
        //    }
        //}
        return userid;
    }

    @ResponseBody
    @RequestMapping(value = "loginwechat.do",method = RequestMethod.GET)
    public String loginWechatByCode(String code) {
        AccessToken accessToken=WeixinUtil.getAccessToken("wx0c775cf3820e93b9","xUNmN77f1xjmyv6ntdxSRTa9DBgi4laYFMNdArdT29Y");
        String token=accessToken.getToken();
        String  userid = WeixinUtil.oAuth2GetUserByCode(token, code, 5);
        //userid="xiehongwei";

        //System.out.println("result=" + result);
        //if (result.getErrcode() == "0") {
        //    if (result.getObj() != null) {
        //        // 此处可以通过微信授权用code还钱的Userid查询自己本地服务器中的数据
        //        return result.getObj();
        //    }
        //}
        return "{\"userid\":"+userid+"}";
    }
}
