package mingjian.com.kendo.Presenter;

import android.util.ArrayMap;

import java.util.List;

import mingjian.com.kendo.Model.Source.BaseBean;
import mingjian.com.kendo.Model.Source.FuLi;
import mingjian.com.kendo.View.BaseView;

/**
 * Created by studio02 on 10/25/16.
 */

public interface HomeContract {

    interface View extends BaseView{
        void LoadDatasResults(ArrayMap<String, List<BaseBean>> stringListArrayMap);
        void LoadDatasFail();
    }
    interface Presenter extends BasePresenter{

    }

}
