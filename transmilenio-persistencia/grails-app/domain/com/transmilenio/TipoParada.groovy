package com.transmilenio

import grails.rest.*

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class TipoParada {

    int id_tipo_parada
    String nombre_tipo_parada
    String imagen_tipo_parada
    int id_padre_tipo_parada

    static constraints = {
    }
}
