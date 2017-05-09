package com.skeleton.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.model.PostClass;

import java.util.List;

/**
 * Created by user on 5/7/2017.
 */

public class MyPostAdapter extends RecyclerView.Adapter<MyPostAdapter.ViewHolder> {
    private Context context;
    private List<PostClass> postClassList;
    public MyPostAdapter(Context context,List<PostClass> list){
        this.context=context;
        postClassList=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.post_recycler_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.posts.setText(postClassList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return postClassList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView posts;
        public ViewHolder(final View itemView) {
            super(itemView);
            posts=(TextView)itemView.findViewById(R.id.my_post);
        }



    }
}
