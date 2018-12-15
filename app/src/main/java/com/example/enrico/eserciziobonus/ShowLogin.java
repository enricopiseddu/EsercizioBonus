package com.example.enrico.eserciziobonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;

public class ShowLogin extends AppCompatActivity {

    Utente utente;
    TextView accessoConsentito;
    TextView accessoNegato;
    Button backToMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_login);

        accessoConsentito = (TextView)findViewById(R.id.accessoConsentito);
        accessoNegato     = (TextView)findViewById(R.id.accessoNegato);
        backToMainActivity = (Button)findViewById(R.id.indietro);

        //prelievo dell'oggetto passato dall'activity precedente
        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(MainActivity.UTENTE_EXTRA);

        if(obj!=null)
        {
                /*Se l'oggetto (obj) non è null significa che l'utente
                all'activity precedente è stato trovato nella lista ed ha diritto all'accesso
                */

                utente = (Utente)obj;

                //mostro il Bevenuto all'utente
                accessoConsentito.setVisibility(View.VISIBLE);
                accessoConsentito.setText("Benvenuto, " + utente.getNome());
        }
        else{
            //mostro un messaggio di Accesso Negato
            accessoNegato.setVisibility(View.VISIBLE);
        }


        //al click del pulsante "Indietro", si mostra l'activity precedente (MainActivity)
        backToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(ShowLogin.this,
                        MainActivity.class);

                startActivity(login);
            }
        });




    }
}
