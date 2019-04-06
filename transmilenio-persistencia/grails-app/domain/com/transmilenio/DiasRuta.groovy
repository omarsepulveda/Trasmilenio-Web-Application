package com.transmilenio

import grails.rest.*

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class DiasRuta {

    int id_dias_ruta
    String nombre_dias_ruta
    String siglas_dias_ruta

    static constraints = {
    }

    static mapping = {
        table 'dias_rutas'
        id_dias_ruta column: 'id_dias_ruta'
        nombre_dias_ruta column: 'nombre_dias_ruta'
        siglas_dias_ruta column: 'siglas_dias_ruta'
    }
}
