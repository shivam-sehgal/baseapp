package com.skeleton.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.skeleton.R;
import com.skeleton.activity.MainActivity;
import com.skeleton.model.MainClass;

import java.util.List;

/**
 * Created by user on 5/7/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private Context context;
    private List<MainClass> userList;

    /**
     *
     * @param ctx context of activity
     * @param userList user list fetched from server
     */
    public RecyclerAdapter(final Context ctx, final List<MainClass> userList){
        context=ctx;
        this.userList=userList;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
     View view=(View)layoutInflater.inflate(R.layout.recycler_row,parent,false);

        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvUser.setText(userList.get(position).getName());

    }


    @Override
    public int getItemCount() {

        Toast.makeText(context,String.valueOf(userList.size()-1),Toast.LENGTH_LONG).show();
        return userList.size();
    }

    /**
     * inner class
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvUser;

        /**
         *
         * @param itemView view for row
         */

        public ViewHolder(final View itemView) {
            super(itemView);
            tvUser=(TextView)itemView.findViewById(R.id.user_name);
            tvUser.setOnClickListener(this);
        }

        @Override
        public void onClick(final View v) {
            ((MainActivity)context).setBottomArea(userList.get(getAdapterPosition()));

        }
    }

}
