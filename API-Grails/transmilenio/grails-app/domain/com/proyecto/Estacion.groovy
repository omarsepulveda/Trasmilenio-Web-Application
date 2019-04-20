package com.proyecto

class Estacion {
    static belongsTo = [troncal:Troncal]
    String nombre_estacion
    String imagen_estacion

    static constraints = {
    }
}
