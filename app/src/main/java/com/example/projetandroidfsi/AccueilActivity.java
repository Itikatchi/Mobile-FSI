package com.example.projetandroidfsi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.stream.Collectors;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AccueilActivity  extends AppCompatActivity {
    private Etudiant premierEtudiant;
    private TextView WelcomeTextView;
    private Button ButtonInfo,ButtonBilan,buttonDeco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_accueil);
        initEtu();
        initialisation();
    }

    private void initialisation() {
        ButtonInfo = (Button) findViewById(R.id.ButtonInfo);
        ButtonBilan = (Button) findViewById(R.id.ButtonBilan);
        buttonDeco = (Button) findViewById(R.id.buttonDeco);
        WelcomeTextView =(TextView) findViewById(R.id.WelcomeTextView);
        WelcomeTextView.setText("Bienvenu " + premierEtudiant.getPrenom() + " " + premierEtudiant.getNom()+ " Sur FSI");
        ButtonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AccueilActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });
        ButtonBilan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AccueilActivity.this, BilanActivity.class);
                startActivity(intent);
            }
        });
        buttonDeco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AccueilActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initEtu(){
        Log.d("Etudiant", "TEST");
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
