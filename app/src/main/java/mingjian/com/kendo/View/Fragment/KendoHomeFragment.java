package mingjian.com.kendo.View.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mingjian.com.kendo.R;

/**
 * Created by studio02 on 10/25/16.
 */

public class KendoHomeFragment extends ParentFragment{
    private Context context;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, null);
        return rootView;
    }


    public static KendoHomeFragment newInstance() {

        Bundle args = new Bundle();

        KendoHomeFragment fragment = new KendoHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
