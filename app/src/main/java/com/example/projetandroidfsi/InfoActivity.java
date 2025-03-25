package com.example.projetandroidfsi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    private TextView TextViewNom, TextViewadresse, textViewTel, textViewMail, NomTut, emailTut, telTut;
    private Button ButtonEntre,ButtonRetour;

    private Etudiant premierEtudiant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_information);
        Log.d("Etudiant", "TESYOO");
        initEtu();
        initialisation();
    }
    private void initialisation() {

        TextViewNom = (TextView) findViewById(R.id.TextViewNom);
        TextViewadresse = (TextView) findViewById(R.id.TextViewadresse);
        textViewTel = (TextView) findViewById(R.id.textViewTel);
        textViewMail = (TextView) findViewById(R.id.textViewMail);
        NomTut = (TextView) findViewById(R.id.NomTut);
        emailTut = (TextView) findViewById(R.id.emailTut);
        telTut = (TextView) findViewById(R.id.telTut);
        ButtonEntre =(Button)findViewById(R.id.ButtonEntre);
        ButtonRetour =(Button)findViewById(R.id.ButtonRetour);

        TextViewNom.setText(premierEtudiant.getPrenom() + " " + premierEtudiant.getNom());
        TextViewadresse.setText("Adresse : "+premierEtudiant.getAdresse()+" " + premierEtudiant.getVille()+ " " + premierEtudiant.getCodePostal());
        textViewTel.setText("Telephone : " + premierEtudiant.getTelephone());
        textViewMail.setText("Mail : "+premierEtudiant.getEmail());
        NomTut.setText(premierEtudiant.getTuteurPrenom()+ " " + premierEtudiant.getTuteurNom());
        emailTut.setText("Mail : "+ premierEtudiant.getTuteurEmail());
        telTut.setText("Telephone : " +premierEtudiant.getTuteurTelephone());



        ButtonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(InfoActivity.this, AccueilActivity.class);
                startActivity(intent);
            }
        });
        ButtonEntre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(InfoActivity.this, EntrepriseActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initEtu(){
        Log.d("Etudiant", "TEST2");
        EtudiantDataSource dataSource = new EtudiantDataSource(this);
        dataSource.open();
        ArrayList<Etudiant> etudiants = dataSource.getAllEtudiants();
        if (!etudiants.isEmpty()) {
            premierEtudiant = etudiants.get(0);  // Récupère le premier étudiant de la liste
            // Utiliser le premier étudiant
            Log.d("Etudiant", "Premier étudiant : " + premierEtudiant.getNom());

        } else {
            // Gérer le cas où il n'y a pas d'étudiants
            Log.d("Etudiant", "Aucun étudiant trouvé");
        }

    }
}
