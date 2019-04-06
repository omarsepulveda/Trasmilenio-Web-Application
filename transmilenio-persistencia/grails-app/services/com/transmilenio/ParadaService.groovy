package com.transmilenio

import grails.gorm.services.Service
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

@SuppressWarnings(['UnusedVariable', 'SpaceAfterOpeningBrace', 'SpaceBeforeClosingBrace'])
@CompileStatic
@Service(Parada)
interface ParadaService {

    Parada get(Serializable id)

    List<Parada> list(Map args)

    Long count()

    void delete(Serializable id)

    Parada save(Parada parada)

}