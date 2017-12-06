package anindya.redditapi;

import anindya.redditapi.model.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by anind on 12/5/2017.
 */

public interface APIEndPoint {
    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    @GET("r/{subreddit}/hot/.json")
    Call<Result> getHot(@Path("subreddit") String subreddit);

}