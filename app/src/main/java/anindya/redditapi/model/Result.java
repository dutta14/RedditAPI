
package anindya.redditapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

//    @SerializedName("kind")
//    @Expose
//    public String kind;
    @SerializedName("data")
    @Expose
    public SubRedData data;

}
