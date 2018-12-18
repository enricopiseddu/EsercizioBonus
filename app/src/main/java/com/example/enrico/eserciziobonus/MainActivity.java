package com.example.enrico.eserciziobonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    EditText username, password;
    TextView registrazione;
    Button pulsanteAccedi;

    //lista contenente gli utenti fittizi
    private ArrayList<Utente> utenti = new ArrayList<Utente>(5);

    //Utenti fittizi, caratterizzati da Nome, Email (username) e Password
    private Utente ut1 = new Utente("Platone",  "platone@gmail.com",  "idea");
    private Utente ut2 = new Utente("Pitagora", "pitagora@gmail.com", "teorema");
    private Utente ut3 = new Utente("Kant",     "kant@gmail.com",     "noumeno");
    private Utente ut4 = new Utente("Berkeley", "berkeley@gmail.com", "dio");
    private Utente ut5 = new Utente("Parmenide","parmenide@gmail.com", "essere");

    private String actualUsername, actualPassword;

    //utente che si dovrà loggare, per ora NULL
    Utente actualUser = null;

    public static final String UTENTE_EXTRA="com.example.enrico.eserciziobonus.Utente";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //si aggiungono gli utenti nella lista "utenti"
        utenti.add(ut1);
        utenti.add(ut2);
        utenti.add(ut3);
        utenti.add(ut4);
        utenti.add(ut5);

        //prelievo delle informazioni dall'xml
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        pulsanteAccedi = (Button)findViewById(R.id.accedi);
        registrazione = (TextView)findViewById(R.id.registrazione);


        //l'utente preme il pulsante "Accedi"
        pulsanteAccedi.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                //se l'utente compila entrambi i campi "Username" e "Password"
                if( checkInput() )
                {
                    //prelievo dei valori inseriti negli EditText
                    actualUsername = username.getText().toString();
                    actualPassword = password.getText().toString();

                    //controllo se l'utente compare nella lista "utenti"
                    for (Utente u : utenti)
                    {

                        /*
                          se l'username e password dell'utente corrispondono ad un
                          utente X presente nella lista, actualUser sarà l'utente X,
                          altrimenti actualUser non viene modificato e varrà NULL
                        */
                        if (actualUsername.equals(u.getUsername()) &&
                                actualPassword.equals(u.getPassword()))
                        {
                            actualUser = u;
                        }
                    }

                    //passaggio alla prossima activity consegnando l'oggetto "actualUser"
                    Intent showLogin = new Intent(MainActivity.this,
                            ShowLogin.class);
                    showLogin.putExtra(UTENTE_EXTRA, actualUser);
                    startActivity(showLogin);
                }
            }
            });
    }


    /*Questa funzione verifica che entrambi i campi "Username" e Password
      non siano vuoti (true). Restituisce false se almeno uno dei due campi
      è vuoto.
      Si occupa, eventualmente, di mostrare i messaggi d'errore all'utente.
    */
    private boolean checkInput(){

        int errors=0;

        if (username.getText() == null || username.getText().length()==0) {
            errors++;
            username.setError("Inserisci Username");
        }
        else
            username.setError(null);

        if (password.getText() == null || password.getText().length()==0) {
            errors++;
            password.setError("Inserisci Password");
        }
        else
            password.setError(null);

        return errors==0; // ritorna true se non ci sono errori

    }
}