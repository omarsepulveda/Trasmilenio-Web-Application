package com.transmilenio

import grails.rest.*

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Parada {

    int id_lugar_parada
    int vagon
    int plataforma
    int tipo_parada
    int id_ruta
    int id_estacion
    int id_paradero
    int id_portal

    static constraints = {
    }
}
