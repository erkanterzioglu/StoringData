package com.erkanterzioglu.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText yasgir;
    TextView sonuc;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yasgir = findViewById(R.id.yasgir);
        sonuc = findViewById(R.id.sonuc);

        sharedPreferences = this.getSharedPreferences("com.erkanterzioglu.storingdata", Context.MODE_PRIVATE);
        int storedAge = sharedPreferences.getInt("storedAge", 0);
        if (storedAge == 0) {
            sonuc.setText("Your age: ");
        }

        else   {
            sonuc.setText("Your age: " + storedAge);
        }
    }







        public void save (View view){
            if (!yasgir.getText().toString().matches("")) {
                int userAge = Integer.parseInt(yasgir.getText().toString());
                sonuc.setText("Your age: " + userAge);

                sharedPreferences.edit().putInt("storedAge", userAge).apply();


            }


        }


        public void delete(View view ){

        int storedData = sharedPreferences.getInt("storedAge",0);

        if(storedData!=0){
            sharedPreferences.edit().remove("storedAge").apply();
            sonuc.setText("Your age: ");

        }

        }


    }
