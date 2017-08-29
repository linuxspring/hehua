package weixin.entity.req;

/**
 * Created by Administrator on 2017/7/8.
 * IntelliJ IDEA 2017 of gzcss
 */
public class TextCard {
    public String title;
    private String description;
    private String url;

    public String getBtntxt() {
        return btntxt;
    }

    public void setBtntxt(String btntxt) {
        this.btntxt = btntxt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String btntxt;
}
