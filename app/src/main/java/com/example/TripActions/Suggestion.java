package com.example.TripActions;

public class Suggestion {

    boolean isSelected;
    String itemText;
    Suggestion(){

    }

    public boolean getSelected(){
        return isSelected;
    }

    public void setSelected(boolean isSelected){
        this.isSelected = isSelected;
    }

    public String getItem(){
        return itemText;
    }

    public void setItem(String itemText){
        this.itemText = itemText;
    }
}
