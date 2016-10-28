package mingjian.com.kendo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import mingjian.com.kendo.Common.Commons;
import mingjian.com.kendo.Model.Source.AndroidResult;
import mingjian.com.kendo.Model.Source.BaseBean;
import mingjian.com.kendo.Model.Source.FuLi;
import mingjian.com.kendo.Model.Source.IOSResult;
import mingjian.com.kendo.Model.Source.VideoDatasResult;
import mingjian.com.kendo.Presenter.BasePresenter;
import mingjian.com.kendo.Presenter.HomePresenter;
import mingjian.com.kendo.R;

public class HomeDisplayAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private List<BaseBean> mDatas;
    private HomePresenter homePresenter;



    public HomeDisplayAdapter(Context context, ArrayMap<String, List<BaseBean>> datas, BasePresenter presenter) {
        mContext = context;
        this.homePresenter = (HomePresenter) presenter;
        this.mDatas = homePresenter.getItems(datas);
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setmFuLis(ArrayMap<String, List<BaseBean>> datas) {
        this.mDatas = homePresenter.getItems(datas);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Commons.ITEM_TYPE.ITEM_TYPE_FULI.ordinal()) {
            return new FuliViewHolder(mLayoutInflater.inflate(R.layout.item_home_display_fuli, parent, false), this);
        } else {
            return new GanHuoViewHolder(mLayoutInflater.inflate(R.layout.item_home_display_normal, parent, false), this);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (mDatas.get(position).getItemtype().equals(Commons.ITEM_TYPE.ITEM_TYPE_FULI.name())){
            FuLi fuLi = (FuLi) mDatas.get(position);
            if (holder instanceof FuliViewHolder){
                FuliViewHolder fuliViewHolder = (FuliViewHolder) holder;
                fuliViewHolder.mTextView.setText(fuLi.getCreatedAt());
                fuliViewHolder.simpleDraweeView.setImageURI(fuLi.getUrl());
            }

        } else if (mDatas.get(position).getItemtype().equals(Commons.ITEM_TYPE.ITEM_TYPE_ANDROID.name())){
            AndroidResult.ResultsBean bean = (AndroidResult.ResultsBean) mDatas.get(position);
            if (holder instanceof GanHuoViewHolder){
                GanHuoViewHolder ganHuoViewHolder  = (GanHuoViewHolder) holder;
                ganHuoViewHolder.dec.setText(bean.getDesc() + "  (" +bean.getWho()+")");
            }

        }else if (mDatas.get(position).getItemtype().equals(Commons.ITEM_TYPE.ITEM_TYPE_IOS.name())){
            IOSResult.ResultsBean bean = (IOSResult.ResultsBean) mDatas.get(position);
            if (holder instanceof GanHuoViewHolder){
                GanHuoViewHolder ganHuoViewHolder  = (GanHuoViewHolder) holder;
                ganHuoViewHolder.dec.setText(bean.getDesc() + "  (" +bean.getWho()+")");
            }
        }else if (mDatas.get(position).getItemtype().equals(Commons.ITEM_TYPE.ITEM_TYPE_VEDIO.name())){
            VideoDatasResult.ResultsBean bean = (VideoDatasResult.ResultsBean) mDatas.get(position);
            if (holder instanceof GanHuoViewHolder){
                GanHuoViewHolder ganHuoViewHolder  = (GanHuoViewHolder) holder;
                ganHuoViewHolder.dec.setText(bean.getDesc() + "  (" +bean.getWho()+")");
            }
        }
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mDatas.get(position) instanceof FuLi){
            return Commons.ITEM_TYPE.ITEM_TYPE_FULI.ordinal();
        }else if (mDatas.get(position) instanceof AndroidResult.ResultsBean){
            return Commons.ITEM_TYPE.ITEM_TYPE_ANDROID.ordinal();
        }else if (mDatas.get(position) instanceof IOSResult.ResultsBean){
            return Commons.ITEM_TYPE.ITEM_TYPE_IOS.ordinal();
        }else {
            return Commons.ITEM_TYPE.ITEM_TYPE_VEDIO.ordinal();
        }
    }

    public static class FuliViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        SimpleDraweeView simpleDraweeView;

        FuliViewHolder(View view, HomeDisplayAdapter adapter) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.pic_name);
            simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.pic);
        }
    }

    public static class GanHuoViewHolder extends RecyclerView.ViewHolder {
        TextView dec;

        GanHuoViewHolder(View view, HomeDisplayAdapter adapter) {
            super(view);
            dec = (TextView) view.findViewById(R.id.item_homedisplay_dec);
        }
    }
}
