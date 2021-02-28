package com.rku_18fotca11002.tutorial07;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.GestureDescription;
import android.content.Intent;
import android.media.tv.TvContract;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        textView = findViewById(R.id.txtWelcome);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        textView.setText("Welcome, "+username);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        switch (id){
            case R.id.logout:
                startActivity(new Intent(Welcome.this, Login.class));
                finish();
                return true;

            case R.id.about:
                Toast.makeText(this, "No information available", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}