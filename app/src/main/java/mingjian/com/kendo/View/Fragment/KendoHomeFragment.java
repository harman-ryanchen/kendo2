package mingjian.com.kendo.View.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v13.Bundler;
import com.ogaclejapan.smarttablayout.utils.v13.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v13.FragmentPagerItems;
import com.ogaclejapan.smarttablayout.utils.v13.FragmentStatePagerItemAdapter;

import java.util.List;

import mingjian.com.kendo.Adapter.HomeDisplayAdapter;
import mingjian.com.kendo.Common.Commons;
import mingjian.com.kendo.Model.Source.BaseBean;
import mingjian.com.kendo.Presenter.HomeContract;
import mingjian.com.kendo.Presenter.HomePresenter;
import mingjian.com.kendo.R;

/**
 * Created by studio02 on 10/25/16.
 */

public class KendoHomeFragment extends ParentFragment{
    private Context context;
    protected ViewPager viewPager;
    protected PagerAdapter pagerAdapter;
    private SmartTabLayout smartTabLayout;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, null);
        viewPager = (ViewPager) rootView.findViewById(R.id.inner_viewpager);
        smartTabLayout = (SmartTabLayout) rootView.findViewById(R.id.viewpagertab);
        initTablayout();
        return rootView;
    }

    private void initTablayout() {

    }

    public static KendoHomeFragment newInstance() {

        Bundle args = new Bundle();

        KendoHomeFragment fragment = new KendoHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
