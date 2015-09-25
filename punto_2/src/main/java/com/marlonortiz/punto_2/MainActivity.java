package com.marlonortiz.punto_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
//import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText op1, op2;
    private RadioButton sumar,restar,multi,divi;
    private Button calcular;
    private TextView rtado;
    private int op1ok=0,op2ok=0;
    private int operacion=0;
    private double rpta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        op1=(EditText) findViewById(R.id.op1);
        op2=(EditText) findViewById(R.id.op2);
        sumar=(RadioButton) findViewById(R.id.sumar);
        restar=(RadioButton) findViewById(R.id.restar);
        multi=(RadioButton) findViewById(R.id.multi);
        divi=(RadioButton) findViewById(R.id.divi);
        calcular=(Button) findViewById(R.id.calcular);
        rtado=(TextView) findViewById(R.id.result);

        op1.setText("");
        op2.setText("");

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                op1ok=op1.getText().toString().compareTo("");
                op2ok=op2.getText().toString().compareTo("");
                if(op1ok!=0 && op2ok!=0 && operacion!=0){
                    Toast.makeText(MainActivity.this,"Calculado!!!",Toast.LENGTH_LONG).show();
                    switch (operacion){
                        case 1:
                            rpta=Double.parseDouble(op1.getText().toString())+Double.parseDouble(op2.getText().toString());
                            break;
                        case 2:
                            rpta=Double.parseDouble(op1.getText().toString())-Double.parseDouble(op2.getText().toString());
                            break;
                        case 3:
                            rpta=Double.parseDouble(op1.getText().toString())*Double.parseDouble(op2.getText().toString());
                            break;
                        case 4:
                            rpta=Double.parseDouble(op1.getText().toString())/Double.parseDouble(op2.getText().toString());
                            break;
                    }
                    rtado.setText(Double.toString(rpta));
                } else{
                    Toast.makeText(MainActivity.this,"Vuelva a intentarlo!!!",Toast.LENGTH_LONG).show();
                }
                op1.setText("");
                op2.setText("");
                operacion=0;
                sumar.setChecked(false);
                restar.setChecked(false);
                multi.setChecked(false);
                divi.setChecked(false);
            }
        });

        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion=1;
            }
        });
        restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion=2;
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion=3;
            }
        });
        divi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion=4;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
