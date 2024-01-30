package com.example.recucleviewprokect;

import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recucleviewprokect.R.id;
import com.example.recucleviewprokect.R.layout;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ArrayList<DataModel> dataSet;
    private CustomAdapter adapter;
    private MediaPlayer media;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_main);
        this.recyclerView = (RecyclerView)this.findViewById(id.res);
        this.layoutManager = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());

        dataSet = new ArrayList<>();
        for(int i = 0; i < MyData.drawableArray.length; ++i) {
            this.dataSet.add(
                    new DataModel(
                            MyData.nameArray[i],
                            MyData.descriptionArray[i],
                            MyData.id_[i],
                            MyData.drawableArray[i]));
        }

        // חייב לקבל את המערך ואת הריסייקל וויו עצמו
        adapter = new CustomAdapter(dataSet);
        recyclerView.setAdapter(adapter);

        media = MediaPlayer.create(this, R.raw.friends_theme_song);
        media.setLooping(true);
        media.start();
    }
}