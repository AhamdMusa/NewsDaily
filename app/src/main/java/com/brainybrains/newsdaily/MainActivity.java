package com.brainybrains.newsdaily;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.brainybrains.newsdaily.adapter.NewsAdapter;
import com.brainybrains.newsdaily.database.DatabaseOpenHelper;
import com.brainybrains.newsdaily.fromAPI.Article;
import com.brainybrains.newsdaily.fromAPI.News;
import com.brainybrains.newsdaily.jSON.ApiClient;
import com.brainybrains.newsdaily.jSON.JSONplaceHolder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView newsRV;
    private NewsAdapter newsAdapter;
    private DatabaseOpenHelper helper;
    private List<Article> articles=new ArrayList<>();
    int i=0,databaseID;
    String type;
    String from;
    String to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            type= extras.getString("type");
            from= extras.getString("from");
            to= extras.getString("to");
        }


        newsRV=findViewById(R.id.newsRV);
        helper=new DatabaseOpenHelper(this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        newsRV.setLayoutManager(linearLayoutManager);
        newsRV.setItemAnimator(new DefaultItemAnimator());


        getNewses();
    }

    private void getNewses() {
        String url=buildUrl();
        JSONplaceHolder jsoNplaceHolder= ApiClient.builder().create(JSONplaceHolder.class);
        jsoNplaceHolder.getNewses(url).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                articles=response.body().getArticles();
                newsAdapter=new NewsAdapter(MainActivity.this,articles);
                newsRV.setAdapter(newsAdapter);
                newsAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("trable",t.getMessage());
            }
        });
      /*  Log.d("trable",url.toString());
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });*/


    }

    private String buildUrl() {
        if (type!=null){
            if (from==null&&to==null){
            StringBuilder urlString = new StringBuilder("everything?q="+type+"&apiKey=85f7a4bf8b714e4dbab47ec7bc08ae61");
            return urlString.toString();
            }
            else if (from!=null&&to==null) {
                StringBuilder urlString = new StringBuilder("everything?q="+type+"&from="+from+"&to="+to+"apiKey=85f7a4bf8b714e4dbab47ec7bc08ae61");       /*rvdynirysrysruymlsOTOTOTOTOTOTOTOTOTOn,mb,b,fb,xdb*/
                return urlString.toString();
            }
            else if (from==null&&to!=null) {
                StringBuilder urlString = new StringBuilder("everything?q="+type+"&from="+from+"&to="+to+"apiKey=85f7a4bf8b714e4dbab47ec7bc08ae61");       /*rvdynirysrysruymlsOTOTOTOTOTOTOTOTOTOn,mb,b,fb,xdb*/
                return urlString.toString();
            }
            else  {
                StringBuilder urlString = new StringBuilder("everything?q="+type+"&from="+from+"&to="+to+"apiKey=85f7a4bf8b714e4dbab47ec7bc08ae61");
                return urlString.toString();
            }
        }
        else
        {
            StringBuilder urlString = new StringBuilder("everything?apiKey=85f7a4bf8b714e4dbab47ec7bc08ae61");
            return urlString.toString();
        }


    }
}
