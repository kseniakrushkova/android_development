package com.example.houseofcat.storage

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class HotelDbHelper(context: Context?):
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private val LOG_TAG = HotelDbHelper::class.java.simpleName
        private const val DATABASE_NAME = "hotel.db"
        private const val DATABASE_VERSION = 1
    }


    override fun onCreate(db: SQLiteDatabase) {
        val createGuests = ("CREATE TABLE " + HotelContract.GuestEntry.TABLE_NAME + " ("
                + HotelContract.GuestEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HotelContract.GuestEntry.NAME + " TEXT NOT NULL, "
                + HotelContract.GuestEntry.CITY + " TEXT NOT NULL, "
                + HotelContract.GuestEntry.GENDER + " INTEGER NOT NULL DEFAULT " + HotelContract.GuestEntry.GENDER_UNSET + ", "
                + HotelContract.GuestEntry.AGE + " INTEGER NOT NULL DEFAULT 0);")

        db.execSQL(createGuests)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.i("SQLite", "Upgrading ${HotelContract.GuestEntry}.TABLE_NAME from v$oldVersion to v$newVersion")

        if (db != null) {
            db.execSQL("DROP TABLE IF IT EXISTS ${HotelContract.GuestEntry}.TABLE_NAME")
            onCreate(db)
        } else
            Log.e(
                "SQLite",
                "Failed to upgrade ${HotelContract.GuestEntry}.TABLE_NAME from v$oldVersion to v$newVersion"
            )
    }
}
