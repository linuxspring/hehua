package unit.weixin.menu;

import weixin.api.wxurl;
import weixin.cert.AccessToken;
import weixin.utils.WeixinUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/4/19.
 * IntelliJ IDEA 2017 of gzcss
 */
public class oauthTest {
    private static Logger log = LoggerFactory.getLogger(oauthTest.class);


    public String getCode() {
        // authsucc_url
        return "";
    }

    public static void main(String[] args) {
        String appId = "wx9712284c60e6fdc3";
        // 第三方用户唯一凭证密钥
        String appSecret = "8-nT6zkxU5rCxT-p9Zg2O1U15HTinl4ETjW5O9c5JVAKU_MSxbZa7cCPz5_IrSWf";

        // 调用接口获取access_token
        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

        if (null != at) {
            // 调用接口创建菜单

            String redirect_uri = "http://172.16.1.18/ydyw/index.html";
            String scope = "snsapi_base";
            String agentid = "3";
            String state = "xiaobao";
            // 拼装创建菜单的url
            String url = wxurl.authorize_url.replace("CORPID", appId).replace("REDIRECT_URI", redirect_uri).replace("AGENTID", agentid).replace("STATE", state);
            int result = WeixinUtil.oAuth(url);

            // 判断菜单创建结果
            if (0 == result)
                log.info("oauth成功！");
            else
                log.info("oauth失败，错误码：" + result);
        }
    }
}
