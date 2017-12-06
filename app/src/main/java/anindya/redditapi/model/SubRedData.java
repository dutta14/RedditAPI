
package anindya.redditapi.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubRedData {

//    @SerializedName("modhash")
//    @Expose
//    public String modhash;
//    @SerializedName("whitelist_status")
//    @Expose
//    public String whitelistStatus;
    @SerializedName("children")
    @Expose
    public List<Child> children = null;
    @SerializedName("after")
    @Expose
    public String after;
    @SerializedName("before")
    @Expose
    public String before;

}
