package com.example.recucleviewprokect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//המטרה שלו זה לקחת מתוך המערך כל אובייקט וליצור לו אדפטר
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    ArrayList<DataModel> dataset;
    public CustomAdapter(ArrayList<DataModel> dataSet) {
        this.dataset = dataSet;
    }

    // יצרנו מחלקה שתפקידה לעזור לאדפטר ולתפוס את הנתונים שבקארד
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewDescription;
        ImageView imageView;

        public MyViewHolder (View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.characterName);
            textViewDescription = itemView.findViewById(R.id.characterDescription);
            imageView = itemView.findViewById(R.id.characterImage);
        }
    }

    @NonNull
    @Override
    //ניצור מה הלייאאוט
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    //ניקח כל מקום במערך ונשים ע"י לולאה. מקשר את המערך לרשומה
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewDescription;
        ImageView imageView = holder.imageView;

        textViewName.setText(dataset.get(position).getName());
        textViewVersion.setText(dataset.get(position).getVersion());
        imageView.setImageResource(dataset.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
