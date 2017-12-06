
package anindya.redditapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChildData {
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("thumbnail")
    @Expose
    public String thumbnail;
    @SerializedName("name")
    @Expose
    public String name;
}
