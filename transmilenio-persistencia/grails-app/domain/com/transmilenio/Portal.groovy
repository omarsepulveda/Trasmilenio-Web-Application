package com.transmilenio

import grails.rest.*
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Portal {

    static mapWith = "mysql"
    
    int id_portal
    String nombre_portal
    String imagen_portal
    int id_troncal

    static constraints = {
    }
    
   
}
