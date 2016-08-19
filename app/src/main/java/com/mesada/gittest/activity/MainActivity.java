package com.mesada.gittest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mesada.gittest.R;
import com.mesada.gittest.activity.listview.ListOptionsActivity;
import com.mesada.gittest.activity.listview.ListViewActivity;
import com.mesada.gittest.activity.recyclerview.RecyclerViewOptionsActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button listviewBtn;
    private Button recyclerviewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_listview_main).setOnClickListener(this);
        findViewById(R.id.btn_recyclerview_main).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_listview_main:
                Intent intent = new Intent(MainActivity.this, ListOptionsActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_recyclerview_main:
                Intent intent1 = new Intent(MainActivity.this, RecyclerViewOptionsActivity.class);
                startActivity(intent1);
                break;

            default:

                break;
        }
    }
}
