package weixin.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;


import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import weixin.api.wxurl;
import weixin.cert.AccessToken;
import weixin.cert.MyX509TrustManager;
import weixin.entity.menu.Menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 公众平台通用接口工具类
 *
 * @author liuyq
 * @date 2013-08-09
 */
public class WeixinUtil {
    private static Logger log = LoggerFactory.getLogger(WeixinUtil.class);
    // 获取access_token的接口地址（GET） 限200（次/天）
    public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    public final  static  String _access_token_url="https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=companyid&corpsecret=companysecrect";
    /**
     * 获取access_token
     *
     * @param appid     凭证
     * @param appsecret 密钥
     * @return
     */
    public static AccessToken getAccessToken(String appid, String appsecret) {
        AccessToken accessToken = null;

        String requestUrl = _access_token_url.replace("companyid", appid).replace("companysecrect", appsecret);
        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
        // 如果请求成功
        if (null != jsonObject) {
            try {
                accessToken = new AccessToken();
                accessToken.setToken(jsonObject.getString("access_token"));
                accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
            } catch (JSONException e) {
                accessToken = null;
                // 获取token失败
                log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return accessToken;
    }

    // 菜单创建（POST） 限100（次/天）
    public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    public  static  String _menu_create_url="https://qyapi.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN&agentid=AGENTID";

    public  static  String _delete_menu_url="https://qyapi.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN&agentid=AGENTID";

    public  static  String _oauth_url="https://qyapi.weixin.qq.com/cgi-bin/service/get_login_url?access_token=ACCESS_TOKEN&agentid=AGENTID";


    public static int oAuth(String url) {
        int result = 0;
        JSONObject jsonObject = httpRequest(url, "POST", null);

        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {
                result = jsonObject.getInt("errcode");
                log.error("oauth失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }

        return result;
    }

    /**
     * 创建菜单
     *
     * @param menu        菜单实例
     * @param accessToken 有效的access_token
     * @return 0表示成功，其他值表示失败
     */
    public static int createMenu(Menu menu, String accessToken) {
        int result = 0;

        // 拼装创建菜单的url
        String url = _menu_create_url.replace("ACCESS_TOKEN", accessToken).replace("AGENTID","3");
        // 将菜单对象转换成json字符串
        String jsonMenu = JSONObject.fromObject(menu).toString();
        // 调用接口创建菜单
        JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);

        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {
                result = jsonObject.getInt("errcode");
                log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }

        return result;
    }

    public static  int deleteMenu(String accessToken){
        int result=0;
        String url =_delete_menu_url.replace("ACCESS_TOKEN", accessToken).replace("AGENTID","8");
        JSONObject jsonObject = httpRequest(url, "GET", null);
        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {
                result = jsonObject.getInt("errcode");
                log.error("delete menu error errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return result;
    }

    public static String oAuth2GetUserByCode(String accessToken, String code, int agentId) {
        String result=null;
        String url =wxurl.getuserinfo_url.replace("ACCESS_TOKEN", accessToken).replace("CODE",code);
        JSONObject jsonObject = httpRequest(url, "GET", null);
        if (null != jsonObject) {
            if (null!= jsonObject.getString("UserId")) {
                result = jsonObject.getString("UserId");
            }else{
                log.error("取得用户userid error errcode:{} errmsg:{}", jsonObject.getString("UserId"), jsonObject.getString("errmsg"));
            }
        }
        return result;
    }
    public static String oAuth2GetUserByUserId(String accessToken, String UserId, int agentId) {
        String result=null;
        String url =wxurl.getuser_url.replace("ACCESS_TOKEN", accessToken).replace("USERID",UserId);
        JSONObject jsonObject = httpRequest(url, "GET", null);
        if (null != jsonObject) {
            if (0== jsonObject.getInt("errcode")) {
                result = jsonObject.toString();
            }else{
                log.error("取得用户userid error errcode:{} errmsg:{}", jsonObject.getString("UserId"), jsonObject.getString("errmsg"));
            }
        }
        return result;
    }

    /**
     * 发起https请求并获取结果
     *
     * @param requestUrl    请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr     提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
            log.error("Weixin server connection timed out.");
        } catch (Exception e) {
            log.error("https request error:{}", e);
        }
        return jsonObject;
    }


    public static String sendMsg(String url,String msg) {
        String result=null;
        JSONObject jsonObject = httpRequest(url, "POST", msg);
        if (null != jsonObject) {
            if (0== jsonObject.getInt("errcode")) {
                result = jsonObject.toString();
            }else{
                log.error("取得用户userid error errcode:{} errmsg:{}", jsonObject.getString("UserId"), jsonObject.getString("errmsg"));
            }
        }
        return result;
    }
}