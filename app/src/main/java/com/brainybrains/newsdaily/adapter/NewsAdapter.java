package com.brainybrains.newsdaily.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brainybrains.newsdaily.R;
import com.brainybrains.newsdaily.fromAPI.News;
import com.squareup.picasso.Picasso;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context context;
    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView miniImage, bigImage,share;
        private TextView miniTitel, bigTitel, date, bigNews;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            miniImage=itemView.findViewById(R.id.miniCardImage);
            bigImage=itemView.findViewById(R.id.bigImage);
            share=itemView.findViewById(R.id.shear);
            miniTitel=itemView.findViewById(R.id.miniCardText);
            bigTitel=itemView.findViewById(R.id.bigTitle);
            date=itemView.findViewById(R.id.bigDate);
            bigNews=itemView.findViewById(R.id.bigNews);
        }
        public void bind(News news) {

            String photoURL=News;
            Picasso.get()
                    .load(photoURL)
                    .error(R.drawable.moon)
                    .into(placeImageView);


            ratingBar.setRating(Float.parseFloat(favorite.getRating()));

        }
    }
}
