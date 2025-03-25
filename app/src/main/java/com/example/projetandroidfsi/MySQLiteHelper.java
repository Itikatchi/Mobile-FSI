package com.example.projetandroidfsi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_COMMENTS = "ETUDIANT";
    private static final String DATABASE_NAME = "Etudiant.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_COMMENTS + " ("
            + "idEtu INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "nom TEXT, "
            + "prenom TEXT, "
            + "motDePasse TEXT, "
            + "telephone TEXT, "
            + "email TEXT, "
            + "adresse TEXT, "
            + "codePostal TEXT, "
            + "ville TEXT, "
            + "specialite TEXT, "
            + "classe TEXT, "
            + "entrepriseNom TEXT, "
            + "entrepriseCodePostal TEXT, "
            + "entrepriseAdresse TEXT, "
            + "entrepriseVille TEXT, "
            + "maitrePrenom TEXT, "
            + "maitreNom TEXT, "
            + "maitreEmail TEXT, "
            + "maitreTelephone TEXT, "
            + "tuteurPrenom TEXT, "
            + "tuteurNom TEXT, "
            + "tuteurEmail TEXT, "
            + "tuteurTelephone TEXT, "
            + "bilan1NoteEntreprise REAL, "
            + "bilan1NoteDossier REAL, "
            + "bilan1NoteOral REAL, "
            + "bilan1Remarque TEXT, "
            + "bilan1Date TEXT, "
            + "bilan2NoteDossier REAL, "
            + "bilan2NoteOral REAL, "
            + "bilan2Sujet TEXT, "
            + "bilan2Date TEXT"
            + ");";

    public MySQLiteHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version" + oldVersion + "to" + newVersion + "which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_COMMENTS);
        onCreate(db);

    }
}
