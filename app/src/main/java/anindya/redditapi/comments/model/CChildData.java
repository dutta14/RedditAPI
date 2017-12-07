package anindya.redditapi.comments.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anind on 12/6/2017.
 */

public class CChildData {
    @SerializedName("body")
    @Expose
    public String body;
    @SerializedName("replies")
    @Expose
    public Object replies; //can be a LResult or a String when no replies.
}
