package com.transmilenio

import grails.rest.*

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Estacion {

    int id_estacion
    String nombre_estacion
    String imagen_estacion
    int id_troncal

    static constraints = {
    }
}
