package com.mesada.gittest.activity.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mesada.gittest.R;

public class ListOptionsActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listoptions);

        findViewById(R.id.btn_convert_listoptions).setOnClickListener(this);
        findViewById(R.id.btn_multi_listoptions).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_convert_listoptions:
                Intent intent = new Intent(ListOptionsActivity.this, ListViewActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_multi_listoptions:
                Intent intent1 = new Intent(ListOptionsActivity.this, MultiLayoutActivity.class);
                startActivity(intent1);
                break;

            default:

                break;
        }
    }
}
