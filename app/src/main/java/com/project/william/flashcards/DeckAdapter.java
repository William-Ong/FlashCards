package com.project.william.flashcards;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.project.william.flashcards.StorageHelperClasses.Deck;

import java.util.List;

/**
 * Created by William on 2015-05-25.
 */
public class DeckAdapter extends RecyclerView.Adapter<DeckAdapter.MyViewHolder> {

    private List<Deck> listOfDecks;
    private Context context;
    private LayoutInflater inflater;
    private SparseBooleanArray selectedItems;
    public DeckAdapter(List<Deck> listOfDecks, Context context){
        selectedItems = new SparseBooleanArray();
        inflater = LayoutInflater.from(context);
        this.listOfDecks = listOfDecks;
        this.context = context;
    }

    @Override
    public int getItemCount(){
        return listOfDecks.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position){
        Resources resources = context.getResources();
        Deck currentDeck = listOfDecks.get(position);
        viewHolder.layout.setSelected(selectedItems.get(position, false));
        viewHolder.title.setText(currentDeck.getTitle());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        Log.i("Adapter", "onCreateHolder called ");
        return holder;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        protected TextView title;
        protected LinearLayout layout;

        public MyViewHolder(View itemView) {

            super(itemView);
            title = (TextView)itemView.findViewById(R.id.deck_title);
            layout = (LinearLayout)itemView.findViewById(R.id.row_layout);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        private void changeColorOnClick(){
            layout.setBackgroundColor(Color.BLUE);
        }

        public void highlightClick(){
            if(selectedItems.get(getPosition(), false)){
                selectedItems.delete(getPosition());
                layout.setSelected(false);
            }else{
                selectedItems.put(getPosition(), true);
                layout.setSelected(true);
            }
        }

        @Override
        public void onClick(View v) {
            if(selectedItems.get(getPosition(), false)){
                selectedItems.delete(getPosition());
                layout.setSelected(false);
            }else{
                selectedItems.put(getPosition(), true);
                layout.setSelected(true);
            }

            int pos = getPosition();
            Toast.makeText(context, ""+pos, Toast.LENGTH_SHORT).show();
            Intent goToCardView = new Intent(context, CardView.class);
            goToCardView.putExtra("DeckPosition", pos);
            context.startActivity(goToCardView);
        }

        @Override
        public boolean onLongClick(View v) {
            if(selectedItems.get(getPosition(), false)){
                selectedItems.delete(getPosition());
                layout.setSelected(false);
            }else{
                selectedItems.put(getPosition(), true);
                layout.setSelected(true);
            }
            return true;
        }
    }
}
