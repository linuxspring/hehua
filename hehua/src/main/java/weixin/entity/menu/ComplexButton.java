package weixin.entity.menu;

/**
 * Created by Administrator on 2016/7/14.
 * IntelliJ IDEA 2016 of gzcss
 */
public class ComplexButton extends Button {
    private Button[] sub_button;

    public Button[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }
}
