package com.danielchwh.devdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class NavigationDrawer_Fragment2 extends Fragment {

    public NavigationDrawer_Fragment2() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        CollapsingToolbarLayout collapsingLayout = requireActivity().findViewById(R.id.collapsingLayout_NavigationDrawer);
        collapsingLayout.setTitle("Fragment 2");
        return inflater.inflate(R.layout.fragment_navigation_drawer_2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}