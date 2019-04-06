package com.transmilenio

import grails.rest.*

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class TipoVehiculo {

    int id_tipo_vehiculo
    String nombre_tipo_vehiculo
    String descripcion_tipo_vehiculo
    String imagen_tipo_vehiculo

    static constraints = {
    }

}
