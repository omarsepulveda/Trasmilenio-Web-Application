package com.transmilenio

import grails.rest.*

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Troncal {

    int id_troncal
    String letra_troncal
    String nombre_troncal
    String color_troncal

    static constraints = {
    }

    static mapping = {
        table 'portales'
        version false
        id_troncal column: 'id_troncal'
        letra_troncal column: 'letra_troncal'
        nombre_troncal column: 'nombre_troncal'
        color_troncal column: 'color_troncal' 
    }
    public String toString(){
       letra_troncal
    } 
}
