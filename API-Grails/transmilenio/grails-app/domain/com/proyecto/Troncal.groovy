package com.proyecto

class Troncal {
    static hasMany = [estaciones:Estacion]
    String letra_troncal
    String nombre_troncal
    String color_troncal

    static constraints = {
       letra_troncal nullable:false
       nombre_troncal nullable:false
       color_troncal nullable:false
    }
}
