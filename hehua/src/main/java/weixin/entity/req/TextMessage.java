package weixin.entity.req;

/**
 * Created by Administrator on 2016/7/13.
 * IntelliJ IDEA 2016 of gzcss
 */
public class TextMessage extends BaseMessage {
    // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
