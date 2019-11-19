package com.moslih.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.moslih.myapplication.models.Etudiant;

public class WelcomeActivity extends AppCompatActivity {

    private TextView nom_conf;
    private TextView prenom_conf;
    private TextView email_conf;

    private Button btn_conf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        nom_conf = findViewById(R.id.nom_conf);
        prenom_conf = findViewById(R.id.prenom_conf);
        email_conf = findViewById(R.id.email_conf);

        btn_conf = findViewById(R.id.btn_conf);

        Intent intent = getIntent();

        // Bundle permet de creer une session (canal) entre l'activité de depart et la'activité d'arrivée
        Bundle bundle = intent.getExtras();

        nom_conf.setText(bundle.getString("NOM"));
        prenom_conf.setText(bundle.getString("PRENOM"));
        email_conf.setText(bundle.getString("EMAIL"));

        Etudiant etudiant = (Etudiant) bundle.getSerializable("ETUDIANT");

        Toast.makeText(WelcomeActivity.this, etudiant.toString(), Toast.LENGTH_LONG).show();
    }
}
