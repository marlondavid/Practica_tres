package com.marlonortiz.punto_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText quiz,expo,lab,pro;
    private Button calcular;
    private TextView rtado;
    private double q,e,l,p,result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quiz=(EditText) findViewById(R.id.quin);
        expo=(EditText) findViewById(R.id.diez);
        lab=(EditText) findViewById(R.id.cuare);
        pro=(EditText) findViewById(R.id.trint);
        calcular=(Button) findViewById(R.id.calc);
        rtado=(TextView) findViewById(R.id.result);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q=quiz.getText().toString().compareTo("");
                e=expo.getText().toString().compareTo("");
                l=lab.getText().toString().compareTo("");
                p=pro.getText().toString().compareTo("");
                if (q!=0 && e!=0 && l!=0 && p!=0){

                    q=Double.parseDouble(quiz.getText().toString());
                    e=Double.parseDouble(expo.getText().toString());
                    l=Double.parseDouble(lab.getText().toString());
                    p=Double.parseDouble(pro.getText().toString());

                    if(q>=0 && q<=5 && e>=0 && e<=5 && l>=0 && l<=5 && p>=0 && p<=5){
                        result= round(q*0.15+e*0.1+l*0.4+p*0.35,1);
                        rtado.setText(Double.toString(result));
                        if(result>=3){
                            Toast.makeText(MainActivity.this,"Felicidades Ganaste!!!",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this,"Perdiste!!! Sigue intentando *_*",Toast.LENGTH_LONG).show();
                        }
                    }else{
                        rtado.setText("");
                        Toast.makeText(MainActivity.this,"Las Notas van de 0 a 5!!!",Toast.LENGTH_LONG).show();
                    }

                }else{
                    rtado.setText("");
                    Toast.makeText(MainActivity.this,"Hay Campos Vacios!!!",Toast.LENGTH_LONG).show();
                }
                quiz.setText("");
                expo.setText("");
                lab.setText("");
                pro.setText("");
            }
        });
    }

    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
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
