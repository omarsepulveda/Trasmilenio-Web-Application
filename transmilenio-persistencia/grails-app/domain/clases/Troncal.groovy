package clases


import grails.rest.*

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Troncal {

    static mapWith = "mysql"

    int id_troncal
    String letra_troncal
    String nombre_troncal
    String color_troncal

    static constraints = {
    }

    public String toString(){
       nombre_troncal
    } 
}
