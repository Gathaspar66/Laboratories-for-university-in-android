package com.example.lab03;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.lab03.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.provider.MediaStore;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
static final int id_action=1;
private Button komunikat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        komunikat=findViewById(R.id.komunikat);
        komunikat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"komunikat",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void kliknij(View View)
    {
      Toast.makeText(getApplicationContext(),"kliknieto przycisk buttton",Toast.LENGTH_SHORT).show();
        Intent intencja = new Intent(this, LoginActivity.class);
       startActivity(intencja);

    }

    public void kliknij3(View view)
    {
            Random r =new Random();
            int id=r.nextInt(2);
            Drawable d =getDrawableById(id);
            changeBackground((Button)view,d);



    }
    private Drawable getDrawableById(int id){
        switch(id){
            case 0:
                return getResources().getDrawable(R.drawable.ic_launcher_background,getTheme());
            case 1:
                return getResources().getDrawable(R.drawable.ic_launcher_foreground,getTheme());
        }

        return null;
    }



    private void changeBackground(Button v,Drawable drawable){

        v.setCompoundDrawablesWithIntrinsicBounds(drawable,null,null,null);
    }

    

    public void kliknij2(View View)
    {
        //    Toast.makeText(getApplicationContext(),"kliknieto przycisk buttton",Toast.LENGTH_SHORT).show();
        //  Intent intencja = new Intent(this, LoginActivity.class);
         if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED) {
             ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, id_action);

         }

        //   startActivity(intencja);
          Intent intencja = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
          startActivityForResult(intencja,id_action);


    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data)
    {
    super.onActivityResult(requestCode,resultCode,data);
        Bundle extras = data.getExtras();
        Bitmap imageBitmap=(Bitmap) extras.get("data");
        ConstraintLayout lay =(ConstraintLayout)findViewById(R.id.cont);
        lay.setBackground(new BitmapDrawable(getResources(), imageBitmap));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id){
            case R.id.a:
                Toast.makeText(getApplicationContext(),"kliknieto przycisk item",Toast.LENGTH_SHORT).show();
                break;
            case R.id.b:
                Toast.makeText(getApplicationContext(),"kliknieto przycisk settings",Toast.LENGTH_SHORT).show();
                break;
            default:

        }


     //   if (id == R.id.action_settings) {
      //      return true;
      //  }

        return super.onOptionsItemSelected(item);
    }
}
