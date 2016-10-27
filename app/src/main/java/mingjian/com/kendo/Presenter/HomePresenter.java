package mingjian.com.kendo.Presenter;

import android.util.ArrayMap;

import java.util.List;

import mingjian.com.kendo.Model.BaseModel;
import mingjian.com.kendo.Model.HomeModel;
import mingjian.com.kendo.Model.Source.BaseBean;
import mingjian.com.kendo.Model.Source.FuLi;

/**
 * Created by studio02 on 10/25/16.
 */

public class HomePresenter implements HomeContract.Presenter{
    private HomeContract.View targetView;
    private HomeModel homeModel;

    public HomePresenter(HomeContract.View targetView) {
        this.targetView = targetView;
        homeModel = new HomeModel();
    }

    @Override
    public void start() {
        homeModel.loadResultDatas(new BaseModel.LoadFuLisCallback() {
            @Override
            public void onDatasLoaded(ArrayMap<String, List<BaseBean>> stringListArrayMap) {

            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void stop() {

    }
}
