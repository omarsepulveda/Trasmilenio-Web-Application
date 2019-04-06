package com.transmilenio

import grails.rest.*

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Ruta {

    int id_ruta
    String codigo_ruta
    String nombre_ruta
    String descripcion_ruta
    int id_tipo_ruta

    static constraints = {
    }
}
