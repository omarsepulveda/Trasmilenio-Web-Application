package com.transmilenio

import grails.gorm.services.Service
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

@SuppressWarnings(['UnusedVariable', 'SpaceAfterOpeningBrace', 'SpaceBeforeClosingBrace'])
@CompileStatic
@Service(Estacion)
interface EstacionService {

    Estacion get(Serializable id)

    List<Estacion> list(Map args)

    Long count()

    void delete(Serializable id)

    Estacion save(Estacion estacion)

}