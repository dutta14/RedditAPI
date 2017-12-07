package anindya.redditapi.listings;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import anindya.redditapi.R;
import anindya.redditapi.RetrofitHelper;

/**
 * Home/Main activity.
 * Shows results for  "android" subreddit by default.
 * @author Anindya
 */
public class Home extends AppCompatActivity {

    private RetrofitHelper mRetroHelper;
    private String mQuery = "android";
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Context context = getApplicationContext();
        ViewPager mViewPager = findViewById(R.id.viewpager);

        mRetroHelper = new RetrofitHelper(context);

        SectionAdapter mSectionAdapter = new SectionAdapter(getSupportFragmentManager(), context);
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
            searchView.setQuery("", false);
            searchView.setIconified(true);
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

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo( searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
