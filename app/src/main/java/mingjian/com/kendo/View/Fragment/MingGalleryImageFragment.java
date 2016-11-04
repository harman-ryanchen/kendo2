package mingjian.com.kendo.View.Fragment;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.orhanobut.logger.Logger;

import mingjian.com.kendo.Common.Commons;
import mingjian.com.kendo.R;

/**
 * Created by studio02 on 5/3/16.
 */
public class MingGalleryImageFragment extends Fragment {


    public static MingGalleryImageFragment newInstance(String imageUrl) {
        MingGalleryImageFragment f = new MingGalleryImageFragment();

        Bundle args = new Bundle();
        args.putString(Commons.MING_PICTURE_URL, imageUrl);
        f.setArguments(args);
        return f;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery_image, container, false);
        SimpleDraweeView draweeView = (SimpleDraweeView) view.findViewById(R.id.gallery_big_image);
        String imaUrl = getArguments().getString(Commons.MING_PICTURE_URL);

        ProgressiveJpegConfig pjpegConfig = new ProgressiveJpegConfig() {
            @Override
            public int getNextScanNumberToDecode(int scanNumber) {
                return scanNumber + 2;
            }

            public QualityInfo getQualityInfo(int scanNumber) {
                boolean isGoodEnough = (scanNumber >= 5);
                return ImmutableQualityInfo.of(scanNumber, isGoodEnough, false);
            }
        };

        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(getContext())
                .setProgressiveJpegConfig(new SimpleProgressiveJpegConfig())
                .build();

        ControllerListener listener = new BaseControllerListener(){
            @Override
            public void onFinalImageSet(String id, Object imageInfo, Animatable animatable) {
                super.onFinalImageSet(id, imageInfo, animatable);
                Logger.d("onFinalImageSet");
            }

            @Override
            public void onFailure(String id, Throwable throwable) {
                super.onFailure(id, throwable);
                Logger.d("onFailure");
            }

            @Override
            public void onIntermediateImageFailed(String id, Throwable throwable) {
                super.onIntermediateImageFailed(id, throwable);
                Logger.d("onIntermediateImageFailed");
            }
        };

        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(imaUrl))
                .setProgressiveRenderingEnabled(true)
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(draweeView.getController())
                .setControllerListener(listener)
                .build();
        draweeView.setController(controller);
        return view;
    }
}
