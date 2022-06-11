package ste.com.tp_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContactActivity extends AppCompatActivity {

    private Button btnContactActivityCallMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        findviews();
        btnContactActivityCallMe.setOnClickListener(BtnCallMeListener);


    }

    private void findviews() {
        btnContactActivityCallMe = findViewById(R.id.btnContactActivityCallMe);
    }

    @SuppressLint("QueryPermissionsNeeded")
    private void dialPhoneNumber() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:2954574599"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private final View.OnClickListener BtnCallMeListener = view -> dialPhoneNumber();



}