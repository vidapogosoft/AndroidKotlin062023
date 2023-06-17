package com.android.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper


class AdminSQLiteOpenHelper(context: Context, name: String, factory: CursorFactory?, version: Int)
    : SQLiteOpenHelper(context, name, factory, version)
{

    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL(
            "create table articulos" +
                    "(secuencial INTEGER primary key autoincrement," +
                     "codigo INTEGER," +
                    "descripcion TEXT, precio REAL)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }


}