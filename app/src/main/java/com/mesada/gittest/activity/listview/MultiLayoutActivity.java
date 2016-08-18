package com.mesada.gittest.activity.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mesada.gittest.R;

public class MultiLayoutActivity extends AppCompatActivity {

    private final String TAG = this.getClass().toString();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multilayout);

        listView = (ListView) findViewById(R.id.lv_multilayout);

        listView.setAdapter(new MyAdapter());
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 40;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        /**
         * 通过log发现，复用率跟划动速度还有关系
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SosViewHolder sosViewHolder = null;
            ServiceViewHolder serviceViewHolder = null;
            if (convertView == null) {
                if (position % 2 == 0) {
                    convertView = LayoutInflater.from(MultiLayoutActivity.this).inflate(R.layout.sos_pushmsg_item, null);

                    sosViewHolder = new SosViewHolder();

                    sosViewHolder.sosChatTv = (TextView) convertView.findViewById(R.id.tv_sos_chatcontent);
                    convertView.setTag(sosViewHolder);
                } else {
                    convertView = LayoutInflater.from(MultiLayoutActivity.this).inflate(R.layout.service_pushmsg_item, null);

                    serviceViewHolder = new ServiceViewHolder();

                    serviceViewHolder.serviceChatTv = (TextView) convertView.findViewById(R.id.tv_service_chatcontent);
                    convertView.setTag(serviceViewHolder);
                }


            } else {
                if (position % 2 == 0) {

                    if (convertView.getTag() instanceof SosViewHolder) {
                        sosViewHolder = (SosViewHolder) convertView.getTag();
                        Log.i(TAG, "复用");
                    } else {
                        //偶数，但convertView不一样
                        convertView = LayoutInflater.from(MultiLayoutActivity.this).inflate(R.layout.sos_pushmsg_item, null);
                        sosViewHolder = new SosViewHolder();
                        sosViewHolder.sosChatTv = (TextView) convertView.findViewById(R.id.tv_sos_chatcontent);
                        convertView.setTag(sosViewHolder);
                        Log.i(TAG, "没有复用");
                    }

                } else {
                    if (convertView.getTag() instanceof ServiceViewHolder) {
                        serviceViewHolder = (ServiceViewHolder) convertView.getTag();
                        Log.i(TAG, "复用");
                    } else {
                        //奇数，但convertView不一样
                        convertView = LayoutInflater.from(MultiLayoutActivity.this).inflate(R.layout.service_pushmsg_item, null);
                        serviceViewHolder = new ServiceViewHolder();
                        serviceViewHolder.serviceChatTv = (TextView) convertView.findViewById(R.id.tv_service_chatcontent);
                        convertView.setTag(serviceViewHolder);
                        Log.i(TAG, "没有复用");
                    }

                }

            }

            if (position % 2 == 0) {
                sosViewHolder.sosChatTv.setText("这是消息！");
            } else {
                serviceViewHolder.serviceChatTv.setText("这也是消息！");
            }


            return convertView;
        }
    }

    private class SosViewHolder {
        ImageView soschatImg;
        TextView sosChatTv;
    }

    private class ServiceViewHolder {
        TextView serviceChatTv;
    }
}
