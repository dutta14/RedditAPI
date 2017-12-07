
package anindya.redditapi.listings.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubRedData {

    @SerializedName("children")
    @Expose
    public List<LChild> children = null;
    @SerializedName("after")
    @Expose
    public String after;
    @SerializedName("before")
    @Expose
    public String before;

}
