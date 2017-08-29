package weixin.api;

/**
 * Created by Administrator on 2017/4/24.
 * IntelliJ IDEA 2017 of gzcss
 */
public class wxurl {

    /**
     * 成员关注企业号
     */
    public static String authsucc_url = "https://qyapi.weixin.qq.com/cgi-bin/user/authsucc?access_token=ACCESS_TOKEN&userid=USERID";
    public static String authorize_url  ="https://open.weixin.qq.com/connect/oauth2/authorize?appid=CORPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&agentid=AGENTID&state=STATE#wechat_redirect";
    public static String getuserinfo_url  ="https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=ACCESS_TOKEN&code=CODE";
    public static String getuserdetail_url  ="https://qyapi.weixin.qq.com/cgi-bin/user/getuserdetail?access_token=ACCESS_TOKEN";
    public static String sendMsg_url  ="https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN";

    /**
     * 通过userid来取得用户的基本信息
     * 须要token
     */
    public static String getuser_url  ="https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&userid=USERID";


}
