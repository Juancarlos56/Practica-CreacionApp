package DataSqlLite

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import ec.edu.ups.navegacionapp.DatosPersonalesFragment
import ec.edu.ups.navegacionapp.HomeFragment

class DataSQL(fragment: HomeFragment):SQLiteOpenHelper(fragment.requireContext(), DATABASE_NAME, null, DATABASE_VERSION) {
    private val db:SQLiteDatabase
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
        db!!.execSQL("CREATE TABLE "+Registros.Resultados._TABLE_NAME
                        +"("+Registros.Resultados._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            Registros.Resultados._NAME+ " TEXT NOT NULL, "+
                            Registros.Resultados._APELLIDO+ " TEXT NOT NULL, "+
                            Registros.Resultados._CEDULA+ " TEXT NOT NULL, "+
                            Registros.Resultados._USER+ " TEXT NOT NULL, "+
                            Registros.Resultados._PASSWORD+ " TEXT NOT NULL)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insert(nombre: String, apellido: String, cedula: String, user: String, password: String){
        values.put(Registros.Resultados._NAME, nombre)
        values.put(Registros.Resultados._APELLIDO, apellido)
        values.put(Registros.Resultados._CEDULA, cedula)
        values.put(Registros.Resultados._USER, user)
        values.put(Registros.Resultados._PASSWORD, password)

        db.insert(Registros.Resultados._TABLE_NAME, null, values)
    }

    fun checkUser(username: String, password: String): Boolean {

        val columnas = arrayOf(Registros.Resultados._NAME,
            Registros.Resultados._APELLIDO,
            Registros.Resultados._CEDULA,
            Registros.Resultados._USER,
            Registros.Resultados._PASSWORD)
        // selection criteria
        val selection = "${Registros.Resultados._USER} = ? AND ${Registros.Resultados._PASSWORD} = ?"

        // selection arguments
        val selectionArgs = arrayOf(username, password)

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'viral@exmaple.com' AND user_password = 'qwerty';
         */
        val cursor = db.query(Registros.Resultados._TABLE_NAME,
            columnas, //columns to return
            selection, //columns for the WHERE clause
            selectionArgs, //The values for the WHERE clause
            null,  //group the rows
            null, //filter by row groups
            null) //The sort order

        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0)
            return true

        return false

    }

    fun getData(): MutableList<Persona>{
        Registros.Resultados.historial.clear()
        val itemIds = mutableListOf<Persona>()
        val columnas = arrayOf(Registros.Resultados._NAME,
                                Registros.Resultados._APELLIDO,
                                Registros.Resultados._CEDULA,
                                Registros.Resultados._USER,
                                Registros.Resultados._PASSWORD)

        val c = db.query(Registros.Resultados._TABLE_NAME, columnas, null, null, null, null, null)
        if (c.moveToFirst()){
            do {

                var persona = Persona(c.getString(0),
                    c.getString(1),
                    c.getString(2),
                    c.getString(3),
                    c.getString(4),


                )
                itemIds.add(persona)
            }while (c.moveToNext())
        }


        return  itemIds
    }

}