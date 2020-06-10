package com.danielchwh.devdemo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

/*
* add to build gradle (app)
* dataBinding.enabled = true
* implementation 'androidx.lifecycle:lifecycle-viewmodel-savedstate:1.0.0-alpha01'
* */

public class NumberCounter extends ViewModel {
    private SavedStateHandle handle;

    // constructor with saved state
    public NumberCounter(SavedStateHandle handle) {
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