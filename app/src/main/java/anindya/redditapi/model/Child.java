
package anindya.redditapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Child {
    @SerializedName("data")
    @Expose
    public ChildData data;

}
