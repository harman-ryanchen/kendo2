package mingjian.com.kendo.View.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mingjian.com.kendo.Model.Source.FuLi;
import mingjian.com.kendo.Presenter.HomeContract;
import mingjian.com.kendo.Presenter.HomePresenter;
import mingjian.com.kendo.R;

/**
 * Created by studio02 on 10/25/16.
 */

public class HomeFragment extends ParentFragment implements HomeContract.View {
    private HomePresenter homePresenter;
    private Context context;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home,null);
        homePresenter = new HomePresenter(this);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        homePresenter.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        homePresenter.stop();
    }

    @Override
    public void LoadDatasResults(List<FuLi> fuLis) {
    }

    @Override
    public void LoadDatasFail() {

    }
    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
