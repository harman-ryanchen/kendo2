package mingjian.com.kendo.View.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mingjian.com.kendo.Adapter.HomeDisplayAdapter;
import mingjian.com.kendo.Model.Source.BaseBean;
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
    private RecyclerView displayV;
    private HomeDisplayAdapter displayAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, null);
        displayV = (RecyclerView) rootView.findViewById(R.id.display_rv);
        initDisplayView();
        homePresenter = new HomePresenter(this);
        return rootView;
    }

    private void initDisplayView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        displayV.setLayoutManager(layoutManager);
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
    public void LoadDatasResults(ArrayMap<String, List<BaseBean>> map) {
        if (displayAdapter == null) {
            displayAdapter = new HomeDisplayAdapter(context, map,homePresenter);
            displayV.setAdapter(displayAdapter);
        } else {
            displayAdapter.setmFuLis(map);
            displayAdapter.notifyDataSetChanged();
        }
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
