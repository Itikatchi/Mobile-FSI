package com.example.projetandroidfsi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClientEtudiant {
    private static RetroFitClientEtudiant instance =null;
    private ApiEtudiant myApi;
    private RetroFitClientEtudiant(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiEtudiant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(ApiEtudiant.class);
    }
    public static RetroFitClientEtudiant getInstance() {
        if (instance == null) {
            instance = new RetroFitClientEtudiant();
        }
        return instance;
    }
    public ApiEtudiant getMyApi() {return myApi; }
}
