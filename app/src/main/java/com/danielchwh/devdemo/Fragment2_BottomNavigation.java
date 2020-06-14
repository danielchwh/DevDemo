package com.danielchwh.devdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class Fragment2_BottomNavigation extends Fragment {

    private ViewModel2_BottomNavigation mViewModel;
    private Switch aSwitch;

    public static Fragment2_BottomNavigation newInstance() {
        return new Fragment2_BottomNavigation();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_bottom_navigation, container, false);
        aSwitch = view.findViewById(R.id.switch2_BottomNavigation);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // change 'this' to 'requireActivity()' to keep view model after navigate to other fragment
        mViewModel = new ViewModelProvider(requireActivity()).get(ViewModel2_BottomNavigation.class);

        // save and store state with view model
        aSwitch.setChecked(mViewModel.get());
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.set(aSwitch.isChecked());
            }
        });
    }

}