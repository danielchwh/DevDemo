package com.danielchwh.devdemo;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class ViewModel2_BottomNavigation extends ViewModel {
    private SavedStateHandle savedStateHandle;

    public ViewModel2_BottomNavigation(SavedStateHandle savedStateHandle) {
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