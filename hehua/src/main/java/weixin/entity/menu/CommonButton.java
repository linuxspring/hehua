package weixin.entity.menu;

/**
 * Created by Administrator on 2016/7/14.
 * IntelliJ IDEA 2016 of gzcss
 */
public class CommonButton extends Button {
    private String type;
    private String key;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}