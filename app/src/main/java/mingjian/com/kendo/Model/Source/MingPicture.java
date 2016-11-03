package mingjian.com.kendo.Model.Source;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;

import java.util.List;

/**
 * Created by lzw on 15/8/25.
 */
@AVClassName("Picture")
public class MingPicture extends AVObject {
    public static final Creator CREATOR = AVObjectCreator.instance;

    public static final String WHO = "who";
    public static final String DESC = "desc";
    public static final String TYPE = "type";
    public static final String URL = "url";

    public MingPicture() {

    }

    public String getWho() {
        return getString(WHO);
    }

    public void setWho(String who) {
        put(WHO, who);
    }

    public String getDesc() {
        return getString(DESC);
    }

    public void setDesc(String desc) {
        put(DESC, desc);
    }

    public String getType() {
        return getString(TYPE);
    }

    public void setType(String type) {
        put(TYPE, type);
    }

    public String getUrl() {
        return getString(URL);
    }

    public void setUrl(String url) {
        put(URL, url);
    }

    @Override
    public String toString() {
        return "MingPicture{}";
    }
}
