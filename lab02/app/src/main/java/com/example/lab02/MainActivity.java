package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lab2","metoda OnCreate");
        Toast.makeText(this,"Meroda onCreate",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();

        Log.d("Lab2","metoda OnResume");
        Toast.makeText(this,"Metoda onresume",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();// odwołać się do metody rodzicielskiej

        Log.d("Lab2","metoda OnPausee");
        Toast.makeText(this,"metoda OnPausee",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();// odwołać się do metody rodzicielskiej

        Log.d("Lab2","metoda OnStop");
        Toast.makeText(this,"metoda OnStop",Toast.LENGTH_SHORT).show();
    }
}
