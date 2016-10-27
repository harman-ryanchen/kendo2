package mingjian.com.kendo.Presenter;

import android.util.ArrayMap;

import java.util.ArrayList;
import java.util.Iterator;
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
            public void onDatasLoaded(ArrayMap<String, List<BaseBean>> map) {
                targetView.LoadDatasResults(map);
            }

            @Override
            public void onDataNotAvailable() {
                targetView.LoadDatasFail();
            }
        });
    }

    @Override
    public void stop() {

    }

    /**
     * just get a item count for recycleView adapter
     * @param datas
     * @return
     */
    public int getDatasSize(ArrayMap<String,List<BaseBean>> datas){
        if (datas==null)return 0;
        int count = 0;
        Iterator iter = datas.entrySet().iterator();
        while (iter.hasNext()) {
            List<BaseBean> baseBeens = (List<BaseBean>) iter.next();
            count += baseBeens.size();
        }
        count += datas.size();
        return count;
    }
    public List<BaseBean> getItems(ArrayMap<String,List<BaseBean>> datas){
        if (datas==null)return null;
        List<BaseBean> beanList = new ArrayList<>();
        Iterator iter = datas.entrySet().iterator();
        while (iter.hasNext()) {
            ArrayMap.Entry entry= (ArrayMap.Entry) iter.next();
            List<BaseBean> value = (List<BaseBean>) entry.getValue();
            for (BaseBean b: value){
                b.setType((Integer) entry.getKey());
            }
            beanList.addAll(value);
        }
        return beanList;
    }

}
