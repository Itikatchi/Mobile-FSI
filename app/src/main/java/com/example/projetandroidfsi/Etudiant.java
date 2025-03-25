package com.example.projetandroidfsi;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Etudiant implements Serializable {


    private String nom;
    private String prenom;

    @SerializedName("mot_de_passe")
    private String motDePasse;

    private String telephone;
    private String email;
    private String adresse;

    @SerializedName("code_postal")
    private String codePostal;

    private String ville;
    private String specialite;
    private String classe;

    @SerializedName("entreprise_nom")
    private String entrepriseNom;

    @SerializedName("entreprise_cp")
    private String entrepriseCodePostal;

    @SerializedName("entreprise_adresse")
    private String entrepriseAdresse;

    @SerializedName("entreprise_ville")
    private String entrepriseVille;

    @SerializedName("maitre_prenom")
    private String maitrePrenom;

    @SerializedName("maitre_nom")
    private String maitreNom;

    @SerializedName("maitre_email")
    private String maitreEmail;

    @SerializedName("maitre_telephone")
    private String maitreTelephone;

    @SerializedName("tuteur_prenom")
    private String tuteurPrenom;

    @SerializedName("tuteur_nom")
    private String tuteurNom;

    @SerializedName("tuteur_email")
    private String tuteurEmail;

    @SerializedName("tuteur_telephone")
    private String tuteurTelephone;

    @SerializedName("bilan1_note_entreprise")
    private double bilan1NoteEntreprise;

    @SerializedName("bilan1_note_dossier")
    private double bilan1NoteDossier;

    @SerializedName("bilan1_note_oral")
    private double bilan1NoteOral;

    @SerializedName("bilan1_remarque")
    private String bilan1Remarque;

    @SerializedName("bilan1_date")
    private String bilan1Date;

    @SerializedName("bilan2_note_dossier")
    private double bilan2NoteDossier;

    @SerializedName("bilan2_note_oral")
    private double bilan2NoteOral;

    @SerializedName("bilan2_sujet")
    private String bilan2Sujet;

    @SerializedName("bilan2_date")
    private String bilan2Date;

    public Etudiant(String nom, String prenom, String motDePasse, String telephone, String email, String adresse, String codePostal, String ville, String specialite, String classe, String entrepriseNom, String entrepriseCodePostal, String entrepriseAdresse, String entrepriseVille, String maitrePrenom, String maitreNom, String maitreEmail, String maitreTelephone, String tuteurPrenom, String tuteurNom, String tuteurEmail, String tuteurTelephone, double bilan1NoteEntreprise, double bilan1NoteDossier, double bilan1NoteOral, String bilan1Remarque, String bilan1Date, double bilan2NoteDossier, double bilan2NoteOral, String bilan2Sujet, String bilan2Date) {
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.specialite = specialite;
        this.classe = classe;
        this.entrepriseNom = entrepriseNom;
        this.entrepriseCodePostal = entrepriseCodePostal;
        this.entrepriseAdresse = entrepriseAdresse;
        this.entrepriseVille = entrepriseVille;
        this.maitrePrenom = maitrePrenom;
        this.maitreNom = maitreNom;
        this.maitreEmail = maitreEmail;
        this.maitreTelephone = maitreTelephone;
        this.tuteurPrenom = tuteurPrenom;
        this.tuteurNom = tuteurNom;
        this.tuteurEmail = tuteurEmail;
        this.tuteurTelephone = tuteurTelephone;
        this.bilan1NoteEntreprise = bilan1NoteEntreprise;
        this.bilan1NoteDossier = bilan1NoteDossier;
        this.bilan1NoteOral = bilan1NoteOral;
        this.bilan1Remarque = bilan1Remarque;
        this.bilan1Date = bilan1Date;
        this.bilan2NoteDossier = bilan2NoteDossier;
        this.bilan2NoteOral = bilan2NoteOral;
        this.bilan2Sujet = bilan2Sujet;
        this.bilan2Date = bilan2Date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getEntrepriseNom() {
        return entrepriseNom;
    }

    public void setEntrepriseNom(String entrepriseNom) {
        this.entrepriseNom = entrepriseNom;
    }

    public String getEntrepriseCodePostal() {
        return entrepriseCodePostal;
    }

    public void setEntrepriseCodePostal(String entrepriseCodePostal) {
        this.entrepriseCodePostal = entrepriseCodePostal;
    }

    public String getEntrepriseAdresse() {
        return entrepriseAdresse;
    }

    public void setEntrepriseAdresse(String entrepriseAdresse) {
        this.entrepriseAdresse = entrepriseAdresse;
    }

    public String getEntrepriseVille() {
        return entrepriseVille;
    }

    public void setEntrepriseVille(String entrepriseVille) {
        this.entrepriseVille = entrepriseVille;
    }

    public String getMaitrePrenom() {
        return maitrePrenom;
    }

    public void setMaitrePrenom(String maitrePrenom) {
        this.maitrePrenom = maitrePrenom;
    }

    public String getMaitreNom() {
        return maitreNom;
    }

    public void setMaitreNom(String maitreNom) {
        this.maitreNom = maitreNom;
    }

    public String getMaitreEmail() {
        return maitreEmail;
    }

    public void setMaitreEmail(String maitreEmail) {
        this.maitreEmail = maitreEmail;
    }

    public String getMaitreTelephone() {
        return maitreTelephone;
    }

    public void setMaitreTelephone(String maitreTelephone) {
        this.maitreTelephone = maitreTelephone;
    }

    public String getTuteurPrenom() {
        return tuteurPrenom;
    }

    public void setTuteurPrenom(String tuteurPrenom) {
        this.tuteurPrenom = tuteurPrenom;
    }

    public String getTuteurNom() {
        return tuteurNom;
    }

    public void setTuteurNom(String tuteurNom) {
        this.tuteurNom = tuteurNom;
    }

    public String getTuteurEmail() {
        return tuteurEmail;
    }

    public void setTuteurEmail(String tuteurEmail) {
        this.tuteurEmail = tuteurEmail;
    }

    public String getTuteurTelephone() {
        return tuteurTelephone;
    }

    public void setTuteurTelephone(String tuteurTelephone) {
        this.tuteurTelephone = tuteurTelephone;
    }

    public double getBilan1NoteEntreprise() {
        return bilan1NoteEntreprise;
    }

    public void setBilan1NoteEntreprise(double bilan1NoteEntreprise) {
        this.bilan1NoteEntreprise = bilan1NoteEntreprise;
    }

    public double getBilan1NoteDossier() {
        return bilan1NoteDossier;
    }

    public void setBilan1NoteDossier(double bilan1NoteDossier) {
        this.bilan1NoteDossier = bilan1NoteDossier;
    }

    public double getBilan1NoteOral() {
        return bilan1NoteOral;
    }

    public void setBilan1NoteOral(double bilan1NoteOral) {
        this.bilan1NoteOral = bilan1NoteOral;
    }

    public String getBilan1Remarque() {
        return bilan1Remarque;
    }

    public void setBilan1Remarque(String bilan1Remarque) {
        this.bilan1Remarque = bilan1Remarque;
    }

    public String getBilan1Date() {
        return bilan1Date;
    }

    public void setBilan1Date(String bilan1Date) {
        this.bilan1Date = bilan1Date;
    }

    public double getBilan2NoteDossier() {
        return bilan2NoteDossier;
    }

    public void setBilan2NoteDossier(double bilan2NoteDossier) {
        this.bilan2NoteDossier = bilan2NoteDossier;
    }

    public double getBilan2NoteOral() {
        return bilan2NoteOral;
    }

    public void setBilan2NoteOral(double bilan2NoteOral) {
        this.bilan2NoteOral = bilan2NoteOral;
    }

    public String getBilan2Sujet() {
        return bilan2Sujet;
    }

    public void setBilan2Sujet(String bilan2Sujet) {
        this.bilan2Sujet = bilan2Sujet;
    }

    public String getBilan2Date() {
        return bilan2Date;
    }

    public void setBilan2Date(String bilan2Date) {
        this.bilan2Date = bilan2Date;
    }
}
