package com.danielchwh.devdemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/*
 * Set tab name in layout xml is useless
 * Tab name need to be set in TabLayoutMediator by coding
 */

public class ViewPager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        // Set action bar title
        getSupportActionBar().setTitle(R.string.view_pager);

        TabLayout tabLayout = findViewById(R.id.tabLayout_ViewPager);
        ViewPager2 viewPager = findViewById(R.id.viewPager_ViewPager);

        viewPager.setAdapter(new FragmentStateAdapter(this) {
            // Return the number of page
            @Override
            public int getItemCount() {
                return 2;
            }

            // Return the fragment class of each page
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                if (position == 0)
                    return new ViewPager_Fragment1();
                else
                    return new ViewPager_Fragment2();
            }
        });

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            // Set the name of each page
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0)
                    tab.setText("Fragment 1");
                else
                    tab.setText("Fragment 2");
            }
        });
        tabLayoutMediator.attach();
    }
}