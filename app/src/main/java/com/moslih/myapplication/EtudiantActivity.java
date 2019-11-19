package com.moslih.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.moslih.myapplication.models.Etudiant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EtudiantActivity extends AppCompatActivity {

    private ListView listEtudiants;
    private EditText nom;
    private EditText prenom;

    private List<Etudiant> etudiants = new ArrayList<Etudiant>(){
        {
            new Etudiant("taha", "MOSLIH", "taha@taha.com");
            new Etudiant("taha 1", "MOSLIH 1", "taha1@taha.com");
            new Etudiant("taha 2", "MOSLIH 2", "taha2@taha.com");
            new Etudiant("taha 3", "MOSLIH 3", "taha3@taha.com");
        }
    };

    private List<String> prenoms = new ArrayList<>();
    private List<String> lisetSelected = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etudiant);

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);

        listEtudiants = findViewById(R.id.listEtudiants);
        listEtudiants.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(EtudiantActivity.this, android.R.layout.simple_list_item_multiple_choice, prenoms);


        listEtudiants.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) listEtudiants.getItemAtPosition(position);
                Toast.makeText(EtudiantActivity.this, selected, Toast.LENGTH_LONG).show();
                lisetSelected.add(selected);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.ajouter:
                        //Intent intent = new Intent(EtudiantActivity.this, AddEtudiantActivity.class);
                        //startActivity(intent);
                        prenoms.add(nom.getText().toString() + " " + prenom.getText().toString());
                        listEtudiants.setAdapter(adapter);
                        nom.setText("");
                        prenom.setText("");
                        break;
                    case R.id.envoyer:
                        Intent intent = new Intent(EtudiantActivity.this, AddEtudiantActivity.class);

                        intent.putExtra("LISTETUDIANTS",(Serializable) lisetSelected);
                        startActivity(intent);
                        break;
                }
                return true;
            }
            });
    }

}
