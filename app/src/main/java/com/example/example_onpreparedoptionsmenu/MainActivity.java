package com.example.example_onpreparedoptionsmenu;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.tv);
        tv.setOnClickListener(v -> invalidateOptionsMenu());
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.i(this.getClass().getSimpleName(), "onPrepareOptionsMenu");
        if (menu.size() == 0) {
            getMenuInflater().inflate(R.menu.items, menu);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.i(this.getClass().getSimpleName(), "onOptionsItemSelected id = " + item.getItemId());
        return true;
    }
}