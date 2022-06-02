package com.tuantran.intent_btvn6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.tuantran.intent_btvn6.Adapter.FolderAdapter;
import com.tuantran.intent_btvn6.Model.Folder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener{//
    public static final String KEY_FOLDER = "key_folder";
    public static final int REQUEST_CODE_TO_EDIT_ACTIVITY = 101;
    public static final int REQUEST_CODE_TO_ADD_ACTIVITY = 102;

    RecyclerView recyclerView;
    Toolbar toolbar;
    ArrayList<Folder> arrayList;
    FolderAdapter adapter;
    String tieude;
    String mota;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // sửa
        if(requestCode == REQUEST_CODE_TO_EDIT_ACTIVITY){
            if(resultCode == RESULT_OK){
                tieude = data.getStringExtra(EditActivity.KEY_TITLE);
                mota = data.getStringExtra(EditActivity.KEY_MOTA);
                Toast.makeText(this, tieude + mota, Toast.LENGTH_SHORT).show();

                adapter.notifyDataSetChanged();
            }
        }
        // thêm
        if(requestCode == REQUEST_CODE_TO_ADD_ACTIVITY){
            if(resultCode == AddActivity.RESULT_ADD){
                tieude = data.getStringExtra(AddActivity.KEY_TITLE_ADD_ACTIVITY);
                mota = data.getStringExtra(AddActivity.KEY_MOTA_ADD_ACTIVITY);
                arrayList.add(new Folder(tieude,mota));
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        innitToolbar();
        innitView();

    }

    private void innitView() {
        recyclerView = findViewById(R.id.recyclefolder);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        arrayList = new ArrayList<>();
        arrayList.add(new Folder("Tổng hợp in tức thời sự","Tổng hợp tất cả các tin tức nổi bật nhất hiện nay,Tổng hợp tất cả các tin tức nổi bật nhất hiện nay,Tổng hợp tất cả các tin tức nổi bật nhất hiện nay"));
        arrayList.add(new Folder("Tổng hợp in tức thời sự","Tổng hợp tất cả các tin tức nổi bật nhất hiện nay"));
        arrayList.add(new Folder("Tổng hợp in tức thời sự","Tổng hợp tất cả các tin tức nổi bật nhất hiện nay"));
        arrayList.add(new Folder("Tổng hợp in tức thời sự","Tổng hợp tất cả các tin tức nổi bật nhất hiện nay"));
        arrayList.add(new Folder("Tổng hợp in tức thời sự","Tổng hợp tất cả các tin tức nổi bật nhất hiện nay"));
        arrayList.add(new Folder("Tổng hợp in tức thời sự","Tổng hợp tất cả các tin tức nổi bật nhất hiện nay"));
        arrayList.add(new Folder("Tổng hợp in tức thời sự","Tổng hợp tất cả các tin tức nổi bật nhất hiện nay"));
        arrayList.add(new Folder("Tổng hợp in tức thời sự","Tổng hợp tất cả các tin tức nổi bật nhất hiện nay"));
        arrayList.add(new Folder("Tổng hợp in tức thời sự","Tổng hợp tất cả các tin tức nổi bật nhất hiện nay"));

        adapter = new FolderAdapter(arrayList,this);
        recyclerView.setAdapter(adapter);


    }

    private void innitToolbar() {
         toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_24);
        toolbar.inflateMenu(R.menu.menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.them:
                        Intent intent = new Intent(MainActivity.this,AddActivity.class);
                            startActivityForResult(intent,REQUEST_CODE_TO_ADD_ACTIVITY);
                        break;
                }
                return false;
            }
        });
    }


    @Override
    public void itemClick(Folder folder) {
        Intent intent = new Intent(MainActivity.this, EditActivity.class);
        intent.putExtra(KEY_FOLDER,folder);
        startActivityForResult(intent,REQUEST_CODE_TO_EDIT_ACTIVITY);



    }
}