package com.danielchwh.devdemo;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

/*
 * LiveData doesn't support boolean Primitive, but it supports Boolean object
 * */

public class ViewModel1_BottomNavigation extends ViewModel {
    private SavedStateHandle savedStateHandle;

    public ViewModel1_BottomNavigation(SavedStateHandle savedStateHandle) {
        if (!savedStateHandle.contains("checked")) {
            savedStateHandle.set("checked", Boolean.valueOf(false));
        }
        this.savedStateHandle = savedStateHandle;
    }

    public Boolean get() {
        return savedStateHandle.get("checked");
    }

    public void set(boolean checked) {
        savedStateHandle.set("checked", Boolean.valueOf(checked));
    }
}