package com.danielchwh.devdemo;

public class MainActivity_Item {
    private String itemName;
    private String itemDescription;
    private String className;

    public MainActivity_Item(String itemName, String itemDescription, String className) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.className = className;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getClassName() {
        return className;
    }

    public String getClassFullName() {
        return this.getClass().getPackage().getName() + "." + className;
    }
}
