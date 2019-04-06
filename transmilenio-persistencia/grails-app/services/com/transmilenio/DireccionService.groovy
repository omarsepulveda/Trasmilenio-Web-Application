package com.transmilenio

import grails.gorm.services.Service
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

@SuppressWarnings(['UnusedVariable', 'SpaceAfterOpeningBrace', 'SpaceBeforeClosingBrace'])
@CompileStatic
@Service(Direccion)
interface DireccionService {

    Direccion get(Serializable id)

    List<Direccion> list(Map args)

    Long count()

    void delete(Serializable id)

    Direccion save(Direccion direccion)

}