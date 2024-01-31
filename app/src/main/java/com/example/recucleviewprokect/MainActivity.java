package com.example.recucleviewprokect;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recucleviewprokect.R.id;
import com.example.recucleviewprokect.R.layout;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button myButton ;

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ArrayList<DataModel> dataSet;
    private CustomAdapter adapter;
    private MediaPlayer song = null;

    private Boolean isPause = true;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_main);
        this.recyclerView = (RecyclerView)this.findViewById(id.res);
        this.myButton = findViewById(R.id.btn_mute);
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


        adapter = new CustomAdapter(dataSet);
        recyclerView.setAdapter(adapter);

       song = MediaPlayer.create(this, R.raw.friends_theme_song);
       song.setLooping(true);
      //  song.start();
    }


    public void muteThemeSong(View view) {

        if(song == null )return;

        if(isPause)
        {
            myButton.setBackgroundResource(R.drawable.unpause);
            song.setVolume(0.0f, 0.0f);
        }
        else
        {
            myButton.setBackgroundResource(R.drawable.pause);
            song.setVolume(1.0f, 1.0f);
        }

        isPause = !isPause;
    }
}