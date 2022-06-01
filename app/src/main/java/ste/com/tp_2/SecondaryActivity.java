package ste.com.tp_2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SecondaryActivity extends AppCompatActivity {

    private Integer precioDolar;
    private Integer precioEuro;
    private Integer precioReal;
    private Integer entradaPesos;
    private Double resultado;
    private EditText edtSecondaryActivityIngreseMonto;
    private TextView txvSecondaryActivityResultado;
    private RadioButton btnSecondaryActivityDolar;
    private RadioButton btnSecondaryActivityEuro;
    private RadioButton btnSecondaryActivityReal;
    private Button btnSecondaryActivityConvertir;
    private Button btnSecondaryActivityReiniciar;
    private Button btnSecondaryActivityBack;


    CharSequence text = "Debes ingresar un monto!";
    int duration = Toast.LENGTH_SHORT;
    Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        precioDolar = 123;
        precioEuro  = 124;
        precioReal  = 4;
        entradaPesos = 0;
        resultado = 0.0;
        findviews();
        btnSecondaryActivityConvertir.setOnClickListener(BtnConvertListener);
        btnSecondaryActivityReiniciar.setOnClickListener(BtnRestartListener);

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
        edtSecondaryActivityIngreseMonto = findViewById(R.id.edtSecondaryActivityIngreseMonto);
        txvSecondaryActivityResultado    = findViewById(R.id.txvSecondaryActivityResultado);
        btnSecondaryActivityDolar        = findViewById(R.id.btnSecondaryActivityDolar);
        btnSecondaryActivityEuro         = findViewById(R.id.btnSecondaryActivityEuro);
        btnSecondaryActivityReal         = findViewById(R.id.btnSecondaryActivityReal);
        btnSecondaryActivityConvertir    = findViewById(R.id.btnSecondaryActivityConvertir);
        btnSecondaryActivityReiniciar    = findViewById(R.id.btnSecondaryActivityReiniciar);
        btnSecondaryActivityBack         = findViewById(R.id.btnSecondaryActivityBack);

        btnSecondaryActivityBack.setOnClickListener(view -> {
            Intent intent = new Intent(SecondaryActivity.this, MenuActivity.class);
            startActivity(intent);
        });

    }

    private View.OnClickListener BtnConvertListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String pesos =  edtSecondaryActivityIngreseMonto.getText().toString();
            if(btnSecondaryActivityDolar.isChecked()){
                if(pesos == null || pesos.equals("") || pesos.trim().equals(" ")){
                    Toast.makeText(SecondaryActivity.this, text, duration).show();
                }else {
                    entradaPesos = Integer.parseInt(pesos);
                    resultado =  entradaPesos.doubleValue()/precioDolar.doubleValue();
                    txvSecondaryActivityResultado.setText(resultado.toString());
                }
            }
            if(btnSecondaryActivityEuro.isChecked()){
                if(pesos == null || pesos.equals("") || pesos.trim().equals(" ")){
                    Toast.makeText(SecondaryActivity.this, R.string.dolar, duration).show();
                }else {
                    entradaPesos = Integer.parseInt(pesos);
                    resultado = entradaPesos.doubleValue()/precioEuro.doubleValue();
                    txvSecondaryActivityResultado.setText(resultado.toString());
                }
            }
            if(btnSecondaryActivityReal.isChecked()){
                if(pesos == null || pesos.equals("") || pesos.trim().equals(" ")){
                    Toast.makeText(SecondaryActivity.this, text, duration).show();
                }else {
                    entradaPesos = Integer.parseInt(pesos);
                    resultado = entradaPesos.doubleValue()/precioReal.doubleValue();
                    txvSecondaryActivityResultado.setText(resultado.toString());
                }
            }
        }
    };


    private View.OnClickListener BtnRestartListener  = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            txvSecondaryActivityResultado.setText(R.string.resultado);
            edtSecondaryActivityIngreseMonto.getText().clear();
        }
    };

}
