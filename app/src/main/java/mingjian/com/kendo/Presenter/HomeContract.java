package mingjian.com.kendo.Presenter;

import java.util.List;

import mingjian.com.kendo.Model.Source.FuLi;
import mingjian.com.kendo.View.BaseView;

/**
 * Created by studio02 on 10/25/16.
 */

public interface HomeContract {

    interface View extends BaseView{
        void LoadDatasResults(List<FuLi> fuLis);
        void LoadDatasFail();
    }
    interface Presenter extends BasePresenter{

    }

}
