
package anindya.redditapi.listings.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LResult {
    @SerializedName("data")
    @Expose
    public SubRedData data;

}
