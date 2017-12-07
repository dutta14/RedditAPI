package anindya.redditapi.comments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import anindya.redditapi.R;
import anindya.redditapi.RetrofitHelper;
import anindya.redditapi.comments.model.CResult;

/**
 * Activity that shows comments for a listing.
 * @author Anindya
 */
public class CommentActivity extends AppCompatActivity {

    public static final String LISTING_ID = "listing_id";

    Context mContext;
    RetrofitHelper mHelper;
    CResult mResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mContext = getApplicationContext();
        mHelper = new RetrofitHelper(mContext);
        mContext.registerReceiver(mReceiver, new IntentFilter(RetrofitHelper.DOWNLOAD_COMMENTS_COMPLETE));

        String listingId = getIntent().getStringExtra(LISTING_ID);
        mHelper.downloadComments(listingId);

    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            mResults = mHelper.getComments();

            RecyclerView itemList = findViewById(R.id.comment_list);
            itemList.setItemAnimator(new DefaultItemAnimator());
            TextView noComments = findViewById(R.id.no_comments);
            if(mResults.data != null) {
                itemList.setAdapter(new CommentAdapter(mResults.data.children, mContext));
                Log.e("anindya", "" + mResults.data.children.size());
                noComments.setVisibility(mResults.data.children.size() == 0 ? View.VISIBLE : View.GONE);
            } else {
                noComments.setVisibility(View.VISIBLE);
            }
        }
    };

}
