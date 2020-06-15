package com.danielchwh.devdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.danielchwh.devdemo.databinding.ActivitySaveStateWithMvvmBinding;

public class SaveStateWithMVVM extends AppCompatActivity {
    private ActivitySaveStateWithMvvmBinding binding;
    private SaveStateWithMVVM_ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set action bar title
        getSupportActionBar().setTitle(R.string.save_state_with_mvvm);

        // restore from saved state
        binding = DataBindingUtil.setContentView(this, R.layout.activity_save_state_with_mvvm);
        viewModel = new ViewModelProvider(this).get(SaveStateWithMVVM_ViewModel.class);
        binding.setData(viewModel);
        binding.setLifecycleOwner(this);
    }
}
