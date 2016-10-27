package mingjian.com.kendo.Model;

import android.util.ArrayMap;

import java.util.List;

import mingjian.com.kendo.Model.Source.BaseBean;
import mingjian.com.kendo.Model.Source.FuLi;

/**
 * Created by studio02 on 10/25/16.
 */

public interface BaseModel<T> {

    void cleanCache();
    void loadResultDatas(LoadFuLisCallback callback);

    interface LoadFuLisCallback {

        void onDatasLoaded(ArrayMap<String, List<BaseBean>> stringListArrayMap);

        void onDataNotAvailable();
    }
}
