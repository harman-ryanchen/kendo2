package mingjian.com.kendo.Model.Api;

import mingjian.com.kendo.Model.Source.VideoDatasResult;
import mingjian.com.kendo.Model.Source.AndroidResult;
import mingjian.com.kendo.Model.Source.FuLiResult;
import mingjian.com.kendo.Model.Source.IOSResult;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by studio02 on 10/25/16.
 */

public interface ApiService {

    @GET("data/福利/{number}/{page}")
    Observable<FuLiResult> getBeauties(@Path("number") int number, @Path("page") int page);

    //http://gank.io/api/data/Android/10/1
    @GET("data/Android/{number}/{page}")
    Observable<AndroidResult> getAndroids(@Path("number") int number, @Path("page") int page);

    //http://gank.io/api/data/iOS/20/2
    @GET("data/iOS/{number}/{page}")
    Observable<IOSResult> getIOSs(@Path("number") int number, @Path("page") int page);

    //http://gank.io/api/data/all/20/2
    @GET("data/all/{number}/{page}")
    Observable<VideoDatasResult> getGanHuos(@Path("number") int number, @Path("page") int page);
}
