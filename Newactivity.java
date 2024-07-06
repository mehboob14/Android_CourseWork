package com.day1.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Newactivity extends AppCompatActivity {

    private Button btnC ;
    private Button btnR ;
    private TextView txtC;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_newactivity);


      //  btnC = findViewById(R.id.btnCount);
      //  btnR = findViewById(R.id.btnRest);
        //txtC = findViewById(R.id.textCount);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });   // possible to override multiple times

        btnC = findViewById(R.id.btnCount);
        btnR = findViewById(R.id.btnRest);
        txtC = findViewById(R.id.textCount);
        CountFunc();
    }

    private void CountFunc() {
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                txtC.setText("" + count);
                Toast.makeText(Newactivity.this, "Count Button was clicked", Toast.LENGTH_SHORT).show();
            }
        });
        Bundle bun = getIntent().getExtras();
        String value = bun.getString("key");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                txtC.setText("" + count);
                Toast.makeText(Newactivity.this, "Reset Button was clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
