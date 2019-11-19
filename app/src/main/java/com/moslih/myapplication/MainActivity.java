package com.moslih.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.moslih.myapplication.models.Etudiant;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private EditText nom;
    private EditText prenom;
    private EditText email;
    private EditText pwd;
    private EditText rpwd;
    private EditText age;
    private RadioGroup radioGroup;
    private RadioButton genre;

    private StringBuffer buffer;
    private Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = (EditText) findViewById(R.id.lastname);
        prenom = (EditText) findViewById(R.id.firstname);
        email = (EditText) findViewById(R.id.email);
        pwd = (EditText) findViewById(R.id.password);
        rpwd = (EditText) findViewById(R.id.repassword);
        age = (EditText) findViewById(R.id.age);

        radioGroup = (RadioGroup) findViewById(R.id.genreGroup);

        signUp = (Button) findViewById(R.id.signup_btn);

        signUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buffer = new StringBuffer();

                if(nom.getText().toString().isEmpty()) {
                    nom.setError("Nom Empty ");
                    buffer.append("nom Empty ");
                }
                else
                    buffer.append("nom: " + nom.getText().toString());

                if(prenom.getText().toString().isEmpty()) {
                    prenom.setError("Prenom Empty ");
                    buffer.append("\n Prennom Empty");
                }
                else
                    buffer.append("\n prenom: " + prenom.getText().toString());

                if(email.getText().toString().isEmpty() ) {
                    //Champ vide
                    email.setError("Email Empty");
                    buffer.append("\n email Empty ");

                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
                    //Validateur
                    email.setError("exemple : emailxxx@xxx.xx");
                    buffer.append("email pattern: emailxxx@xxx.xx");
                }
                else
                    buffer.append("\n email : " + email.getText().toString());

                if(pwd.getText().toString().isEmpty()) {
                    pwd.setError("Password Empty ");
                    buffer.append("\n password Empty");
                }
                else
                    buffer.append("\n password: " + pwd.getText().toString());

                rpwd.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        if(!pwd.getText().toString().equals(rpwd.getText().toString()))
                        {
                            rpwd.setError("password incorrect");
                            buffer.append("\n password not equals");

                        }
                        else
                        {
                            return true;
                        }
                        return false;
                    }
                });

                if(age.getText().toString().isEmpty()) {
                    age.setError("Age Empty ");
                    buffer.append("\n age Empty:");
                }
                else
                    age.append("\n age: " + age.getText().toString());

                int genreId = radioGroup.getCheckedRadioButtonId();
                genre = (RadioButton) findViewById(genreId);

                if(genreId == -1)
                    buffer.append("gender not selected");
                else
                    buffer.append("\n genre: " + genre.getText().toString());

                if (buffer.length() != 0){
                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    intent.putExtra("NOM", nom.getText().toString());
                    intent.putExtra("PRENOM", prenom.getText().toString());
                    intent.putExtra("EMAIL", email.getText().toString());

                    Etudiant etudiant = new Etudiant(nom.getText().toString(), prenom.getText().toString(), email.getText().toString());
                    // il faut que l'objet doit serialisé soit implement Serialable ou (Serialisable) etudiant
                    intent.putExtra("ETUDIANT", etudiant);
                    startActivity(intent);
                }
                    else
                        Toast.makeText(MainActivity.this, buffer, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
