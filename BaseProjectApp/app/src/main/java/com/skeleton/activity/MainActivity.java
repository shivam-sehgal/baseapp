package com.skeleton.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.skeleton.R;
import com.skeleton.adapter.RecyclerAdapter;
import com.skeleton.model.MainClass;
import com.skeleton.retrofit.ApiInterface;
import com.skeleton.retrofit.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private List<MainClass> userList;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private View view;
    private TextView tvUserName;
    private TextView tvStreet;
    private TextView tvCompanyName;
    private Button  btnGetPost;
    private Integer userId=null;
    private final String baseurl="http://jsonplaceholder.typicode.com/";
    public MainActivity(){
        userList=new ArrayList<MainClass>();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ApiInterface apiInterface= RestClient.getApiInterface();
        Call<List<MainClass>> userData=apiInterface.getUsers();
        userData.enqueue(new Callback<List<MainClass>>() {
            @Override
            public void onResponse(final Call<List<MainClass>> call, final Response<List<MainClass>> response) {
                userList=response.body();
                setUserNames();
            }

            @Override
            public void onFailure(final Call<List<MainClass>> call, final Throwable t) {

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
    public void init(){

        recyclerView=(RecyclerView)findViewById(R.id.my_recycler);
        view=(View)findViewById(R.id.bottom_part);
        tvUserName=(TextView)findViewById(R.id.user_name_fet);
        tvStreet=(TextView)findViewById(R.id.strt_name);
        tvCompanyName=(TextView)findViewById(R.id.comp_name);
        btnGetPost=(Button)findViewById(R.id.get_post);
        btnGetPost.setOnClickListener(this);

    }


    /**
     * set user names on recyclerview
     */
    public void setUserNames(){
       recyclerAdapter=new RecyclerAdapter(this,userList) ;
        //Toast.makeText(this,String.valueOf(userList.get(0).getName()),Toast.LENGTH_LONG).show();
        recyclerView.setAdapter(recyclerAdapter);

    }
    public void setBottomArea(MainClass mainClass){
        view.setVisibility(View.VISIBLE);
        tvUserName.setText(mainClass.getUsername());
        tvStreet.setText(mainClass.getAddress().getStreet());
        tvCompanyName.setText(mainClass.getCompany().getName());
        userId=mainClass.getId();



    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()){
            case R.id.get_post:
                startPostActivity();
                break;
        }


    }

    public void startPostActivity(){
        if(userId!=null){
            Intent intent=new Intent(this,PostActivity.class);
            intent.putExtra("userid",userId);
            startActivity(intent);

        }


    }
}
