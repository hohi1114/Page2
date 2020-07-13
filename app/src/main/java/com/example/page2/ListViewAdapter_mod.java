package com.example.page2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ListViewAdapter_mod extends BaseAdapter {

    private Context context;
    private List<Customer> list;
    private LayoutInflater inflate;
    private ViewHolder viewHolder;

    public ListViewAdapter_mod(List<Customer> list, Context context){
        this.list = list;
        this.context = context;
        this.inflate = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView==null){
            convertView = inflate.inflate(R.layout.listview_item, null);

            viewHolder = new ViewHolder();

            viewHolder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
            viewHolder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
            viewHolder.imageView=  (ImageView)convertView.findViewById(R.id.imageView1);

            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.imageView.setImageDrawable(list.get(position).getImage());
        viewHolder.textView1.setText(list.get(position).getName());
        viewHolder.textView2.setText(list.get(position).getPhone());

        return convertView;
    }

    class ViewHolder{
        public TextView textView1;
        public TextView textView2;
        public ImageView imageView;
    }
}
