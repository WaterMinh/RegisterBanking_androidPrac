package com.example.mobilebanking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME ="banking.sqlite";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE tblAccount (\n" +
                "    Id           INTEGER      PRIMARY KEY AUTOINCREMENT,\n" +
                "    Fullname     VARCHAR (64) NOT NULL,\n" +
                "    Passport_num VARCHAR (32) NOT NULL,\n" +
                "    Email        VARCHAR (32) NOT NULL\n" +
                "                              UNIQUE,\n" +
                "    Password     VARCHAR (16) NOT NULL,\n" +
                "    Money        DOUBLE       DEFAULT (50000) \n" +
                ");\n";
        db.execSQL(sql);

        sql = "INSERT INTO tblAccount(FullName, Passport_num, Email, Password, Money ) VALUES ('Minh Lý', '032456671524', 'admin2@gmail.com', '123456', 1000000)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
