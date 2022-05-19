package ste.com.tp_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        findViews();
        }

    private void findViews(){
        Button btnMenuMainActivity = findViewById(R.id.btnMenuMainActivity);
        Button btnMenuOtherActivity = findViewById(R.id.btnMenuOtherActivity);

        btnMenuOtherActivity.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, SecondaryActivity.class);
            startActivity(intent);
        });

        btnMenuMainActivity.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

}