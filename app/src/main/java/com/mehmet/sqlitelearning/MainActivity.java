package com.mehmet.sqlitelearning;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            //SQLiteDatabase database = this.openOrCreateDatabase(datanın ismi , modu(public,private) ,factory)
            SQLiteDatabase database = this.openOrCreateDatabase("deneme1",MODE_PRIVATE,null);
            //                       IF NOT EXISTS ==> EĞER BÖYLE BİR TABLO YOKSA OLUŞTUR
            //                                                     tablo isminden sonra colonları ve veri tiplerini yazmamız gerekiyor
            database.execSQL("CREATE TABLE IF NOT EXISTS Muzisyenler(name VARCHAR , age INT)");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}