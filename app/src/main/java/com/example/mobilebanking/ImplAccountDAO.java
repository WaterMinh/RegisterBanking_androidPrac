package com.example.mobilebanking;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ImplAccountDAO implements IAccountDAO {
    private Context context;
    private SQLiteDatabase db;

    public ImplAccountDAO(Context mCtx) {
        this.context = mCtx;
    }


    @Override
    public boolean insert(Account account) {
        DatabaseHelper helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();

        //create content values to insert
        ContentValues values = new ContentValues();
        values.put("Fullname", account.getFullname());
        values.put("Passport_num", account.getPassport_num());
        values.put("Email", account.getEmail());
        values.put("Password", account.getPassword());

        long newID = db.insert("tblAccount",null,values);
        if (newID>0){
            return true;
        }
        return false;
    }
}
