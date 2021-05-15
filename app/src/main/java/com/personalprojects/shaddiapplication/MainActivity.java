package com.personalprojects.shaddiapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private CardMatchesAdapter cardMatchesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intialiseView();
    }

    private void intialiseView() {
        CardData[] myListData = new CardData[]{
                new CardData( android.R.drawable.ic_dialog_email),
                new CardData(android.R.drawable.ic_dialog_info),
                new CardData( android.R.drawable.ic_delete),
                new CardData(android.R.drawable.ic_dialog_dialer)
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cards_recyclerview);
        cardMatchesAdapter = new CardMatchesAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cardMatchesAdapter);
    }
}