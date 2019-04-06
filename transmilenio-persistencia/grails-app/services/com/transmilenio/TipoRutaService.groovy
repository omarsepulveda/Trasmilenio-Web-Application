package com.transmilenio

import grails.gorm.services.Service
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

@SuppressWarnings(['UnusedVariable', 'SpaceAfterOpeningBrace', 'SpaceBeforeClosingBrace'])
@CompileStatic
@Service(TipoRuta)
interface TipoRutaService {

    TipoRuta get(Serializable id)

    List<TipoRuta> list(Map args)

    Long count()

    void delete(Serializable id)

    TipoRuta save(TipoRuta tipoRuta)

}