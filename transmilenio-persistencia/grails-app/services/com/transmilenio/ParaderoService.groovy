package com.transmilenio

import grails.gorm.services.Service
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

@SuppressWarnings(['UnusedVariable', 'SpaceAfterOpeningBrace', 'SpaceBeforeClosingBrace'])
@CompileStatic
@Service(Paradero)
interface ParaderoService {

    Paradero get(Serializable id)

    List<Paradero> list(Map args)

    Long count()

    void delete(Serializable id)

    Paradero save(Paradero paradero)

}