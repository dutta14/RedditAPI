package anindya.redditapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import anindya.redditapi.model.Result;

public class Home extends AppCompatActivity {

    private SectionAdapter mSectionAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    private Context mContext;
    private RetrofitHelper mRetroHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext = getApplicationContext();

        mViewPager = findViewById(R.id.viewpager);

        mSectionAdapter = new SectionAdapter(getSupportFragmentManager(), mContext);
        mViewPager.setAdapter(mSectionAdapter);

        mTabLayout = findViewById(R.id.tablayout);
        mTabLayout.setupWithViewPager(mViewPager);

        mContext.registerReceiver(mReceiver, new IntentFilter(RetrofitHelper.DOWNLOAD_COMPLETE));

        mRetroHelper = new RetrofitHelper(mContext);
        mRetroHelper.dowloadHot("android");
    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Result result = mRetroHelper.getResult();
            if(result != null) {
                Log.e("anindya", ""+result.data.children.size());
            } else {
                Log.e("anindya", "not yet");
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
