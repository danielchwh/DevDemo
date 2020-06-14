package com.danielchwh.devdemo;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

/*
 * Remark: simple saved state doesn't work with bottom navigation bar, we must use view model
 * */

public class Fragment1_BottomNavigation extends Fragment {

    private ViewModel1_BottomNavigation mViewModel;
    private Switch aSwitch;

    public static Fragment1_BottomNavigation newInstance() {
        return new Fragment1_BottomNavigation();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_bottom_navigation, container, false);
        aSwitch = view.findViewById(R.id.switch1_BottomNavigation);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // change 'this' to 'requireActivity()' to keep view model after navigate to other fragment
        mViewModel = ViewModelProviders.of(requireActivity()).get(ViewModel1_BottomNavigation.class);

        // save and store state with view model
        aSwitch.setChecked(mViewModel.checked);
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.checked = aSwitch.isChecked();
            }
        });
    }

}