package weixin.entity.req;

/**
 * Created by Administrator on 2017/4/28.
 * IntelliJ IDEA 2017 of gzcss
 */
public class TextMsg extends BaseMsg{
    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Text text;
}
