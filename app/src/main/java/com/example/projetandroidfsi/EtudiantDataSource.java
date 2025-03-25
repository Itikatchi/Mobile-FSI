package com.example.projetandroidfsi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class EtudiantDataSource {
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    public EtudiantDataSource(Context context){
        dbHelper = new MySQLiteHelper(context);
    }
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    public String info(){
        return dbHelper.TABLE_COMMENTS;
    }
    public void close(){
        dbHelper.close();
    }
    public Etudiant insertEtudiant(Etudiant etudiant) {
        ContentValues values = new ContentValues();
        values.put("nom", etudiant.getNom());
        values.put("prenom", etudiant.getPrenom());
        values.put("motDePasse", etudiant.getMotDePasse());
        values.put("telephone", etudiant.getTelephone());
        values.put("email", etudiant.getEmail());
        values.put("adresse", etudiant.getAdresse());
        values.put("codePostal", etudiant.getCodePostal());
        values.put("ville", etudiant.getVille());
        values.put("specialite", etudiant.getSpecialite());
        values.put("classe", etudiant.getClasse());
        values.put("entrepriseNom", etudiant.getEntrepriseNom());
        values.put("entrepriseCodePostal", etudiant.getEntrepriseCodePostal());
        values.put("entrepriseAdresse", etudiant.getEntrepriseAdresse());
        values.put("entrepriseVille", etudiant.getEntrepriseVille());
        values.put("maitrePrenom", etudiant.getMaitrePrenom());
        values.put("maitreNom", etudiant.getMaitreNom());
        values.put("maitreEmail", etudiant.getMaitreEmail());
        values.put("maitreTelephone", etudiant.getMaitreTelephone());
        values.put("tuteurPrenom", etudiant.getTuteurPrenom());
        values.put("tuteurNom", etudiant.getTuteurNom());
        values.put("tuteurEmail", etudiant.getTuteurEmail());
        values.put("tuteurTelephone", etudiant.getTuteurTelephone());
        values.put("bilan1NoteEntreprise", etudiant.getBilan1NoteEntreprise());
        values.put("bilan1NoteDossier", etudiant.getBilan1NoteDossier());
        values.put("bilan1NoteOral", etudiant.getBilan1NoteOral());
        values.put("bilan1Remarque", etudiant.getBilan1Remarque());
        values.put("bilan1Date", etudiant.getBilan1Date());
        values.put("bilan2NoteDossier", etudiant.getBilan2NoteDossier());
        values.put("bilan2NoteOral", etudiant.getBilan2NoteOral());
        values.put("bilan2Sujet", etudiant.getBilan2Sujet());
        values.put("bilan2Date", etudiant.getBilan2Date());

        // Insérer dans la base de données
        long id = database.insert(dbHelper.TABLE_COMMENTS, null, values);

        // Vous pouvez utiliser l'ID retourné si vous en avez besoin plus tard
        // Vous pouvez le stocker dans la session, ou l'utiliser pour des requêtes ultérieures
        return etudiant;
    }
    public Etudiant cursorToEtudiant(Cursor cursor) {
        String nom = cursor.getString(0);
        String prenom = cursor.getString(1);
        String motDePasse = cursor.getString(2);
        String telephone = cursor.getString(3);
        String email = cursor.getString(4);
        String adresse = cursor.getString(5);
        String codePostal = cursor.getString(6);
        String ville = cursor.getString(7);
        String specialite = cursor.getString(8);
        String classe = cursor.getString(9);
        String entrepriseNom = cursor.getString(10);
        String entrepriseCodePostal = cursor.getString(11);
        String entrepriseAdresse = cursor.getString(12);
        String entrepriseVille = cursor.getString(13);
        String maitrePrenom = cursor.getString(14);
        String maitreNom = cursor.getString(15);
        String maitreEmail = cursor.getString(16);
        String maitreTelephone = cursor.getString(17);
        String tuteurPrenom = cursor.getString(18);
        String tuteurNom = cursor.getString(19);
        String tuteurEmail = cursor.getString(20);
        String tuteurTelephone = cursor.getString(21);
        double bilan1NoteEntreprise = cursor.getDouble(22);
        double bilan1NoteDossier = cursor.getDouble(23);
        double bilan1NoteOral = cursor.getDouble(24);
        String bilan1Remarque = cursor.getString(25);
        String bilan1Date = cursor.getString(26);
        double bilan2NoteDossier = cursor.getDouble(27);
        double bilan2NoteOral = cursor.getDouble(28);
        String bilan2Sujet = cursor.getString(29);
        String bilan2Date = cursor.getString(30);

        return new Etudiant(nom, prenom, motDePasse, telephone, email, adresse, codePostal, ville, specialite,
                classe, entrepriseNom, entrepriseCodePostal, entrepriseAdresse, entrepriseVille, maitrePrenom,
                maitreNom, maitreEmail, maitreTelephone, tuteurPrenom, tuteurNom, tuteurEmail, tuteurTelephone,
                bilan1NoteEntreprise, bilan1NoteDossier, bilan1NoteOral, bilan1Remarque, bilan1Date,
                bilan2NoteDossier, bilan2NoteOral, bilan2Sujet, bilan2Date);
    }
    public ArrayList<Etudiant> getAllEtudiants() {
        ArrayList<Etudiant> listEtudiant = new ArrayList<>();
        Cursor cursor = database.query(true, dbHelper.TABLE_COMMENTS,
                new String[]{"nom", "prenom", "motDePasse", "telephone", "email", "adresse",
                        "codePostal", "ville", "specialite", "classe", "entrepriseNom",
                        "entrepriseCodePostal", "entrepriseAdresse", "entrepriseVille",
                        "maitrePrenom", "maitreNom", "maitreEmail", "maitreTelephone",
                        "tuteurPrenom", "tuteurNom", "tuteurEmail", "tuteurTelephone",
                        "bilan1NoteEntreprise", "bilan1NoteDossier", "bilan1NoteOral",
                        "bilan1Remarque", "bilan1Date", "bilan2NoteDossier", "bilan2NoteOral",
                        "bilan2Sujet", "bilan2Date"},
                null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Etudiant unEtudiant = cursorToEtudiant(cursor);
            listEtudiant.add(unEtudiant);
        }
        cursor.close();
        return listEtudiant;
    }
    public void viderTable() {
        database.execSQL("DELETE FROM " + dbHelper.TABLE_COMMENTS);
        database.execSQL("DELETE FROM sqlite_sequence WHERE name='" + dbHelper.TABLE_COMMENTS + "'");
    }

}