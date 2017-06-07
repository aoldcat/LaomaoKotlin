package com.laomao.kt.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.laomao.kt.R;
import com.laomao.kt.di.component.DaggerIUserTestComponent;
import com.laomao.kt.bean.UserTestModel;

import javax.inject.Inject;

public class TestActivity extends AppCompatActivity {
    @Inject
    UserTestModel userTestModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        DaggerIUserTestComponent.builder().build().inject(this);
        userTestModel.setName("laomao");
        Toast.makeText(this,userTestModel.getName(),Toast.LENGTH_SHORT).show();
    }
}
