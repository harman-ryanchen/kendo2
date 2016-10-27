package mingjian.com.kendo.Model;

import com.orhanobut.logger.Logger;

import java.util.List;

import mingjian.com.kendo.Common.Commons;
import mingjian.com.kendo.Model.Api.ApiService;
import mingjian.com.kendo.Model.Source.FuLi;
import mingjian.com.kendo.Model.Source.FuLiResult;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
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
        Observer<FuLiResult> listObserver = new Observer<FuLiResult>() {
            @Override
            public void onCompleted() {
                Logger.d(getClass().getName(),"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                callback.onDataNotAvailable();
            }

            @Override
            public void onNext(FuLiResult fuLiResult) {
                callback.onDatasLoaded(fuLiResult.fuLis);
            }
        };
        apiService.getBeauties(10,1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(listObserver);
    }


}
