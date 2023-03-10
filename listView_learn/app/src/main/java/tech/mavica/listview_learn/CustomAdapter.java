package tech.mavica.listview_learn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> names;
    ArrayList<String> jobs;
    ArrayList<String> salaries;
    LayoutInflater infalter;
    public  CustomAdapter(Context context,ArrayList<String> names,ArrayList<String> jobs,ArrayList<String> salaries){
        this.context=context;
        this.names=names;
        this.jobs=jobs;
        this.salaries=salaries;
        infalter=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return names.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=infalter.inflate(R.layout.list_item,null);
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_job = convertView.findViewById(R.id.tv_job);
        TextView tv_salary=convertView.findViewById(R.id.tv_salary);
        tv_name.setText(names.get(position));
        tv_job.setText(jobs.get(position));
        tv_salary.setText(salaries.get(position));
        return convertView;
    }
}
