package DataSqlLite

class Registros {
    abstract  class Resultados{
        companion object{
            val _ID ="_id"
            val _USER = "user"
            val _PASSWORD = "password"
            val _NAME = "name"
            val _APELLIDO = "password"
            val _CEDULA = "password"
            val _TABLE_NAME = "Persona"
            var historial: MutableList<Persona> = ArrayList()
        }
    }


}