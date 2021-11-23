package com.example.houseofcat

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.houseofcat.storage.HotelContract
import com.example.houseofcat.storage.HotelDbHelper
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity: AppCompatActivity() {
    private lateinit var dbHelper: HotelDbHelper

    private lateinit var dbDataTextView: TextView


    private fun displayDatabaseInfo() {
        val db: SQLiteDatabase = dbHelper.readableDatabase
        val projection = arrayOf(
            HotelContract.GuestEntry._ID,
            HotelContract.GuestEntry.NAME,
            HotelContract.GuestEntry.CITY,
            HotelContract.GuestEntry.GENDER,
            HotelContract.GuestEntry.AGE
        )
        val cursor: Cursor = db.query(
            HotelContract.GuestEntry.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null
        )

        cursor.use {
            dbDataTextView.text =
                getString(R.string.guest_quantity).format(it.count)
            dbDataTextView.append(
                "\n\n" +
                        HotelContract.GuestEntry._ID + " - " +
                        HotelContract.GuestEntry.NAME + " - " +
                        HotelContract.GuestEntry.CITY + " - " +
                        HotelContract.GuestEntry.GENDER + " - " +
                        HotelContract.GuestEntry.AGE + "\n"
            )

            val idColumnIndex: Int = it.getColumnIndex(HotelContract.GuestEntry._ID)
            val nameColumnIndex: Int = it.getColumnIndex(HotelContract.GuestEntry.NAME)
            val cityColumnIndex: Int = it.getColumnIndex(HotelContract.GuestEntry.CITY)
            val genderColumnIndex: Int = it.getColumnIndex(HotelContract.GuestEntry.GENDER)
            val ageColumnIndex: Int = it.getColumnIndex(HotelContract.GuestEntry.AGE)

            while (it.moveToNext()) {
                val currentID: Int = it.getInt(idColumnIndex)
                val currentName: String = it.getString(nameColumnIndex)
                val currentCity: String = it.getString(cityColumnIndex)
                val currentGender: Int = it.getInt(genderColumnIndex)
                val currentAge: Int = it.getInt(ageColumnIndex)

                dbDataTextView.append(
                    (("\n" + currentID + " - " +
                            currentName + " - " +
                            currentCity + " - " +
                            currentGender + " - " +
                            currentAge))
                )
            }
        }
    }


    private fun clearDatabase() {
        val db = dbHelper.writableDatabase

        db.delete(HotelContract.GuestEntry.TABLE_NAME, null, null)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))

        dbHelper = HotelDbHelper(this)
        dbDataTextView = findViewById(R.id.db_data_text_view)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this@MainActivity, EditorActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onStart() {
        super.onStart()

        displayDatabaseInfo()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_clear -> {
                clearDatabase()
                displayDatabaseInfo()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
