package weixin.entity.req;

/**
 * Created by Administrator on 2017/7/8.
 * IntelliJ IDEA 2017 of gzcss
 */
public class TextCardMessage  extends BaseMsg  {

    public TextCard getTextcard() {
        return textcard;
    }

    public void setTextcard(TextCard textcard) {
        this.textcard = textcard;
    }

    private TextCard textcard;
}
