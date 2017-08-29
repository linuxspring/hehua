package weixin.cert;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


/**
 * Created by Administrator on 2016/7/14.
 * IntelliJ IDEA 2016 of gzcss
 */
public class MyX509TrustManager implements X509TrustManager {

    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }



    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}