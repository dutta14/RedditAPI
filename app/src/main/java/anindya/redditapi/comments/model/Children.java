package anindya.redditapi.comments.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anind on 12/6/2017.
 */

public class Children {
    @SerializedName("data")
    @Expose
    public CChildData data;
}
