package a816.android.soldesk.rssfeeder;

/**
 * Created by soldesk on 2016-09-09.
 */
public class CategoryInfo {
    private String title;
    private String url;

    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    private String encode;

    public CategoryInfo(String title, String url, String encode) {
        this.title = title;
        this.url = url;
        this.encode = encode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

