package com.transmilenio

import grails.rest.*

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Paradero {

    int id_paradero
    String codigo_paradero
    int id_direccion

    static constraints = {
    }
}
