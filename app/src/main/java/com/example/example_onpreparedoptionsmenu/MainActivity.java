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

    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        res/menu/items.xml -> 파일 추가
        activity_main.xml -> id 수정
         */

        TextView tv = findViewById(R.id.tv);
        tv.setOnClickListener(v -> {
            // 클릭으로 메뉴가 추가되는 것을 확인하기 위해 boolean flag를 추가하여 사용합니다.
            flag = true; // 처음 값을 false로 두고 클릭 시 true로 변경합니다.
            Log.i(this.getClass().getSimpleName(), "tv clicked"); // tv를 클릭했다고 로그를 남깁니다.
            invalidateOptionsMenu(); // 메뉴를 다시 그립니다. 이 메소드를 호출하여 onPrepareOptionsMenu()가 호출됩니다.
        });
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // 메뉴를 다시 그릴 때 호출됩니다.
        Log.i(this.getClass().getSimpleName(), "onPrepareOptionsMenu");
        if (flag) { // flag가 true일 때만 메뉴를 추가합니다. 클릭 시 flag가 true로 변경됩니다.
            getMenuInflater().inflate(R.menu.items, menu); // 메뉴를 추가합니다.
            flag = false; // flag를 다시 false로 변경합니다.
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // 클릭 했던 메뉴의 id를 로그로 남깁니다.
        Log.i(this.getClass().getSimpleName(), "onOptionsItemSelected id = " + item.getItemId());
        return true;
    }
}