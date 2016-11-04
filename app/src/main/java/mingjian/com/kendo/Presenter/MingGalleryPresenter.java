package mingjian.com.kendo.Presenter;

import android.util.ArrayMap;

import java.util.List;

import mingjian.com.kendo.Model.BaseModel;
import mingjian.com.kendo.Model.MingGalleryModel;
import mingjian.com.kendo.Model.Source.BaseBean;
import mingjian.com.kendo.Model.Source.MingPicture;

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
        mingGalleryModel.loadMingPictureDatasLoaded(new BaseModel.LoadMingPicturesCallback() {
            @Override
            public void onDatasLoaded(List<MingPicture> pictures) {
                view.LoadDatasResults(pictures);
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
