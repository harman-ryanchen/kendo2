package mingjian.com.kendo.Adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import mingjian.com.kendo.Model.Source.MingPicture;
import mingjian.com.kendo.R;

/**
 * Created by studio02 on 11/4/16.
 */

public class MingGalleryAdapter extends RecyclerView.Adapter<MingGalleryAdapter.GalleryViewHolder>{
    private List<MingPicture> mingPictures;


    public void refreshDatas(List<MingPicture> mingPictures) {
        this.mingPictures = mingPictures;
        notifyDataSetChanged();
    }

    @Override
    public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ming_gallery, parent, false);
        return new GalleryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GalleryViewHolder holder, int position) {
        holder.titleview.setText(mingPictures.get(position).getDesc());
        holder.iv_meizhi.setImageURI(Uri.parse(mingPictures.get(position).getUrl()));
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("meizhi", (Serializable) mFuLiBeens);
//                bundle.putInt("position",position);
//                Intent intent = new Intent(getContext(),GalleryActivity.class);
//                intent.putExtras(bundle);
//                getActivity().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mingPictures.size();
    }
    public static class GalleryViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView iv_meizhi;
        TextView titleview;
        View mItemView;

        GalleryViewHolder(View view) {
            super(view);
            mItemView = itemView;
            iv_meizhi = (SimpleDraweeView) itemView.findViewById(R.id.meizhi_image);
            titleview = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
