package ste.com.tp_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txvMainActivityNumber;
    private Integer numberAdd;
    private final float textSize = 25;
    private int count = 0;


    private Button btnMainActivitySubstract, btnMainActivityZoom, btnMainActivityZoomMinus,
            btnMainActivityHidden, btnMainActivityReset, btnMainActivityAdd, btnMainActivityBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        numberAdd = 0;
        findviews();
        txvMainActivityNumber.setTextSize(textSize);
        btnMainActivityAdd.setOnClickListener(BtnAddListener);
        btnMainActivitySubstract.setOnClickListener(BtnSubstractListener);
        btnMainActivityZoom.setOnClickListener(BtnZoomListener);
        btnMainActivityZoomMinus.setOnClickListener(BtnZoomMinusListener);
        btnMainActivityHidden.setOnClickListener(BtnHiddenListener);
        btnMainActivityReset.setOnClickListener(BtnResetListener);
    }

    // this event will enable the back
    // function to the button on press
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void findviews(){
        txvMainActivityNumber     = findViewById(R.id.txvMainActivityNumber);
        btnMainActivityAdd        = findViewById(R.id.btnMainActivityAdd);
        btnMainActivitySubstract  = findViewById(R.id.btnMainActivitySubstract);
        btnMainActivityZoom       = findViewById(R.id.btnMainActivityZoom);
        btnMainActivityZoomMinus  = findViewById(R.id.btnMainActivityZoomMinus);
        btnMainActivityHidden     = findViewById(R.id.btnMainActivityHidden);
        btnMainActivityReset      = findViewById(R.id.btnMainActivityReset);
        btnMainActivityBack       = findViewById(R.id.btnMainActivityBack);


        btnMainActivityBack.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(intent);
        });

    }

    private final View.OnClickListener BtnAddListener = new View.OnClickListener(){
        @SuppressLint("SetTextI18n")
        public void onClick(View v){
           numberAdd = numberAdd +1;
           txvMainActivityNumber.setText(numberAdd.toString());
        }
    };

    private final View.OnClickListener BtnSubstractListener = new View.OnClickListener(){
        @SuppressLint("SetTextI18n")
        public void onClick(View v){
            String number = String.valueOf(txvMainActivityNumber.getText());
            if(Integer.parseInt(number) == 0){
                return;
            }
            numberAdd = numberAdd - 1;
            txvMainActivityNumber.setText(numberAdd.toString());
        }
    };
    private final View.OnClickListener BtnZoomListener = new View.OnClickListener(){
        public void onClick(View v){
            switch (count){
                case 0 : txvMainActivityNumber.setTextSize(28);
                         count++;
                         break;
                case 1 : txvMainActivityNumber.setTextSize(30);
                         count++;
                         break;
                case 2 : txvMainActivityNumber.setTextSize(32);
                         count++;
                         break;
                case 3 : txvMainActivityNumber.setTextSize(34);
                         count++;
                         break;
                case 4 : txvMainActivityNumber.setTextSize(36);
                         count++;
                         break;
            }
        }
    };
    private final View.OnClickListener BtnZoomMinusListener = new View.OnClickListener(){
        public void onClick(View v){
            switch (count){
                case 5 : txvMainActivityNumber.setTextSize(34);
                         count--;
                         break;
                case 4 : txvMainActivityNumber.setTextSize(32);
                         count--;
                         break;
                case 3 : txvMainActivityNumber.setTextSize(30);
                         count--;
                         break;
                case 2 : txvMainActivityNumber.setTextSize(28);
                         count--;
                         break;
                case 1 : txvMainActivityNumber.setTextSize(26);
                         count--;
                         break;
            }
        }

    };
    private final View.OnClickListener BtnHiddenListener = new View.OnClickListener(){
        public void onClick(View v){
            txvMainActivityNumber.setVisibility(View.INVISIBLE);
        }
    };
    private final View.OnClickListener BtnResetListener = new View.OnClickListener(){
        @SuppressLint("SetTextI18n")
        public void onClick(View v){
            numberAdd = 0;
            txvMainActivityNumber.setText(numberAdd.toString());
            txvMainActivityNumber.setVisibility(View.VISIBLE);
        }
    };

}