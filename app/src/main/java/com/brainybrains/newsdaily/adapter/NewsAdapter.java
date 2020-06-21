package com.brainybrains.newsdaily.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.brainybrains.newsdaily.R;
import com.brainybrains.newsdaily.database.DatabaseOpenHelper;
import com.brainybrains.newsdaily.fromAPI.Article;
import com.brainybrains.newsdaily.fromAPI.News;
import com.brainybrains.newsdaily.jSON.JSONplaceHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context context;
    private List<Article> articlesList;//=new ArrayList<>();

      public NewsAdapter(Context context, List<Article> articlesList) {
        this.context = context;
        this.articlesList = articlesList;
}
    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        News news=new News();
        Article article=articlesList.get(position);
        holder.bind(article);
        int x=0;
        holder.minicard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    boolean miniExp=news.isMiniexpandiIt();
                    holder.minicard.setVisibility(miniExp?View.VISIBLE:View.GONE);
                    news.setMiniexpandiIt(!news.isMiniexpandiIt());
                    boolean bigExp=news.isBigexpandiIt();
                    holder.bigcard.setVisibility(bigExp?View.GONE:View.VISIBLE);
                    news.setBigexpandiIt(!news.isBigexpandiIt());
            }
        });

    }

    @Override
    public int getItemCount() {
       return articlesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView miniImage, bigImage,share;
        private TextView miniTitel, bigTitel, date, bigNews;
        private CardView minicard, bigcard;

        private DatabaseOpenHelper helper;
        private List<Article> articles=new ArrayList<>();
        int i=0,databaseID;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            miniImage=itemView.findViewById(R.id.miniCardImage);
            bigImage=itemView.findViewById(R.id.bigImage);
            share=itemView.findViewById(R.id.shear);
            miniTitel=itemView.findViewById(R.id.miniCardText);
            bigTitel=itemView.findViewById(R.id.bigTitle);
            date=itemView.findViewById(R.id.bigDate);
            bigNews=itemView.findViewById(R.id.bigNews);
            minicard=itemView.findViewById(R.id.minicard);
            bigcard=itemView.findViewById(R.id.bigCard);



        }
        public void bind(Article article) {
            helper=new DatabaseOpenHelper(context);
            miniTitel.setText(article.getTitle());
            bigTitel.setText(article.getTitle());
            bigNews.setText(article.getDescription());
            String photoURL=article.getUrlToImage();
            Picasso.get()
                    .load(photoURL)
                    .error(R.drawable.corona)
                    .into(miniImage);
            Picasso.get()
                    .load(photoURL)
                    .error(R.drawable.corona)
                    .into(bigImage);
            long id=helper.addPlace(article.getTitle(),article.getAuthor(),article.getDescription());
            databaseID= (int) id;

        }
    }
}
