package com.skeleton.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.skeleton.R;
import com.skeleton.adapter.MyPostAdapter;
import com.skeleton.model.PostClass;
import com.skeleton.retrofit.ApiInterface;
import com.skeleton.retrofit.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {
  private RecyclerView recyclerView;
    private MyPostAdapter myPostAdapter;
    private List<PostClass> postList;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        init();
    }

    public void init(){
        recyclerView=(RecyclerView)findViewById(R.id.my_post_recycler);
        userId=getIntent().getIntExtra("userid",0);
        Toast.makeText(this, String.valueOf(userId), Toast.LENGTH_LONG).show();
        getPostList();

    }

    public void getPostList(){
        ApiInterface apiInterface= RestClient.getApiInterface();
        Call<List<PostClass>> data=apiInterface.getPosts(userId);
        data.enqueue(new Callback<List<PostClass>>() {
            @Override
            public void onResponse(final Call<List<PostClass>> call, final Response<List<PostClass>> response) {
                postList=response.body();
                setRecyclr();

            }

            @Override
            public void onFailure(final Call<List<PostClass>> call, final Throwable t) {
                Toast.makeText(PostActivity.this,"error occured",Toast.LENGTH_LONG).show();

            }
        });


    }

    public void setRecyclr(){

        Toast.makeText(this,String.valueOf(postList.size()),Toast.LENGTH_LONG).show();
        myPostAdapter=new MyPostAdapter(this,postList);
        recyclerView.setAdapter(myPostAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
