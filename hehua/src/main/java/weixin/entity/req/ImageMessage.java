package weixin.entity.req;

/**
 * Created by Administrator on 2016/7/13.
 * IntelliJ IDEA 2016 of gzcss
 */
public class ImageMessage extends BaseMessage {
    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}