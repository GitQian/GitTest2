package com.mesada.gittest.activity.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mesada.gittest.R;

import java.util.List;

public class RecyclerViewEasyActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclervieweasy);

        recyclerView = (RecyclerView) findViewById(R.id.rv_recyclervieweasy);
//        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewEasyActivity.this));
//        recyclerView.setLayoutManager(new GridLayoutManager(RecyclerViewEasyActivity.this, 3));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,1));
        recyclerView.setAdapter(new MyAdapter());

    }

    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(RecyclerViewEasyActivity.this).inflate(R.layout.recyclerview_easy_item, parent, false);

            MyViewHolder myViewHolder = new MyViewHolder(v);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText("RecyclerView测试！" + position);
        }

        @Override
        public int getItemCount() {
            return 40;
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) (itemView).findViewById(R.id.tv_recyclerview_item);
        }
    }
}
