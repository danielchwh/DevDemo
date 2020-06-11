package com.danielchwh.devdemo;

import java.util.ArrayList;

public class ContentsItem {
    private String itemName;
    private String itemDescription;

    public ContentsItem(String itemName, String itemDescription) {
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
