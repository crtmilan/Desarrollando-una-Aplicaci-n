package mx.com.rteck.datospersonales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MuestaDatos extends AppCompatActivity {

    TextView nombre;
    TextView fecha;
    TextView telefono;
    TextView descripcion;
    TextView email;

    String Nombre;
    String Telefono;
    int Año;
    int Mes;
    int Dia;
    String Descripcion;
    String Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muesta_datos);
        Bundle parametros = getIntent().getExtras();

         Nombre = parametros.getString(getResources().getString(R.string.e_nombre));
         Telefono = parametros.getString(getResources().getString(R.string.e_telefono));
         Año = parametros.getInt(getResources().getString(R.string.e_año));
         Mes = parametros.getInt(getResources().getString(R.string.e_mes));
         Dia = parametros.getInt(getResources().getString(R.string.e_dia));
         Descripcion = parametros.getString(getResources().getString(R.string.e_descripcion));
         Email = parametros.getString(getResources().getString(R.string.e_email));

        String Fecha=Año+"/"+Mes+"/"+Dia;

        nombre      =   (TextView)  findViewById(R.id.tvNombre);
        fecha       =   (TextView)  findViewById(R.id.tvFecha);
        telefono    =   (TextView)  findViewById(R.id.tvTelefono);
        descripcion =   (TextView)  findViewById(R.id.tvDescripcion);
        email       =   (TextView)  findViewById(R.id.tvEmail);

        nombre.setText(Nombre);
        fecha.setText(Fecha);
        telefono.setText(Telefono);
        descripcion.setText(Descripcion);
        email.setText(Email);
    }

    public void Regresar(View v)
    {
        Intent intent = new Intent(MuestaDatos.this,MainActivity.class);
        intent.putExtra(getResources().getString(R.string.e_nombre),nombre.getText().toString());

        intent.putExtra(getResources().getString(R.string.e_año),Año);
        intent.putExtra(getResources().getString(R.string.e_mes),Mes);
        intent.putExtra(getResources().getString(R.string.e_dia),Dia);
        intent.putExtra(getResources().getString(R.string.e_telefono),telefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.e_email),email.getText().toString());
        intent.putExtra(getResources().getString(R.string.e_descripcion),descripcion.getText().toString());
        startActivity(intent);
    }
}
