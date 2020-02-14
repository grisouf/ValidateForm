package com.gridev.validateform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      FragmentManager manager =  getSupportFragmentManager();
      Fragment fragment = new FormValidationFragment();

      manager.beginTransaction().replace(R.id.main_activity_container, fragment).commit();
    }
}
