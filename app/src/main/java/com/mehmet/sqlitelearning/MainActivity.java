package com.mehmet.sqlitelearning;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
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


            //veri ekleme
            //database.execSQL("INSERT INTO Muzisyenler(name , age) values ('ahmet',50)");
            //database.execSQL("INSERT INTO Muzisyenler(name , age) values ('mehmet',20)");

            //veriyi okumak
            //Cursor                            okunacak sql koları ,        bir filtreleme olucak mu onu soruyor şimdilik null
            Cursor cursor = database.rawQuery("SELECT * FROM Muzisyenler",null);
            //şimdi benim bu cursor'a hanki colonlara veya row 'lara gideceğini söylemem lazım
            //onun için name ve age'in indexlerini almam lazım

            int nameIndex = cursor.getColumnIndex("name");
            int ageIndex = cursor.getColumnIndex("age");

            //while komutu ile de kaç tane var ise hepsini okusun
            while (cursor.moveToNext()){
                System.out.println("Name: " + cursor.getString(nameIndex));
                System.out.println("Age:"+ cursor.getInt(ageIndex));
            }
            cursor.close();//komutu ilede veri okumayı durduruyorum ki sistemde fazladan yük oluşmasın

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}