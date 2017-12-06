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

    @GET("r/{subreddit}/hot/.json")
    Call<Result> getHot(@Path("subreddit") String subreddit, @Query("limit") int limit);

    @GET("r/{subreddit}/hot/.json")
    Call<Result> getHotAfter(@Path("subreddit") String subreddit, @Query("after") String next, @Query("limit") int limit);

    @GET("r/{subreddit}/hot/.json")
    Call<Result> getHotBefore(@Path("subreddit") String subreddit, @Query("before") String next, @Query("limit") int limit);
}