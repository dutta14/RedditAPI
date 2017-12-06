package anindya.redditapi;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import anindya.redditapi.model.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anind on 12/6/2017.
 */

public class RetrofitHelper {

    private static final String BASE_URL = "http://www.reddit.com/";
    public static final String DOWNLOAD_COMPLETE = "download_complete";
    private APIEndPoint mEndPoint;
    private Result mResult;
    private Context mContext;

    public RetrofitHelper(Context context) {
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mEndPoint = mRetrofit.create(APIEndPoint.class);
        mContext = context;
    }

   public void dowloadHot(String subreddit) {
       Call<Result> call = mEndPoint.getHot(subreddit);
       enqueueCall(call);
   }

    private void enqueueCall(Call<Result> call) {
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                mResult = response.body();
                mContext.sendBroadcast(new Intent(DOWNLOAD_COMPLETE));
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.e("anindya", t.getMessage());
            }
        });
    }

    public Result getResult() {
        return mResult;
   }
}
