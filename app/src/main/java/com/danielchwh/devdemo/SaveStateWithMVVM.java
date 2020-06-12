package com.danielchwh.devdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;

import com.danielchwh.devdemo.databinding.ActivitySaveStateWithMvvmBinding;

public class SaveStateWithMVVM extends AppCompatActivity {
    private ActivitySaveStateWithMvvmBinding binding;
    private SaveStateWithMVVM_ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set action bar
        getSupportActionBar().setTitle(R.string.save_state_with_mvvm);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // restore from saved state
        binding = DataBindingUtil.setContentView(this, R.layout.activity_save_state_with_mvvm);
        viewModel = new ViewModelProvider(this).get(SaveStateWithMVVM_ViewModel.class);
        binding.setData(viewModel);
        binding.setLifecycleOwner(this);
    }

    // action bar back button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
