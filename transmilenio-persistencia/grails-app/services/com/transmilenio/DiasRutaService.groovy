package com.transmilenio

import grails.gorm.services.Service
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

@SuppressWarnings(['UnusedVariable', 'SpaceAfterOpeningBrace', 'SpaceBeforeClosingBrace'])
@CompileStatic
@Service(DiasRuta)
interface DiasRutaService {

    DiasRuta get(Serializable id)

    List<DiasRuta> list(Map args)

    Long count()

    void delete(Serializable id)

    DiasRuta save(DiasRuta diasRuta)

}