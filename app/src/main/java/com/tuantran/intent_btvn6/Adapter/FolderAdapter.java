package com.tuantran.intent_btvn6.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.tuantran.intent_btvn6.EditActivity;
import com.tuantran.intent_btvn6.MainActivity;
import com.tuantran.intent_btvn6.Model.Folder;
import com.tuantran.intent_btvn6.OnClickListener;
import com.tuantran.intent_btvn6.R;

import java.util.ArrayList;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.MyViewHolder> {

    public static final String KEY_TITLE = "key_vitri";
    int pos;

    private ArrayList<Folder> arrayList;
    private OnClickListener listener;

    public FolderAdapter(ArrayList<Folder> arrayList, OnClickListener listener) {
        this.arrayList = arrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context =parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =  inflater.inflate(R.layout.item_folder,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Folder  folder = arrayList.get(position);
        holder.title.setText(folder.getTitle());
        holder.mota.setText(folder.getMota());
        holder.folder = arrayList.get(position);

        //gửi data từ Folder Adapter -> editActivity
//        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

//    private void onClickGoToEdit(Folder folder) {
//        Intent intent = new Intent(context, EditActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("oblectFolder",folder);
//        intent.putExtras(bundle);
//        context.startActivity(intent);
//    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        Folder folder;
        private RelativeLayout layoutItem;
        TextView title;
        TextView mota;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleThuMuc);
            mota = itemView.findViewById(R.id.motaThuMuc);
            layoutItem = itemView.findViewById(R.id.laout_item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pos = getAdapterPosition();
                    //Toast.makeText(v.getContext(), pos + "vị trí", Toast.LENGTH_SHORT).show();
                    listener.itemClick(folder);
                }
            });

        }
    }




}
