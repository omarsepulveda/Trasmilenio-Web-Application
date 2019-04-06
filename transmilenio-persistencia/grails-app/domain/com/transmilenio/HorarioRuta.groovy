package com.transmilenio

import grails.rest.*

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class HorarioRuta {

    int id_horario_ruta
    String dias_semana
    int hora_inicial
    int hora_final
    int id_dias_ruta
    int id_ruta

    static constraints = {
    }
}
