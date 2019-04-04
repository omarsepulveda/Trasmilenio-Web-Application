package clases


import grails.rest.*

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Troncal {

    int id_troncal
    String letra_troncal
    String nombre_troncal
    String color_troncal

    static constraints = {
        // id_troncal nullable: false, size: 11
        // letra_troncal nullable: false, size:1
        // nombre_troncal nullable: false, size: 70
        // color_troncal nullable:false, size: 6
        
    }
    static mapping = {
        table 'troncales'
        version false
        id_troncal column: 'id_troncal'
        letra_troncal column: 'letra_troncal'
        nombre_troncal column: 'nombre_troncal'
        color_troncal column: 'color_troncal' 
    }

    public String toString(){
       nombre_troncal
    } 
}
