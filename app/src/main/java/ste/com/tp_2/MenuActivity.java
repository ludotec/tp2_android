package ste.com.tp_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private Button btnMenuMainActivity, btnMenuOtherActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        findViews();
        }

    private void findViews(){
        btnMenuMainActivity = findViewById(R.id.btnMenuMainActivity);
        btnMenuOtherActivity = findViewById(R.id.btnMenuOtherActivity);

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