package com.example.projetandroidfsi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BilanActivity extends AppCompatActivity {
    private TextView DateBil1,Rembil1,textView21,textView20,TextViewNotOrlBil1,DateBil2,RemBil2,textView29,NoteOralBIl2;
    private Button ButtonBack;
    private Etudiant premierEtudiant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_note);
        Log.d("Etudiant", "TESYOO");
        initEtu();
        initialisation();
    }

    private void initialisation() {
        Log.d("Etudiant", "Premier étudiant : " + premierEtudiant.getAdresse());
        ButtonBack = (Button) findViewById(R.id.ButtonBack);
        DateBil1 =(TextView) findViewById(R.id.DateBil1);
        Rembil1 =(TextView) findViewById(R.id.Rembil1);
        textView21 =(TextView) findViewById(R.id.textView21);//Note ent
        textView20 =(TextView) findViewById(R.id.textView20);//Note doss
        TextViewNotOrlBil1 =(TextView) findViewById(R.id.TextViewNotOrlBil1);
        DateBil2 =(TextView) findViewById(R.id.DateBil2);
        RemBil2 =(TextView) findViewById(R.id.RemBil2);
        textView29 =(TextView) findViewById(R.id.textView29);//NoteDos
        NoteOralBIl2 =(TextView) findViewById(R.id.NoteOralBIl2);

        DateBil1.setText("Date :" +premierEtudiant.getBilan1Date());
        Rembil1.setText("Remarque : " +premierEtudiant.getBilan1Remarque());
        textView21.setText(String.valueOf(premierEtudiant.getBilan1NoteEntreprise()));
        textView20.setText(String.valueOf(premierEtudiant.getBilan1NoteDossier()));
        TextViewNotOrlBil1.setText(String.valueOf(premierEtudiant.getBilan1NoteOral()));
        DateBil2.setText("Date : " + premierEtudiant.getBilan2Date());
        RemBil2.setText("Sujet de memoire : " + premierEtudiant.getBilan2Sujet());
        textView29.setText(String.valueOf(premierEtudiant.getBilan2NoteDossier()));
        NoteOralBIl2.setText(String.valueOf(premierEtudiant.getBilan2NoteOral()));


        ButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BilanActivity.this, AccueilActivity.class);
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
