package com.example.projetandroidfsi;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiEtudiant {
    String BASE_URL = "https://olen-ort.fr/P2025/TRIADE/MVC/API/yannAPI.php/";

    @FormUrlEncoded
    @POST("yannAPI.php")
    Call<APIReponse<Etudiant>> login(
            @Field("email") String login,
            @Field("mdp") String mdp
    );
}
