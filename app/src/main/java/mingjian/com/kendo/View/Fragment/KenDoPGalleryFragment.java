package mingjian.com.kendo.View.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mingjian.com.kendo.Model.Source.MingPicture;
import mingjian.com.kendo.Presenter.MingGalleryContract;
import mingjian.com.kendo.Presenter.MingGalleryPresenter;
import mingjian.com.kendo.R;

/**
 * Created by studio02 on 10/25/16.
 */

public class KenDoPGalleryFragment extends ParentFragment implements MingGalleryContract.View{
    private MingGalleryPresenter mingGalleryPresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gallery,null);
        mingGalleryPresenter = new MingGalleryPresenter(this);
        mingGalleryPresenter.start();
        return rootView;
    }
    

    @Override
    public void LoadDatasResults(List<MingPicture> pictures) {
        
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
