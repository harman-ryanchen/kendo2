package mingjian.com.kendo.Model;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;
import com.orhanobut.logger.Logger;

import java.util.List;

import mingjian.com.kendo.Model.Source.MingPicture;
import mingjian.com.kendo.Utils.PostableHandler;
import mingjian.com.kendo.Utils.ThreadPoolManager;

/**
 * Created by studio02 on 11/3/16.
 */

public class MingGalleryModel implements BaseModel<MingPicture> {
    @Override
    public void cleanCache() {

    }

    @Override
    public void loadResultDatas(LoadFuLisCallback callback) {
        ThreadPoolManager.getWorkPool().postImmediately(new Runnable() {
            @Override
            public void run() {
                try {
                    AVQuery<MingPicture> query = AVQuery.getQuery(MingPicture.class);
                    List<MingPicture> mingPictures = query.find();
                    for (MingPicture m : mingPictures){
                        Logger.d("TEST_CLOUD_DATA name =%s , url =%s",m.getDesc(),m.getUrl());
                    }
                } catch (AVException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
