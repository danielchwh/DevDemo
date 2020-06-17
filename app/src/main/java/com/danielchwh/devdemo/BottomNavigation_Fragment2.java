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

public class BottomNavigation_Fragment2 extends Fragment {

    private BottomNavigation_ViewModel2 mViewModel;
    private Switch aSwitch;

    public static BottomNavigation_Fragment2 newInstance() {
        return new BottomNavigation_Fragment2();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_navigation_2, container, false);
        aSwitch = view.findViewById(R.id.switch2_BottomNavigation);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // change 'this' to 'requireActivity()' to keep view model after navigate to other fragment
        mViewModel = new ViewModelProvider(requireActivity()).get(BottomNavigation_ViewModel2.class);

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