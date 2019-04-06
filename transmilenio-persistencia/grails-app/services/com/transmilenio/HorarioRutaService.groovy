package com.transmilenio

import grails.gorm.services.Service
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

@SuppressWarnings(['UnusedVariable', 'SpaceAfterOpeningBrace', 'SpaceBeforeClosingBrace'])
@CompileStatic
@Service(HorarioRuta)
interface HorarioRutaService {

    HorarioRuta get(Serializable id)

    List<HorarioRuta> list(Map args)

    Long count()

    void delete(Serializable id)

    HorarioRuta save(HorarioRuta horarioRuta)

}