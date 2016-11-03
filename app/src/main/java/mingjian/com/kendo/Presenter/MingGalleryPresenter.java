package mingjian.com.kendo.Presenter;

import android.util.ArrayMap;

import java.util.List;

import mingjian.com.kendo.Model.BaseModel;
import mingjian.com.kendo.Model.MingGalleryModel;
import mingjian.com.kendo.Model.Source.BaseBean;

/**
 * Created by studio02 on 11/3/16.
 */

public class MingGalleryPresenter implements MingGalleryContract.Presenter {
    private MingGalleryContract.View view;
    private MingGalleryModel mingGalleryModel;

    public MingGalleryPresenter(MingGalleryContract.View view) {
        this.view = view;
        mingGalleryModel = new MingGalleryModel();
    }

    @Override
    public void start() {
        mingGalleryModel.loadResultDatas(new BaseModel.LoadFuLisCallback() {
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
