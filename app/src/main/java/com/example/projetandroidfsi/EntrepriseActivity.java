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

public class EntrepriseActivity extends AppCompatActivity {
    private TextView  textView33, textView28, textView32,  textView14, textView16;
    private Button button6;
    private Etudiant premierEtudiant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_entreprise);
        Log.d("Etudiant", "TESYOO");
        initEtu();
        initialisation();
    }

    private void initialisation() {

        textView33 = (TextView) findViewById(R.id.textView33);  // Label: Telephone
        textView28 = (TextView) findViewById(R.id.textView28);  // Label: Email
        textView32 = (TextView) findViewById(R.id.textView32);  // Label: Nom Prenom
        textView14 = (TextView) findViewById(R.id.textView14);  // Label: Nom
        textView16 = (TextView) findViewById(R.id.textView16);  // Label: Adresse
        button6 = (Button) findViewById(R.id.button6);  // Bouton "Retour" pour revenir en arrière

        textView32.setText("Nom : " + premierEtudiant.getMaitrePrenom()+" "+premierEtudiant.getMaitreNom());
        textView28.setText("Mail : " + premierEtudiant.getMaitreEmail());
        textView33.setText("Téléphone : " + premierEtudiant.getMaitreTelephone());
        textView14.setText("Entreprise : " + premierEtudiant.getEntrepriseNom());
        textView16.setText("Adresse : " + premierEtudiant.getEntrepriseAdresse() + " " + premierEtudiant.getEntrepriseCodePostal() + " " + premierEtudiant.getEntrepriseVille());
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(EntrepriseActivity.this, InfoActivity.class);
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
