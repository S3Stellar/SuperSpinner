package com.example.superspinner;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myspinninglib.SuperSpinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<String> quotesList;
    SuperSpinner superSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnTap = findViewById(R.id.button);

        quotesList = new ArrayList<>();
        quotesList.add("Hi");
        quotesList.add("Happy New Year");
        quotesList.add("Hope you have a good day");
        quotesList.add("Merry Christmas");

        superSpinner = findViewById(R.id.progressBar);
        superSpinner.setIcon(R.drawable.myafekaicon);
        superSpinner.setLoadingQuotes(quotesList);

        btnTap.setOnClickListener(v -> {
            superSpinner.showSpin();
            new Handler(Looper.myLooper()).postDelayed(
                    () -> superSpinner.stopSpin(), 3000);
        });
    }
}
