package com.danielchwh.devdemo;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class BottomNavigation_ViewModel2 extends ViewModel {
    private SavedStateHandle savedStateHandle;

    public BottomNavigation_ViewModel2(SavedStateHandle savedStateHandle) {
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