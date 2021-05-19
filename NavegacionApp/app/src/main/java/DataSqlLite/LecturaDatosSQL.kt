package DataSqlLite

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import ec.edu.ups.navegacionapp.DatosPersonalesFragment
import ec.edu.ups.navegacionapp.HomeFragment

class LecturaDatosSQL(fragment: DatosPersonalesFragment): SQLiteOpenHelper(fragment.requireContext(), LecturaDatosSQL.DATABASE_NAME, null, LecturaDatosSQL.DATABASE_VERSION) {

    private val db: SQLiteDatabase
    private val values: ContentValues

    companion object{
        private val DATABASE_NAME = "registros"
        private  val DATABASE_VERSION = 1
    }

    init {
        db = this.writableDatabase
        values = ContentValues()
    }

    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun getData(): MutableList<Double>{
        Registros.Resultados.historial.clear()
        val itemIds = mutableListOf<Double>()
        val columnas = arrayOf(Registros.Resultados._ID)
        val c = db.query(Registros.Resultados._TABLE_NAME, columnas, null, null, null, null, null)
        if (c.moveToFirst()){
            do {
                itemIds.add(c.getDouble(0))
            }while (c.moveToNext())
        }


        return  itemIds
    }
}