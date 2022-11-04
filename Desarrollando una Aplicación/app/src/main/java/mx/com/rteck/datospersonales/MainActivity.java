package mx.com.rteck.datospersonales;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextInputEditText nombre;
    DatePicker fecha;
    TextInputEditText telefono;
    TextInputEditText email;
    TextInputEditText descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre      =   (TextInputEditText) findViewById(R.id.inp_nombre);
        fecha       =   (DatePicker) findViewById(R.id.date_picker);
        telefono    =   (TextInputEditText) findViewById(R.id.inp_telefono);
        email       =   (TextInputEditText) findViewById(R.id.inp_email);
        descripcion =   (TextInputEditText) findViewById(R.id.inp_descripcion);

        if(getIntent().hasExtra(getResources().getString(R.string.e_nombre)))
        {
            Bundle parametros = getIntent().getExtras();

            String Nombre = parametros.getString(getResources().getString(R.string.e_nombre));
            String Telefono = parametros.getString(getResources().getString(R.string.e_telefono));
            int Año = parametros.getInt(getResources().getString(R.string.e_año));
            int Mes = parametros.getInt(getResources().getString(R.string.e_mes));
            int Dia = parametros.getInt(getResources().getString(R.string.e_dia));
            String Descripcion = parametros.getString(getResources().getString(R.string.e_descripcion));
            String Email = parametros.getString(getResources().getString(R.string.e_email));
            nombre.setText(Nombre);
            fecha.init(Año,Mes,Dia,null);
            telefono.setText(Telefono);
            email.setText(Email);
            descripcion.setText(Descripcion);
        }
    }

    public void Siguiente(View v)
    {
        Intent intent = new Intent(MainActivity.this,MuestaDatos.class);
        intent.putExtra(getResources().getString(R.string.e_nombre),nombre.getText().toString());
        String Fecha= fecha.getDayOfMonth()+"/"+fecha.getMonth()+"/"+fecha.getYear();
        intent.putExtra(getResources().getString(R.string.e_año),fecha.getYear());
        intent.putExtra(getResources().getString(R.string.e_mes),fecha.getMonth());
        intent.putExtra(getResources().getString(R.string.e_dia),fecha.getDayOfMonth());
        intent.putExtra(getResources().getString(R.string.e_telefono),telefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.e_email),email.getText().toString());
        intent.putExtra(getResources().getString(R.string.e_descripcion),descripcion.getText().toString());
        startActivity(intent);
    }
}
