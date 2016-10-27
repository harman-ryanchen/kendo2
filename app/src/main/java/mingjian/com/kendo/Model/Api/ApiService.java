package mingjian.com.kendo.Model.Api;

import java.util.List;

import mingjian.com.kendo.Model.Source.FuLi;
import mingjian.com.kendo.Model.Source.FuLiResult;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by studio02 on 10/25/16.
 */

public interface ApiService {

    @GET("data/福利/{number}/{page}")
    Observable<FuLiResult> getBeauties(@Path("number") int number, @Path("page") int page);
}
