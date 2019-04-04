package com.transmilenio

import grails.rest.*

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Vehiculo {

    int id_vehiculo
    String matricula
    String codigo_interno
    int id_tipo_vehiculo

    // static constraints = {
    //     matricula nullable: false, size:6
    //     codigo_interno nullable: false, size: 6
    //     tipo_vehiculo nullable:false, size: 11
    // }
    
    static mapping = {
        table 'vehiculos'
        version false
        id_vehiculo column: 'id_vehiculo'
        matricula column: 'matricula'
        codigo_interno column: 'codigo_interno'
        id_tipo_vehiculo column: 'id_tipo_vehiculo' 
    }
    // static map={
    //     def p = new Vehiculo(matricula: "ABC123", codigo_interno: "UTR84", tipo_vehiculo: 1)
    //     p.save()
    // }

    public String toString(){
       matricula
    } 
    
}
