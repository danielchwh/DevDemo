package com.danielchwh.devdemo;

public class MainActivity_Item {
    private String itemName;
    private String itemDescription;

    public MainActivity_Item(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }
}
