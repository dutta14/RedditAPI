package anindya.redditapi;

import java.util.List;

import anindya.redditapi.comments.model.CResult;
import anindya.redditapi.listings.model.LResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * API End-points for subreddits and comments.
 * @author Anindya
 */

public interface APIEndPoint {

    @GET("r/{subreddit}/hot/.json")
    Call<LResult> getHot(@Path("subreddit") String subreddit, @Query("limit") int limit);

    @GET("r/{subreddit}/hot/.json")
    Call<LResult> getHotAfter(@Path("subreddit") String subreddit, @Query("after") String next, @Query("limit") int limit);

    @GET("r/{subreddit}/hot/.json")
    Call<LResult> getHotBefore(@Path("subreddit") String subreddit, @Query("before") String next, @Query("limit") int limit);

    @GET("r/{subreddit}/comments/{article}/.json")
    Call<List<CResult>> getComments(@Path("subreddit") String subreddit, @Path("article") String article);
}