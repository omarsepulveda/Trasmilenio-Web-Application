package com.transmilenio

import grails.rest.*

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class TipoRuta {

    int id_tipo_ruta
    String nombre_tipo_ruta
    String color_tipo_ruta

    static constraints = {
    }
}
