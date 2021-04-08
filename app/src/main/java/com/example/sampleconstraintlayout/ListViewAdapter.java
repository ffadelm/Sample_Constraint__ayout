package com.example.sampleconstraintlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter{
    //deklarasi variable dengan jenis data context
    Context mContext;

    //deklarasi variable dengan jenis data layout inflater
    LayoutInflater inflater;

    //deklarasi variable dengan jenis data arrayList
    private ArrayList<ClassNama> arrayList;

    //membuat konstruktor ListViewAdapter
    public ListViewAdapter(Context context){
        //Memeberi nilai mContext dengan context
        mContext = context;

        //mengatur layoutINFLATER DARI CONTEXT YANG DI BERIKAN
        inflater = LayoutInflater.from(mContext);

        //Memberikan nilai arrayList dari class ClassNama
        this.arrayList = new ArrayList<ClassNama>();

        //menambahkan semua elemen ke arrayList
        this.arrayList.addAll(Home_activity.classNamaArrayList);
    }

    public class ViewHolder{
        TextView name;
    }

    @Override
    public int getCount() {
        return Home_activity.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return Home_activity.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;

        if(view == null){
            holder = new ViewHolder();

            view = inflater.inflate(R.layout.item_listview, null);

            holder.name = (TextView) view.findViewById(R.id.tvnama_item);

            view.setTag(holder);
        }else {
            holder=(ViewHolder) view.getTag();
        }

        holder.name.setText(Home_activity.classNamaArrayList.get(i).getNama());

        return view;
    }
}

