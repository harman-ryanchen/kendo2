package mingjian.com.kendo.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import mingjian.com.kendo.Model.Source.FuLi;
import mingjian.com.kendo.R;

/**
 * Created by studio02 on 10/26/16.
 */

public class HomeStackAdapter extends BaseAdapter {
    private List<FuLi> ls;
    private Context mContext;

    public HomeStackAdapter(Context context,List<FuLi> ls) {
        this.ls = ls;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return ls.size();
    }

    @Override
    public Object getItem(int i) {
        return ls.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View v = null;
        if (convertView == null) {
            v = LayoutInflater.from(mContext).inflate(R.layout.item_home_adapter, null);
        }

        FuLi fuLi = ls.get(i);

        if (fuLi != null) {
            TextView text = (TextView) v.findViewById(R.id.pic_name);
            SimpleDraweeView pic_V = (SimpleDraweeView) v.findViewById(R.id.pic);
            pic_V.setImageURI(Uri.parse(fuLi.getUrl()));
            text.setText(fuLi.getCreatedAt());
        }
        return v;
    }

}
