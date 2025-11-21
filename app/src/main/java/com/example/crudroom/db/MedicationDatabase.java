package com.example.crudroom.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//constrói o database

@Database(entities = {Medication.class, IntakeHistory.class}, version = 4, exportSchema = false)
public abstract class MedicationDatabase extends RoomDatabase {

    private static MedicationDatabase instance;

    public abstract MedicationDao medicationDao();
    public abstract IntakeHistoryDao intakeHistoryDao();

    public static synchronized MedicationDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            MedicationDatabase.class,
                            "medication_database"
                    )
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
