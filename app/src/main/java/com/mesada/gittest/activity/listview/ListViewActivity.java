package com.mesada.gittest.activity.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mesada.gittest.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        listView = (ListView) findViewById(R.id.lv_listview);

        list = new ArrayList<String>();
        list.add("qiansheng");
        list.add("zhouzhiqiang");
        list.add("liuhuan");
        list.add("laozhu");
        list.add("qiansheng");
        list.add("zhouzhiqiang");
        list.add("liuhuan");
        list.add("laozhu");
        list.add("qiansheng");
        list.add("zhouzhiqiang");
        list.add("liuhuan");
        list.add("laozhu");
        list.add("qiansheng");
        list.add("zhouzhiqiang");
        list.add("liuhuan");
        list.add("laozhu");
        list.add("qiansheng");
        list.add("zhouzhiqiang");
        list.add("liuhuan");
        list.add("laozhu");
        list.add("qiansheng");
        list.add("zhouzhiqiang");
        list.add("liuhuan");
        list.add("laozhu");
        list.add("qiansheng");
        list.add("zhouzhiqiang");
        list.add("liuhuan");
        list.add("laozhu");
        list.add("qiansheng");
        list.add("zhouzhiqiang");
        list.add("liuhuan");
        list.add("laozhu");
        list.add("qiansheng");
        list.add("zhouzhiqiang");
        list.add("liuhuan");
        list.add("laozhu");

        listView.setAdapter(new MyAdapter());
    }


    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            //TODO getItem()有什么用？
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            //TODO getItemId()有什么用？
            return position;
        }

        /**
         * 复用可以通过convertView和ViewHolder对象完成
         * 初次加载可见的item时，convertView为null
         * 加载隐藏的item时，convertView不为null，convertView为最后一个划出的item复用
         * 布局一样的话，可以通过setTag()、getTag()获取ViewHolder对象，避免多次findViewById()
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                //加载布局
                convertView = LayoutInflater.from(ListViewActivity.this).inflate(R.layout.activity_listview_item, null);
                //findview赋值给ViewHolder对象
                viewHolder = new ViewHolder();
                viewHolder.itemTv = (TextView) convertView.findViewById(R.id.tv_list_item);

                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            //这里做View真正工作
            viewHolder.itemTv.setText(list.get(position));
            return convertView;
        }
    }

    private class ViewHolder{
        TextView itemTv;
    }
}
