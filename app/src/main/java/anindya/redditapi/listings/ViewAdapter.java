package anindya.redditapi.listings;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import anindya.redditapi.comments.CommentActivity;
import anindya.redditapi.R;
import anindya.redditapi.listings.model.LChild;

/**
 * View adapter for each item in home screen.
 * @author Anindya
 */

class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    private final List<LChild> mValues;
    private Context mContext;

    ViewAdapter(List<LChild> items, Context context) {
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
        if(!holder.mItem.data.thumbnail.isEmpty()) {
            Picasso.with(mContext).load(holder.mItem.data.thumbnail).into(holder.mThumbnailView);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, CommentActivity.class);
                intent.putExtra(CommentActivity.LISTING_ID, holder.mItem.data.id);
                context.startActivity(intent);

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
        private LChild mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mThumbnailView = view.findViewById(R.id.thumbnail);
            mContentView = view.findViewById(R.id.content);
        }
    }
}

