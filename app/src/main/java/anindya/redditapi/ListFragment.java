package anindya.redditapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import anindya.redditapi.model.Child;
import anindya.redditapi.model.Result;

/**
 * Created by anind on 12/6/2017.
 */

public class ListFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    List<Child> mItemList;
    private Context mContext;
    private RecyclerView mRecyclerView;
    private View rootView;
    Button next, prev;
    private Result mResult;

    public ListFragment() {}

    public static ListFragment newInstance(RetrofitHelper.Options option, RetrofitHelper helper) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putSerializable("option", option);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        next = rootView.findViewById(R.id.next);
        prev = rootView.findViewById(R.id.prev);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext = rootView.getContext();
        mContext.registerReceiver(mReceiver, new IntentFilter(RetrofitHelper.DOWNLOAD_COMPLETE));
    }

    private void setupRecyclerView() {
        mRecyclerView = rootView.findViewById(R.id.item_list);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(new ViewAdapter(mItemList, getContext()));
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home h = (Home)getActivity();
                int n = mResult.data.children.size();
                h.getHelper().download(h.getQuery(), mResult.data.children.get(n-1).data.name, true);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home h = (Home)getActivity();
                h.getHelper().download(h.getQuery(), mResult.data.children.get(0).data.name, false);
            }
        });
    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                mResult = ((Home)getActivity()).getHelper().getResult();
                mItemList = mResult.data.children;
                setupRecyclerView();
            } catch (Exception e) {
                Log.e("anindya", e.getMessage());
            }
        }
    };
}



