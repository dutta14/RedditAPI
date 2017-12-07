package anindya.redditapi.comments.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anind on 12/6/2017.
 */

public class CData {
    @SerializedName("children")
    @Expose
    public List<Children> children;
}
