package unit.weixin.menu;

import net.sf.json.JSONObject;
import weixin.api.wxurl;
import weixin.cert.AccessToken;
import weixin.entity.req.*;
import weixin.utils.WeixinUtil;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2017/5/2.
 * IntelliJ IDEA 2017 of gzcss
 */
public class SendMsg {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String appId = "wx9712284c60e6fdc3";
        // 第三方用户唯一凭证密钥
        String appSecret = "8-nT6zkxU5rCxT-p9Zg2O1U15HTinl4ETjW5O9c5JVAKU_MSxbZa7cCPz5_IrSWf";
        appId = "wx0c775cf3820e93b9";
        appSecret = "SFEAtlCzIQKSRacLapMO38iMP04tjgRIFRaL2ofqmvi5XlkOXhdENNZlZl_wGJeR";
        // 调用接口获取access_token
        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);
        if (null != at) {

            TextMsg textMsg=new TextMsg();
            textMsg.touser = "xiaotolove";
            textMsg.msgtype = "text";
            textMsg.safe=0;
            textMsg.agentid=4;

            Text text=new Text();
            //text.content = MsgFormat.eventOrderPassMsgFormat("PM-031200-00338514","","","","");
            text.content=MsgFormat.eventFlowNodeMsgFormat("PM-031200-00338514","林毅豪","已分派");
            textMsg.text=text;

            TextCardMessage textCardMessage=new TextCardMessage();
            textCardMessage.touser="xiaotolove";
            textCardMessage.msgtype="textcard";
            textCardMessage.safe=0;
            textCardMessage.agentid=4;
            TextCard textCard=new TextCard();
            textCard.title="事件工单通知";
            String remark=MsgFormat.textCardMsg("PM-031200-00338514","林毅豪","已分派");
            textCard.setDescription("<div class=\"gray\">2016年9月26日</div> <div class=\"normal\">恭喜你抽中iPhone 7一台，领奖码：xxxx</div><div class=\"highlight\">请于2016年10月10日前联系行政同事领取</div>");
            //textCard.setBtntxt("工单详情");
            textCard.setUrl("https://www.baidu.com");
            textCardMessage.setTextcard(textCard);
            String jsonMsg = JSONObject.fromObject(textCardMessage).toString();

            // 拼装创建菜单的url
            String url = wxurl.sendMsg_url.replace("ACCESS_TOKEN", at.getToken());
            String result = WeixinUtil.sendMsg(url,jsonMsg);
            System.out.println("result = " + result);
        }

    }
}
