package mingjian.com.kendo.Utils;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.facebook.drawee.backends.pipeline.Fresco;

import mingjian.com.kendo.Common.Commons;
import mingjian.com.kendo.Model.Source.MingPicture;

/**
 * Created by studio02 on 10/25/16.
 */

public class KendoApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        // 初始化参数依次为 this, AppId, AppKey
        AVObject.registerSubclass(MingPicture.class);
        AVOSCloud.initialize(this, Commons.APP_ID,Commons.APP_KEY);
    }
}
