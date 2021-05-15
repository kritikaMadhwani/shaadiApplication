package com.personalprojects.shaddiapplication;

import android.content.Context;
import android.nfc.cardemulation.CardEmulation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.BreakIterator;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardMatchesAdapter extends RecyclerView.Adapter<CardMatchesAdapter.CardMatchViewHolder>{

    private CardData[] cardData;
    private Context context;

    public CardMatchesAdapter(CardData[] cardData, Context context)
    {
        this.cardData= cardData;
        this.context = context;
    }
    @NonNull
    @Override
    public CardMatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listCardView= layoutInflater.inflate(R.layout.item_card_view, parent, false);
        CardMatchViewHolder viewHolder = new CardMatchViewHolder(listCardView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardMatchViewHolder holder, int position) {
        if (cardData != null && cardData.length != 0) {
            Glide.with(context)
                    .load(cardData[position].getImageId())
                    .into(holder.cardMainImage);
            holder.acceptButton.setOnClickListener(view -> Toast.makeText(view.getContext(), "click on item: acceptButtton ", Toast.LENGTH_LONG).show());
            holder.declineButton.setOnClickListener(view -> Toast.makeText(view.getContext(), "click on item:  declineButton ", Toast.LENGTH_LONG).show());
        }
    }

    @Override
    public int getItemCount() {
        return cardData.length;
    }

    public class CardMatchViewHolder extends RecyclerView.ViewHolder {

        public ImageView cardMainImage;
        public Button acceptButton;
        public Button declineButton;

        public CardMatchViewHolder(@NonNull View itemView) {
            super(itemView);
            cardMainImage = itemView.findViewById(R.id.main_image);
            acceptButton = itemView.findViewById(R.id.accept_button);
            declineButton= itemView.findViewById(R.id.decline_button);
        }
    }
}
