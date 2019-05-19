package com.example.TripActions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList<Suggestion> itemsList;

    RecyclerViewAdapter(){
      //  this.itemsList = itemsList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.row_id)
        TextView rowItem;
        @BindView(R.id.checkBox)
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_item,viewGroup,false);
        return new ViewHolder(view);
    }


        @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder viewHolder, int position) {
        final Suggestion item = itemsList.get(position);
        viewHolder.rowItem.setText(item.getItem());
        viewHolder.checkBox.setOnCheckedChangeListener(null);
        viewHolder.checkBox.setChecked(item.getSelected());
        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    item.setSelected(true);
                }else {
                    item.setSelected(false);
                }
            }
        });
      //  viewHolder.bind(position);
            viewHolder.checkBox.setChecked(item.getSelected());
    }


    @Override
    public int getItemCount() {
        if(itemsList == null ){
            return 0;
        }
       return  itemsList.size();
    }

    void loadItems(ArrayList<Suggestion> itemsListing) {
        this.itemsList = itemsListing;
        notifyDataSetChanged();
    }

}
