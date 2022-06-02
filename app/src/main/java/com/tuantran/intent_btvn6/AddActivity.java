package com.tuantran.intent_btvn6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    EditText edtTitle;
    EditText edtMota;
    Button luu;
    Button huy;

    public static final String KEY_TITLE_ADD_ACTIVITY = "TITLE_ADD_Activity";
    public static final String KEY_MOTA_ADD_ACTIVITY = "MOTA_ADD_Activity";
    public static final int RESULT_ADD = 10;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
         edtTitle = findViewById(R.id.tenThuMuc);
         edtMota = findViewById(R.id.MotaThuMuc);
         luu = findViewById(R.id.btnLuuAdd);
         huy = findViewById(R.id.btnHuyADD);

         huy.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 finish();
             }
         });
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
        intent.putExtra(KEY_TITLE_ADD_ACTIVITY,edtTitle.getText().toString());
        intent.putExtra(KEY_MOTA_ADD_ACTIVITY,edtMota.getText().toString());
        setResult(RESULT_ADD,intent);
        super.onBackPressed();
    }
}
