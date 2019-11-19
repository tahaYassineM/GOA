package com.moslih.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AddEtudiantActivity extends AppCompatActivity {

    private ListView listEtudiantsSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_etudiant);

        Intent intent = getIntent();

        // Bundle permet de creer une session (canal) entre l'activité de depart et la'activité d'arrivée
        Bundle bundle = intent.getExtras();
        List<String> listData =(ArrayList<String>) bundle.getSerializable("LISTETUDIANTS");

        listEtudiantsSelected = findViewById(R.id.listEtudiantsSelected);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(AddEtudiantActivity.this, android.R.layout.simple_list_item_1, listData);

        listEtudiantsSelected.setAdapter(adapter);
    }
}
