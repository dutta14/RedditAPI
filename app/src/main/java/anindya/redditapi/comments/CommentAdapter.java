package anindya.redditapi.comments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import anindya.redditapi.R;
import anindya.redditapi.comments.model.Children;

/**
 * Created by anind on 12/6/2017.
 */

class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    List<Children> mValues;
    Context mContext;

    public CommentAdapter(List<Children> items, Context context) {
        mValues = items;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comment_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(holder.mItem.data.body);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mContentView;
        private Children mItem;

        ViewHolder(View view) {
            super(view);
            mContentView = view.findViewById(R.id.content);
        }
    }
}
