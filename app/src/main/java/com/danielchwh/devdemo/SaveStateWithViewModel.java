package com.danielchwh.devdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;

import com.danielchwh.devdemo.databinding.ActivitySaveStateWithViewModelBinding;

public class SaveStateWithViewModel extends AppCompatActivity {
    ActivitySaveStateWithViewModelBinding binding;
    NumberCounter counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set action bar
        getSupportActionBar().setTitle(R.string.save_state_with_view_model);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // restore from saved state
        binding = DataBindingUtil.setContentView(this, R.layout.activity_save_state_with_view_model);
        counter = new ViewModelProvider(this).get(NumberCounter.class);
        binding.setData(counter);
        binding.setLifecycleOwner(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
