package mingjian.com.kendo.View.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import java.util.List;

import mingjian.com.kendo.Common.Commons;
import mingjian.com.kendo.Model.Source.MingPicture;
import mingjian.com.kendo.R;
import mingjian.com.kendo.View.Fragment.MingGalleryImageFragment;

/**
 * Created by studio02 on 5/3/16.
 */
public class MingPictureGalleryItemActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<MingPicture> mingPictures;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        viewPager = (ViewPager) findViewById(R.id.gallery_container);
        mingPictures = (List<MingPicture>) getIntent().getSerializableExtra(Commons.MING_PICTURE_LIST);
        int position = getIntent().getIntExtra(Commons.MING_PICTURE_LIST_POSITION,0);
        viewPager.setAdapter(new PictureGalleryAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    private class PictureGalleryAdapter extends FragmentStatePagerAdapter {

        public PictureGalleryAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return MingGalleryImageFragment.newInstance(mingPictures.get(position).getUrl());
        }

        @Override
        public int getCount() {
            return mingPictures.size();
        }
    }
}
