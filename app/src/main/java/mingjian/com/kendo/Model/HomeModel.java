package mingjian.com.kendo.Model;

import android.util.ArrayMap;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import mingjian.com.kendo.Common.Commons;
import mingjian.com.kendo.Model.Api.ApiService;
import mingjian.com.kendo.Model.Source.VideoDatasResult;
import mingjian.com.kendo.Model.Source.AndroidResult;
import mingjian.com.kendo.Model.Source.BaseBean;
import mingjian.com.kendo.Model.Source.FuLi;
import mingjian.com.kendo.Model.Source.FuLiResult;
import mingjian.com.kendo.Model.Source.IOSResult;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.schedulers.Schedulers;

/**
 * Created by studio02 on 10/25/16.
 */

public class HomeModel implements BaseModel<FuLi> {
    private Retrofit retrofit;
    private ApiService apiService;

    public HomeModel() {
        if (apiService == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Commons.GanhuoBaseApi)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            apiService = retrofit.create(ApiService.class);
        }
    }


    @Override
    public void cleanCache() {

    }

    @Override
    public void loadResultDatas(final LoadFuLisCallback callback) {
        Observable.zip(apiService.getBeauties(10, 1), apiService.getAndroids(10, 1), apiService.getGanHuos(10, 1), apiService.getIOSs(10, 1), new Func4<FuLiResult, AndroidResult, VideoDatasResult, IOSResult, ArrayMap<String, List<BaseBean>>>() {
            @Override
            public ArrayMap<String, List<BaseBean>> call(FuLiResult fuLiResult, AndroidResult androidResult, VideoDatasResult allGanHuoResult, IOSResult iosResult) {
                ArrayMap<String, List<BaseBean>> map = new ArrayMap<String, List<BaseBean>>();
                map.put(Commons.ITEM_TYPE.ITEM_TYPE_FULI.name(), new ArrayList<BaseBean>(fuLiResult.fuLis));
                map.put(Commons.ITEM_TYPE.ITEM_TYPE_ANDROID.name(), new ArrayList<BaseBean>(androidResult.getResults()));
                map.put(Commons.ITEM_TYPE.ITEM_TYPE_IOS.name(), new ArrayList<BaseBean>(iosResult.getResults()));
                map.put(Commons.ITEM_TYPE.ITEM_TYPE_VEDIO.name(), new ArrayList<BaseBean>(allGanHuoResult.getResults()));
                return map;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ArrayMap<String, List<BaseBean>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                callback.onDataNotAvailable();
            }

            @Override
            public void onNext(ArrayMap<String, List<BaseBean>> map) {
                callback.onDatasLoaded(map);
            }
        });
    }


}
