package anindya.redditapi;

import android.app.SearchManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import anindya.redditapi.model.Result;

public class Home extends AppCompatActivity {

    private SectionAdapter mSectionAdapter;
    private ViewPager mViewPager;

    private Context mContext;
    private RetrofitHelper mRetroHelper;

    private String mQuery = "android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext = getApplicationContext();
        mViewPager = findViewById(R.id.viewpager);

        mRetroHelper = new RetrofitHelper(mContext);

        mSectionAdapter = new SectionAdapter(getSupportFragmentManager(), mContext);
        mViewPager.setAdapter(mSectionAdapter);
        handleIntent(getIntent());
        mRetroHelper.download(mQuery);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            mQuery = intent.getStringExtra(SearchManager.QUERY);
            Log.e("anindya", mQuery);
            mRetroHelper.download(mQuery);
        }
    }

    public RetrofitHelper getHelper() {
        return mRetroHelper;
    }

    public String getQuery(){
        return mQuery;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo( searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
