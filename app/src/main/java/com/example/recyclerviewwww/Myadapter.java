package com.example.recyclerviewwww;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter  extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private ArrayList<Data> mdata;
    private Context mcontext;
    public Myadapter(Context context, ArrayList<Data> data)
    {
        this.mdata = data;
        this.mcontext = context;
    }
    // 是用來連結畫面
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        return new ViewHolder(view);
    }
    //  用來控制剛剛宣告的物件
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data d = mdata.get(position);
        holder.tv1.setText(String.valueOf(d.id));
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext,d.text,Toast.LENGTH_SHORT).show();
            }
        });
    }
    // 顯示幾筆資料
    @Override
    public int getItemCount() {
        return mdata.size();
    }

    // 宣告畫面元件
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv1;
        private Button btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            btn = itemView.findViewById(R.id.btn);

        }
    }
}
