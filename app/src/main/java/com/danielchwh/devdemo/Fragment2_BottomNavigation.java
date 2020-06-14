package com.danielchwh.devdemo;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment2_BottomNavigation extends Fragment {

    private ViewModel2_BottomNavigation mViewModel;

    public static Fragment2_BottomNavigation newInstance() {
        return new Fragment2_BottomNavigation();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2_bottom_navigation, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ViewModel2_BottomNavigation.class);
        // TODO: Use the ViewModel
    }

}