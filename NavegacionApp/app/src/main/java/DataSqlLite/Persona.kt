package DataSqlLite

class Persona (name: String,
               lastname: String,
               DNI: String,
               username: String,
               password: String
               ){

    var nombre: String = name
        get() = field
        set(valor){
            field = valor
        }
    var apellido: String = lastname
        get() = field
        set(valor){
            field = valor
        }
    var cedula: String = DNI
        get() = field
        set(valor){
            field = valor
        }
    var user: String = username
        get() = field
        set(valor){
            field = valor
        }
    var contrasena: String = password
        get() = field
        set(valor){
            field = valor
        }
}