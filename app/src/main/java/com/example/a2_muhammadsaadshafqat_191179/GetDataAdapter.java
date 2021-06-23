package com.example.a2_muhammadsaadshafqat_191179;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class GetDataAdapter extends RecyclerView.Adapter<GetDataAdapter.viewholder> {
    Context context;
   ArrayList<ModelData> dataholder;

    public GetDataAdapter(Context context, ArrayList<ModelData> dataholder) {
        this.context = context;
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public GetDataAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.item,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetDataAdapter.viewholder holder, int position) {
holder.textView1.setText(dataholder.get(position).getId());
holder.textView2.setText(dataholder.get(position).getName());
holder.textView3.setText(dataholder.get(position).getCity());
holder.textView4.setText(dataholder.get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView textView1,textView2,textView3,textView4;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.stdid);
            textView2=itemView.findViewById(R.id.heading);
            textView3=itemView.findViewById(R.id.stdcity);
            textView4=itemView.findViewById(R.id.stdage);
        }
    }
}
