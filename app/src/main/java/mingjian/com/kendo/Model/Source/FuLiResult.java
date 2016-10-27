package mingjian.com.kendo.Model.Source;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by studio02 on 10/26/16.
 */

public class FuLiResult{
    public boolean error;
    public @SerializedName("results") List<FuLi> fuLis;
}
