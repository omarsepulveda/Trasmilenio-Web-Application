package com.transmilenio

import grails.rest.*

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Direccion {

    int id_direccion
    String nombre_direccion
    int id_padre_direccion

    static constraints = {
    }

    static mapping = {
        table 'direcciones'
        id_direccion column: 'id_direccion'
        nombre_direccion column: 'nombre_direccion'
        id_padre_direccion column: 'id_padre_direccion'
    }
}
