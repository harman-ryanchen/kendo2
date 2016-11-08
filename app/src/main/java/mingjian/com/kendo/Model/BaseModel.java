package mingjian.com.kendo.Model;

import android.util.ArrayMap;

import java.util.List;

import mingjian.com.kendo.Model.Source.BaseBean;
import mingjian.com.kendo.Model.Source.FuLi;
import mingjian.com.kendo.Model.Source.MingPicture;

/**
 * Created by studio02 on 10/25/16.
 */

public interface BaseModel<T> {

    void cleanCache();
    void loadResultDatas(LoadFuLisCallback callback);

    void loadMingPictureDatasLoaded(LoadMingPicturesCallback loadMingPicturesCallback);


    interface LoadFuLisCallback {

        void onDatasLoaded(ArrayMap<String, List<BaseBean>> stringListArrayMap);


        void onDataNotAvailable();
    }
    interface LoadMingPicturesCallback {

        void onDatasLoaded(List<MingPicture> pictures);


        void onDataNotAvailable();
    }
}
