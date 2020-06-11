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

    public static ArrayList<ContentsItem> initialize() {
        ArrayList<ContentsItem> allItems = new ArrayList<ContentsItem>();
        allItems.add(new ContentsItem("LandscapeLayout", "..."));
        allItems.add(new ContentsItem("SaveState", "..."));
        allItems.add(new ContentsItem("SaveStateWithMVVM", "..."));
        allItems.add(new ContentsItem("SavePreferences", "..."));
        allItems.add(new ContentsItem("Timer", "..."));
        allItems.add(new ContentsItem("", "..."));
        return allItems;
    }
}
