package com.tuantran.intent_btvn6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tuantran.intent_btvn6.Model.Folder;

public class EditActivity extends AppCompatActivity {
    public static final String KEY_TITLE = "key_title";
    public static final String KEY_MOTA = "key_mota";
    EditText edtTiltle ;
    EditText edtMota ;
    Button huy ;
    Button luu;
    Folder folder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        edtTiltle = findViewById(R.id.tenThuMuc);
        edtMota = findViewById(R.id.MotaThuMuc);
        huy = findViewById(R.id.btnHuy);
        luu = findViewById(R.id.btnLuu);

        // nhận dữ liệu từ main activity
//        Bundle bundle = getIntent().getExtras();
//        if(bundle == null){
//            return;
//        }
//        Folder folder = (Folder) bundle.get("oblectFolder");
//        edtTiltle.setText(folder.getTitle());
//        edtMota.setText(folder.getMota());

        folder = (Folder) getIntent().getSerializableExtra(MainActivity.KEY_FOLDER);
        edtTiltle.setText(folder.getTitle());
        edtMota.setText(folder.getMota());

        //Intent intent = getIntent();
//        if(intent!=null){
//            folder = (Folder) intent.getSerializableExtra("key_folder");
//            edtTiltle.setText(folder.getTitle());
//            edtMota.setText(folder.getMota());
//        }


        // xét btn hủy
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // xét btn Lưu
        luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = getIntent();
        intent.putExtra(KEY_TITLE,edtTiltle.getText().toString());
        intent.putExtra(KEY_MOTA,edtMota.getText().toString());
        setResult(RESULT_OK,intent);
        super.onBackPressed();
    }
}