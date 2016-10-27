package mingjian.com.kendo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import mingjian.com.kendo.Model.Source.FuLi;
import mingjian.com.kendo.R;

public class HomeDisplayAdapter extends RecyclerView.Adapter<HomeDisplayAdapter.NormalTextViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private List<FuLi> mFuLis;

    public HomeDisplayAdapter(Context context, List<FuLi> fuLis) {
        mContext = context;
        this.mFuLis = fuLis;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setmFuLis(List<FuLi> mFuLis) {
        this.mFuLis = mFuLis;
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item_home_adapter, parent, false), this);
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
        FuLi fuLi = mFuLis.get(position);

        holder.mTextView.setText(fuLi.getCreatedAt());
        holder.simpleDraweeView.setImageURI(fuLi.getUrl());
    }

    @Override
    public int getItemCount() {
        return mFuLis.size();
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        SimpleDraweeView simpleDraweeView;

        NormalTextViewHolder(View view, HomeDisplayAdapter adapter) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.pic_name);
            simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.pic);
        }

    }
}
