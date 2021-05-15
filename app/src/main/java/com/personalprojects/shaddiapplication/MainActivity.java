package com.personalprojects.shaddiapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.personalprojects.shaddiapplication.pojo.Root;

public class MainActivity extends AppCompatActivity {

    private CardMatchesAdapter cardMatchesAdapter;
    TextView responseText;
    RetrofitInterface apiInterface;
    CardData[] myListData ;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intialiseView();

        callAPI();

    }

    private void callAPI() {

        Call<Root> call = apiInterface.loadCards();
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {

                Log.d("TAG", response.code() + "");
                Root root = response.body();
                for(int i =0; i<root.getResults().size()-1 ; i++)
                {
                    myListData[i].setImageId(root.getResults().get(i).getPicture().getThumbnail());
                }
                cardMatchesAdapter = new CardMatchesAdapter(myListData,getApplicationContext());
                recyclerView.setAdapter(cardMatchesAdapter);

            }
            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                call.cancel();
            }
        });
    }


    private void intialiseView() {
        apiInterface = APIClient.getClient().create(RetrofitInterface.class);
        myListData = new CardData[10];
         recyclerView = (RecyclerView) findViewById(R.id.cards_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}