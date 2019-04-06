package com.transmilenio
import grails.rest.*

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Nuevo {

    static constraints = {
    }

    static mapping = {
        table 'tipos_vehiculos'
        column: 'id_vehiculo'
        column: 'matricula'
        column: 'codigo_interno'
        column: 'id_tipo_vehiculo' 
    }
}
