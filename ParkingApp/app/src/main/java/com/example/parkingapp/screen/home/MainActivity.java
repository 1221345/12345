package com.example.parkingapp.screen.home;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.parkingapp.R;
import com.example.parkingapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewBinding();
        setupUi();
    }

    private void initViewBinding() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    private void setupUi() {
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, binding.navigationDrawer, binding.toolbarId.toolbar, R.string.open, R.string.close);
        binding.navigationDrawer.addDrawerListener(drawerToggle);
        binding.navigationDrawer.setClickable(true);
        drawerToggle.syncState();
        setupNavigationView();
    }

    private void setupNavigationView() {
        binding.toolbarId.toolbarBackButton.setVisibility(View.GONE);
        binding.mDrawerLayout.setNavigationItemSelectedListener(item -> {
            switchScreen(item.getItemId());
            return true;
        });
    }

    private void switchScreen(int id) {
        switch (id) {
            case R.id.menuItemLogout:
                binding.navigationDrawer.closeDrawers();
                //TODO Logout
                break;
            case R.id.menuItemExit:
                binding.navigationDrawer.closeDrawers();
                finish();
                break;
        }
    }
}