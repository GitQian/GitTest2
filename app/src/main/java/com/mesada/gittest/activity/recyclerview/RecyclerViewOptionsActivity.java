package com.mesada.gittest.activity.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mesada.gittest.R;

public class RecyclerViewOptionsActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerviewoptions);

        findViewById(R.id.btn_easy_recyclerviewoptions).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_easy_recyclerviewoptions:
                Intent intent = new Intent(RecyclerViewOptionsActivity.this, RecyclerViewEasyActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}
