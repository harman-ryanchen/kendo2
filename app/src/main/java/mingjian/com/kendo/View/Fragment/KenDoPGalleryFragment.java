package mingjian.com.kendo.View.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mingjian.com.kendo.Adapter.MingGalleryAdapter;
import mingjian.com.kendo.Model.Source.MingPicture;
import mingjian.com.kendo.Presenter.MingGalleryContract;
import mingjian.com.kendo.Presenter.MingGalleryPresenter;
import mingjian.com.kendo.R;
import mingjian.com.kendo.Utils.PostableHandler;

/**
 * Created by studio02 on 10/25/16.
 */

public class KenDoPGalleryFragment extends ParentFragment implements MingGalleryContract.View {
    private MingGalleryPresenter mingGalleryPresenter;
    private RecyclerView mGalleryView;
    private MingGalleryAdapter mingGalleryAdapter;
    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gallery, null);
        mGalleryView = (RecyclerView) rootView.findViewById(R.id.gallery_display_rv);
        initRecyclerview();
        mingGalleryPresenter = new MingGalleryPresenter(this);
        mingGalleryPresenter.start();
        return rootView;
    }

    private void initRecyclerview() {
        StaggeredGridLayoutManager layoutManager
                = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        mGalleryView.setLayoutManager(layoutManager);
    }


    @Override
    public void LoadDatasResults(final List<MingPicture> pictures) {
        PostableHandler.UI_THREAD.postImmediately(new Runnable() {
            @Override
            public void run() {
                if (mingGalleryAdapter == null) {
                    mingGalleryAdapter = new MingGalleryAdapter(mContext);
                    mGalleryView.setAdapter(mingGalleryAdapter);
                    mingGalleryAdapter.refreshDatas(pictures);
                } else {
                    mingGalleryAdapter.refreshDatas(pictures);
                }
            }
        });
    }

    @Override
    public void LoadDatasFail() {

    }

    public static KenDoPGalleryFragment newInstance() {

        Bundle args = new Bundle();

        KenDoPGalleryFragment fragment = new KenDoPGalleryFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
