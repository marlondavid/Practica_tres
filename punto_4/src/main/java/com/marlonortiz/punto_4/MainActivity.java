package com.marlonortiz.punto_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText base,altura,lado,radio;
    private TextView result;
    private RadioGroup area;
    private RadioButton trian,cuad,rect,cir;
    private Button calcular;
    private int accion=0,b,a,l,r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        base=(EditText) findViewById(R.id.base);
        altura=(EditText) findViewById(R.id.altura);
        lado=(EditText) findViewById(R.id.lado);
        radio=(EditText) findViewById(R.id.radio);
        calcular=(Button) findViewById(R.id.calc);
        result=(TextView) findViewById(R.id.result);
        area=(RadioGroup) findViewById(R.id.area);
        trian=(RadioButton) findViewById(R.id.trian);
        cuad=(RadioButton) findViewById(R.id.cuad);
        rect=(RadioButton) findViewById(R.id.circ);
        cir=(RadioButton) findViewById(R.id.circ);

        base.setEnabled(false);
        altura.setEnabled(false);
        lado.setEnabled(false);
        radio.setEnabled(false);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=base.getText().toString().compareTo("");
                a=altura.getText().toString().compareTo("");
                l=lado.getText().toString().compareTo("");
                r=radio.getText().toString().compareTo("");

                switch (accion){
                    case 1:
                        if(b!=0 && a!=0){
                            result.setText( Double.toString(
                                    (Double.parseDouble(base.getText().toString())*
                                     Double.parseDouble(altura.getText().toString())/2) ) );
                        }
                        break;
                    case 2:
                        if(l!=0){
                            result.setText( Double.toString(
                                    (Double.parseDouble(lado.getText().toString())*
                                     Double.parseDouble(lado.getText().toString())) ) );
                        }
                        break;
                    case 3:
                        if(b!=0 && a!=0){
                            result.setText( Double.toString(
                                    (Double.parseDouble(base.getText().toString())*
                                     Double.parseDouble(altura.getText().toString())) ) );
                        }
                        break;
                    case 4:
                        if(r!=0){
                            result.setText(Double.toString(
                                    Double.parseDouble(radio.getText().toString())*
                                    Double.parseDouble(radio.getText().toString())*3.1416
                            ));
                        }
                        break;
                    default:
                        Toast.makeText(MainActivity.this,"Ingrese los datos!!!",Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this,"Vuelva a intentarlo...",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        area.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.trian:
                        base.setEnabled(true);
                        altura.setEnabled(true);
                        lado.setEnabled(false);
                        radio.setEnabled(false);
                        lado.setText("");
                        radio.setText("");
                        accion=1;
                        break;
                    case R.id.cuad:
                        base.setEnabled(false);
                        altura.setEnabled(false);
                        lado.setEnabled(true);
                        radio.setEnabled(false);
                        base.setText("");
                        altura.setText("");
                        radio.setText("");
                        accion=2;
                        break;
                    case R.id.rect:
                        base.setEnabled(true);
                        altura.setEnabled(true);
                        lado.setEnabled(false);
                        radio.setEnabled(false);
                        lado.setText("");
                        radio.setText("");
                        accion=3;
                        break;
                    case R.id.circ:
                        base.setEnabled(false);
                        altura.setEnabled(false);
                        lado.setEnabled(false);
                        radio.setEnabled(true);
                        base.setText("");
                        altura.setText("");
                        lado.setText("");
                        accion=4;
                        break;
                }
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
