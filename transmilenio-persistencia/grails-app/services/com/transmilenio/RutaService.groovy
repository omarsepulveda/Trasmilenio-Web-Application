package com.transmilenio

import grails.gorm.services.Service
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

@SuppressWarnings(['UnusedVariable', 'SpaceAfterOpeningBrace', 'SpaceBeforeClosingBrace'])
@CompileStatic
@Service(Ruta)
interface RutaService {

    Ruta get(Serializable id)

    List<Ruta> list(Map args)

    Long count()

    void delete(Serializable id)

    Ruta save(Ruta ruta)

}