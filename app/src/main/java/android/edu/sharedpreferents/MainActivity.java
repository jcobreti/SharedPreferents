package android.edu.sharedpreferents;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private final String FICHERO_RECURSOS="USUARIOREG";
private final String CLAVE="USUARIO";
private EditText et;
private TextView us;
private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.editText);
        us=findViewById(R.id.usuario);
        bt=findViewById(R.id.button);

        us.setText(leerSharedPreferences(FICHERO_RECURSOS,CLAVE));
        //A bt le anadimos el OnClickListener para escuchar evento CLICK
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valor=et.getText().toString();
                guardarSharedPreferences(FICHERO_RECURSOS,CLAVE,valor);
                us.setText(valor);
            }
        });
    }
    private String leerSharedPreferences (String recurso, String clave)
    {
        SharedPreferences sp=getSharedPreferences(recurso,MODE_PRIVATE);
        String valor=sp.getString(clave,"ANONIMO");
        return valor;

    }
    private void guardarSharedPreferences (String recurso, String clave, String valor)
    {
        SharedPreferences sp=getSharedPreferences(recurso,MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();
        ed.putString(clave,valor);
        ed.apply();
    }
}

