package mingjian.com.kendo.Utils;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.facebook.drawee.backends.pipeline.Fresco;

import mingjian.com.kendo.Common.Commons;

/**
 * Created by studio02 on 10/25/16.
 */

public class KendoApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this, Commons.APP_ID,Commons.APP_KEY);
    }
}
