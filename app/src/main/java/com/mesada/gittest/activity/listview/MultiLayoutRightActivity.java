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

public class MultiLayoutRightActivity extends AppCompatActivity {

    private final String TAG = this.getClass().toString();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multilayoutright);

        listView = (ListView) findViewById(R.id.lv_multilayoutright);

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

        @Override
        public int getItemViewType(int position) {
            return position % 2;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        /**
         * 重写getViewTypeCount()、getItemViewType
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SosViewHolder sosViewHolder = null;
            ServiceViewHolder serviceViewHolder = null;
            int type = getItemViewType(position);

            if (convertView == null) {
                switch (type) {
                    case 0:
                        convertView = LayoutInflater.from(MultiLayoutRightActivity.this).inflate(R.layout.sos_pushmsg_item, null);

                        sosViewHolder = new SosViewHolder();

                        sosViewHolder.sosChatTv = (TextView) convertView.findViewById(R.id.tv_sos_chatcontent);
                        convertView.setTag(sosViewHolder);
                        break;

                    case 1:
                        convertView = LayoutInflater.from(MultiLayoutRightActivity.this).inflate(R.layout.service_pushmsg_item, null);

                        serviceViewHolder = new ServiceViewHolder();

                        serviceViewHolder.serviceChatTv = (TextView) convertView.findViewById(R.id.tv_service_chatcontent);
                        convertView.setTag(serviceViewHolder);
                        break;

                    default:
                        break;
                }
            } else {
                switch (type) {
                    case 0:
                        sosViewHolder = (SosViewHolder) convertView.getTag();
                        break;

                    case 1:
                        serviceViewHolder = (ServiceViewHolder) convertView.getTag();
                        break;

                    default:
                        break;
                }
                Log.i(TAG, "复用");
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

