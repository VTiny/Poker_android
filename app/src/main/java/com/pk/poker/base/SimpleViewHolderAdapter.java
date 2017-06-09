package com.pk.poker.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pk.poker.R;

import java.util.List;

/**
 * Description: item仅有一个TextView的ListView的Adapter
 * Author: liuxiao
 * Date: 2017/6/9
 */

public class SimpleViewHolderAdapter extends BaseAdapter {

    private List<String> mData;
    private LayoutInflater mInflater;

    public SimpleViewHolderAdapter(Context context, List<String> data) {
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_simple_list_view, null);
//            holder.img = (ImageView) convertView.findViewById(R.id.img);
            holder.title = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
//        holder.img.setBackgroundResource(ic_launcher);
        holder.title.setText(mData.get(position));
        return convertView;
    }

    private final class ViewHolder{
//        public ImageView img;
        public TextView title;
    }
}
