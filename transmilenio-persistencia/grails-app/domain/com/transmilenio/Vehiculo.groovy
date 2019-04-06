package com.transmilenio

import grails.rest.*

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Vehiculo {

    int id_vehiculo
    String matricula
    String codigo_interno
    int id_tipo_vehiculo

    static constraints = {
    //     matricula nullable: false, size:6
    //     codigo_interno nullable: false, size: 6
    //     tipo_vehiculo nullable:false, size: 11
    }
    
    // static mapping = {
    //     table 'vehiculos'
    //     id_vehiculo column: 'id_vehiculo'
    //     matricula column: 'matricula'
    //     codigo_interno column: 'codigo_interno'
    //     id_tipo_vehiculo column: 'id_tipo_vehiculo' 
    // }

    // public String toString(){
    //    matricula
    // } 
    
}
