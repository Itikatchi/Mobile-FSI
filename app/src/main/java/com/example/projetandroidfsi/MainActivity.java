package com.example.projetandroidfsi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Call;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    private EditText editTextPassword,editTextMail;
    private Button Connect;
    private String email, mdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        viderTable();
        initialisation();
    }
    public void viderTable() {
        EtudiantDataSource etudiantDataSource = new EtudiantDataSource(MainActivity.this);
        etudiantDataSource.open();
        etudiantDataSource.viderTable();
        etudiantDataSource.close();

    }
    private void loginUser(String email, String mdp) {
        ApiEtudiant api = RetroFitClientEtudiant.getInstance().getMyApi();
        Call<APIReponse<Etudiant>> call = api.login(email, mdp);

        call.enqueue(new Callback<APIReponse<Etudiant>>() {
            @Override
            public void onResponse(Call<APIReponse<Etudiant>> call, Response<APIReponse<Etudiant>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.e("API", "Erreur de nonconnect : " );
                    APIReponse<Etudiant> apiResponse = response.body();
                    if ("ok".equals(apiResponse.getStatus())) {
                        Etudiant etudiant = apiResponse.getData();
                        Log.d("API", "Nom : " + etudiant.getNom() + ", Email : " + etudiant.getEmail());
                        // Insérer l'étudiant dans la base de données locale
                        EtudiantDataSource etudiantDataSource = new EtudiantDataSource(MainActivity.this);
                        etudiantDataSource.open();  // Ouvrir la base de données
                        Log.d("API", "OnTEst");
                        etudiantDataSource.insertEtudiant(etudiant);  // Insérer l'étudiant dans la base de données
                        Log.d("API", "encore");
                        etudiantDataSource.close();  // Fermer la base de données

                        Intent intent = new Intent(MainActivity.this, AccueilActivity.class);
                        startActivity(intent);
                        
                    } else if("erreur".equals(apiResponse.getStatus())){
                        Log.e("API", "Erreur : " + apiResponse.getStatus());
                        Toast.makeText(MainActivity.this,"Mauvaise mail / mot de passe",Toast.LENGTH_LONG).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<APIReponse<Etudiant>> call, Throwable t) {
                Log.e("API", "Erreur de connexion : " + t.getMessage());
                Toast.makeText(MainActivity.this,"Mauvaise mail / mot de passe",Toast.LENGTH_LONG).show();
            }
        });
    }
    private void initialisation() {
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextMail = (EditText) findViewById(R.id.editTextMail);
        Connect = (Button) findViewById(R.id.Connect);
        Connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editTextMail.getText().toString();
                mdp = editTextPassword.getText().toString();
                loginUser(email,mdp);

            }

        });
    }
}