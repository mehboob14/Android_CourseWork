package com.day1.myapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends ComponentActivity {


    Button btn;
    Button impbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btn =findViewById(R.id.btn);
         impbtn =findViewById(R.id.newbtn);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Newactivity.class);
                intent.putExtra("key","Hello, Android");
                intent.putExtra("key", "Android");
                startActivity(intent);

            }
        }

        );
        impbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://youtube.com"));
                startActivity(i);
            }

        }
        );
    }


   @Override
   public void onStop(){
        super.onStop();
       Log.d("life cycle", "on stop method invokded");
   }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "onStart invoked");
        Toast.makeText(this, " on start method invokded", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d("LifeCycle", "On Resume invoked");Toast.makeText(this, " on start method invokded", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d("lifecycle","on pause invokded");
    }

}
