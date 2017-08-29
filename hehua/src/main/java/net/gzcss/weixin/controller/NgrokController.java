package net.gzcss.weixin.controller;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import net.gzcss.weixin.service.WeixinCoreService;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/6/17.
 * IntelliJ IDEA 2016 of gzcss
 */
@Controller
@RequestMapping(value = "/ngrok")
public class NgrokController {

    private String token = "Jww0d927xKE";//lightwei
    private String encodingAESKey = "YGfY8VuHtULVr86PCs7YsPeLqtlKiyj9VNVVnh0Gyu9";//Qy7kU13sYaWkqQ8bzJotowHpsxWc2tRViJhW6xrL1JA
    private String corpId ="wxa0e7e835a070c06e";// "wxa0e7e835a070c06e"; //你的企业号ID


    @ResponseBody
    @RequestMapping(value = "/ngrok.do", method = RequestMethod.GET)
    public void getDomainGet(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String msg_signal = request.getParameter("signature");

        String msg_signature = request.getParameter("msg_signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        String msgSecurity = null;
        PrintWriter out = response.getWriter();
        try {
            WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(token, encodingAESKey, corpId);
            msgSecurity = wxcpt.VerifyURL(msg_signature, timestamp, nonce, echostr);
            System.out.printf("msg:" + msgSecurity);
        } catch (AesException e) {
            e.printStackTrace();
        } finally {
        }
        if (msgSecurity == null) {
            msgSecurity = token;
        }

        System.out.println("request=" + request.getRequestURL());
        out.write(msgSecurity);
        out.close();

    }


    @ResponseBody
    @RequestMapping(value = "/ngrok.do", method = RequestMethod.POST)
    public void getDomainPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 微信加密签名
        String msg_signature = request.getParameter("msg_signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");

        //从请求中读取整个post数据
        InputStream inputStream = request.getInputStream();
        String postData = IOUtils.toString(inputStream, "UTF-8");
        System.out.println(postData);

        String msg = "";
        WXBizMsgCrypt wxcpt = null;
        try {
            wxcpt = new WXBizMsgCrypt(token, encodingAESKey, corpId);
            //解密消息
            msg = wxcpt.DecryptMsg(msg_signature, timestamp, nonce, postData);
        } catch (AesException e) {
            e.printStackTrace();
        }
        System.out.println("msg=" + msg);

        // 调用核心业务类接收消息、处理消息
        String respMessage = WeixinCoreService.processRequest(msg);
        System.out.println("respMessage=" + respMessage);

        String encryptMsg = "";
        try {
            //加密回复消息
            encryptMsg = wxcpt.EncryptMsg(respMessage, timestamp, nonce);
        } catch (AesException e) {
            e.printStackTrace();
        }

        // 响应消息
        PrintWriter out = response.getWriter();
        out.print(encryptMsg);
        out.close();
    }

    @ResponseBody
    @RequestMapping(value = "/ngrok4.do", method = RequestMethod.GET)
    public String getSendMsg(HttpServletRequest request,String userid,String orderId,String content) {

        // 微信加密签名
        String msg_signature = request.getParameter("msg_signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        WXBizMsgCrypt wxcpt = null;

        String encryptMsg = "";
        try {
            wxcpt = new WXBizMsgCrypt(token, encodingAESKey, corpId);
            //加密回复消息
            String respMessage = "good love";
            encryptMsg = wxcpt.EncryptMsg(respMessage, timestamp, nonce);
        } catch (AesException e) {
            e.printStackTrace();
        }
        return encryptMsg;

    }

}
