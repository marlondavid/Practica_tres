package com.marlonortiz.punto_5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText Nombre, Apellido, Id;
    private Button Almacenar;
    private CheckBox h1,h2,h3,h4;
    private RadioButton hombre,mujer;
    private DatePicker date;
    private Spinner ciudad;
    private TextView imp1,imp2,imp3,imp4,imp5,imp6,imp7;
    ArrayList<String> selection= new ArrayList<String>();
    private String nombre, apellido, id,sex, fecha, lugar,hobbie;
    private int n,a,i,sexo=0,hob=0;
    private int dia,mes,año;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nombre=(EditText)findViewById(R.id.inombre);
        Apellido=(EditText) findViewById(R.id.iapellido);
        Id=(EditText) findViewById(R.id.iid);
        hombre= (RadioButton) findViewById(R.id.imasculino);
        mujer= (RadioButton) findViewById(R.id.ifemenino);
        Almacenar= (Button) findViewById(R.id.boton);
        h1= (CheckBox) findViewById(R.id.ih1);
        h2= (CheckBox) findViewById(R.id.ih2);
        h3= (CheckBox) findViewById(R.id.ih3);
        h4= (CheckBox) findViewById(R.id.ih4);
        date = (DatePicker) findViewById(R.id.ifecha);
        ciudad= (Spinner) findViewById(R.id.ilugar);
        imp1= (TextView) findViewById(R.id.onombre);
        imp2= (TextView) findViewById(R.id.oapellido);
        imp3= (TextView) findViewById(R.id.oid);
        imp4= (TextView) findViewById(R.id.osexo);
        imp5= (TextView) findViewById(R.id.ofecha);
        imp6= (TextView) findViewById(R.id.olugar);
        imp7= (TextView) findViewById(R.id.oh);


        Almacenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = Nombre.getText().toString().compareTo("");
                a = Apellido.getText().toString().compareTo("");
                i = Id.getText().toString().compareTo("");
                if (n != 0 && a != 0 && i != 0 && sexo != 0 && hob != 0) {
                    nombre = Nombre.getText().toString();
                    apellido = Apellido.getText().toString();
                    id = Id.getText().toString();
                    dia = date.getDayOfMonth();
                    mes = date.getMonth()+1;
                    año = date.getYear();
                    fecha = dia + "/" + mes + "/" + año;
                    lugar = ciudad.getSelectedItem().toString();

                    imp1.setText(nombre);
                    imp2.setText(apellido);
                    imp3.setText(id);
                    imp4.setText(sex);
                    imp5.setText(fecha);
                    imp6.setText(lugar);
                    imp7.setText(hobbie);

                    Nombre.setText("");
                    Apellido.setText("");
                    Id.setText("");
                    hombre.setChecked(false);
                    mujer.setChecked(false);
                    h1.setChecked(false);
                    h2.setChecked(false);
                    h3.setChecked(false);
                    h4.setChecked(false);
                    sexo = 0;
                    hob=0;

                }
            }
        });
        hombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mujer.isChecked()) {
                    sex="Mujer";
                    hombre.setChecked(false);
                    sexo=1;
                } else if (hombre.isChecked()) {
                    sex="Hombre";
                    mujer.setChecked(false);
                    sexo=1;
                }else
                    sexo=0;
            }
        });
        mujer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mujer.isChecked()){
                    sex="Mujer";
                    hombre.setChecked(false);
                    sexo=1;
                }else if (hombre.isChecked()){
                    sex="Hombre";
                    mujer.setChecked(false);
                    sexo=1;
                }else
                    sexo=0;
            }
        });
        h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(h1.isChecked()){
                    h2.setChecked(false);
                    h3.setChecked(false);
                    h4.setChecked(false);
                    hob=1;
                    hobbie="Bailar";
                }
            }
        });
        h2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(h2.isChecked()){
                    h1.setChecked(false);
                    h3.setChecked(false);
                    h4.setChecked(false);
                    hob=2;
                    hobbie="Dormir";
                }
            }
        });
        h3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(h3.isChecked()){
                    h2.setChecked(false);
                    h1.setChecked(false);
                    h4.setChecked(false);
                    hob=3;
                    hobbie="Deporte";
                }
            }
        });
        h4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(h4.isChecked()){
                    sexo=1;
                    h2.setChecked(false);
                    h3.setChecked(false);
                    h1.setChecked(false);
                    hob=4;
                    hobbie="No tiene";
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
