package com.danielchwh.devdemo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class SaveStateWithMVVM_ViewModel extends ViewModel {
    private SavedStateHandle handle;

    // constructor with saved state
    public SaveStateWithMVVM_ViewModel(SavedStateHandle handle) {
        this.handle = handle;
    }

    // get number from saved state
    public MutableLiveData<Integer> getNumber() {
        if (!handle.contains("num")) {
            handle.set("num", 0);
        }
        return handle.getLiveData("num");
    }

    // add
    public void add() {
        getNumber().setValue(getNumber().getValue() + 1);
    }
}
