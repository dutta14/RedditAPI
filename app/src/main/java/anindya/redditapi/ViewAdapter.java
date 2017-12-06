package anindya.redditapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import anindya.redditapi.model.Child;

/**
 * Created by anind on 12/6/2017.
 */

class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    private final List<Child> mValues;
    Context mContext;

    ViewAdapter(List<Child> items, Context context) {
        mValues = items;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_content, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(holder.mItem.data.title);
        Picasso.with(mContext).load(holder.mItem.data.thumbnail).into(holder.mThumbnailView);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
//                    Intent intent = new Intent(context, ItemDetailActivity.class);
//                    intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.getProductId());

                // context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final ImageView mThumbnailView;
        private final TextView mContentView;
        private Child mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mThumbnailView = view.findViewById(R.id.thumbnail);
            mContentView = view.findViewById(R.id.content);
        }
    }
}

